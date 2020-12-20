package data;
import business.Localizacao;
import business.Palete;
import java.sql.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class PaletesDAO implements Map<Integer,Palete> {
    private static PaletesDAO singleton = null;

    private PaletesDAO(){
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
        Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS localizacao (" +
                    "x int NOT NULL PRIMARY KEY," +
                    "y int NOT NULL PRIMARY KEY DEFAULT 0)";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS paletes (" +
                    "codPaletes int NOT NL PRIMARY KEY," +
                    "localizacao DEFAULT NULL," +
                    "transporte int DEFAULT NULL," +
                    "materialP varchar(100), foreign key(Localizacao) references localizacao(x,y))";  // Assume-se uma relação 1-n entre Turma e Aluno
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    //NEcessitamos do put, entryset, remove, get

    public static PaletesDAO getInstance() {
        if (PaletesDAO.singleton == null) {
            PaletesDAO.singleton = new PaletesDAO();
        }
        return PaletesDAO.singleton;
    }

    public Palete remove(Object key) {
        Palete t = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             PreparedStatement pstm = conn.prepareStatement("UPDATE alunos SET Turma=? WHERE Num=?")) {
            // apagar a palete
            stm.executeUpdate("DELETE FROM paletes WHERE codPalete='" + key + "'");
        }catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return t;
    }

    public Palete get(Object key) {
        Palete p = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM paletes WHERE codPalete='"+key+"'")) {
            if (rs.next()) {  // A chave existe na tabela
                Localizacao l = null;
                String sql = "SELECT * FROM localizacao WHERE codPalete='"+rs.getString("Localizacao")+"'";
                try (ResultSet rsa = stm.executeQuery(sql)) {
                    if (rsa.next()) {  // Encontrou a palete
                        l = new Localizacao(rs.getInt("X"),
                                rsa.getInt("Y"));
                    } else {
                        l = null;
                    }
                }
                p = new Palete(rs.getInt("codPaletes"), l, rs.getInt("Transporte"),rs.getString("Material"));
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return p;
    }

    //HNNNNNNNNNNNNNNNNN
    public Set<Entry<Integer, Palete>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }

    public Palete put(Integer key, Palete a) {
        Palete res = null;
        Localizacao l = a.getLocalizacao();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            // Actualizar o localização
            stm.executeUpdate(
                    "INSERT INTO localizacao " +
                            "VALUES ('"+ l.getX()+ "', "+
                            l.getY()+")");

            // Actualizar o palete
            stm.executeUpdate(
                    "INSERT INTO paletes" +
                            "VALUES ('"+ a.getCodPalete()+ "', '"+
                            a.getLocalizacao()+"', '" +
                            a.isTransporte()+ "', "+
                            a.getMateriaP()+")");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    public boolean remove(Object key, Object value) {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }


    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void putAll(Map<? extends Integer, ? extends Palete> m) {

    }

    public void clear() {

    }

    public Set<Integer> keySet() {
        return null;
    }

    public Collection<Palete> values() {
        return null;
    }

    public Palete getOrDefault(Object key, Palete defaultValue) {
        return null;
    }

    public void forEach(BiConsumer<? super Integer, ? super Palete> action) {

    }

    public void replaceAll(BiFunction<? super Integer, ? super Palete, ? extends Palete> function) {

    }

    public Palete putIfAbsent(Integer key, Palete value) {
        return null;
    }


    public boolean replace(Integer key, Palete oldValue, Palete newValue) {
        return false;
    }

    public Palete replace(Integer key, Palete value) {
        return null;
    }

    public Palete computeIfAbsent(Integer key, Function<? super Integer, ? extends Palete> mappingFunction) {
        return null;
    }

    public Palete computeIfPresent(Integer key, BiFunction<? super Integer, ? super Palete, ? extends Palete> remappingFunction) {
        return null;
    }

    public Palete compute(Integer key, BiFunction<? super Integer, ? super Palete, ? extends Palete> remappingFunction) {
        return null;
    }

    public Palete merge(Integer key, Palete value, BiFunction<? super Palete, ? super Palete, ? extends Palete> remappingFunction) {
        return null;
    }

}
