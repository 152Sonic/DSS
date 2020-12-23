package data;
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
            String sql = "CREATE TABLE IF NOT EXISTS paletes (" +
                    "codPaletes int NOT NULL PRIMARY KEY," +
                    "x int DEFAULT NULL," +
                    "y int DEFAULT NULL," +
                    "transporte int DEFAULT NULL," +
                    "materialP varchar(100))";  // Assume-se uma relação 1-n entre Turma e Aluno
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }


    /**
     * Implementação do Singleton
     *
     * @return instância única desta classe
     */
    public static PaletesDAO getInstance() {
        if (PaletesDAO.singleton == null) {
            PaletesDAO.singleton = new PaletesDAO();
        }
        return PaletesDAO.singleton;
    }

    /**
     * Método que remove uma palete, dado o seu código
     * @param key Código da palete a remover
     * @return a palete removida
     */
    public Palete remove(Object key) {
        Palete t = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("DELETE FROM paletes WHERE codPaletes='"+key+"'");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return t;
    }

    /**
     * Obtem-se uma palete, dado o seu código
     * @param key Código da palete
     * @return Palete
     */
    public Palete get(Object key) {
        Palete a = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM paletes WHERE codPaletes='"+key+"'")) {
            if (rs.next()) {  // A chave existe na tabela
                // Reconstruir o aluno com os dados obtidos da BD - a chave estranjeira da turma, não é utilizada aqui.
                a = new Palete(rs.getInt("codPaletes"), rs.getInt("x"), rs.getInt("y"),rs.getInt("transporte"),rs.getString("materialP"));
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return a;
    }

    /**
     * Método que devolve um conjunto de pares com palete e o respetivo código
     * @return Conjunto com palete e o seu código
     */
    public Set<Entry<Integer, Palete>> entrySet() {
        Set<Entry<Integer,Palete>> r = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * from paletes")){
            while(rs.next()){
                r.add(new AbstractMap.SimpleEntry<>(rs.getInt("codPaletes"),this.get(rs.getInt("codPaletes"))));
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return r;
    }

    /**
     * Método que insere uma palete na base de dados
     * @param key Código da palete
     * @param a Palete
     * @return Palete
     */
    public Palete put(Integer key, Palete a) {
        Palete res = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            // Actualizar o palete
            stm.executeUpdate(
                    "INSERT INTO paletes VALUES ('"+a.getCodPalete()+"', '"+a.getX()+"', '"+a.getY()+ "', '" +a.isTransporte()+"', '"+a.getMateriaP()+"') "  +
                        "ON DUPLICATE KEY UPDATE x=VALUES(x), y=VALUES(y), transporte =VALUES(transporte), materialP = VALUES(materialP)");
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


    /**
     * Devolve todas as paletes da base de dados
     * @return Collection<Palete>
     */
    public Collection<Palete> values() {
        Collection<Palete> res = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT codPaletes FROM paletes")) { // ResultSet com os ids de todas as turmas
            while (rs.next()) {
                String idt = rs.getString("codPaletes"); // Obtemos um id de turma do ResultSet
                Palete t = this.get(idt);                    // Utilizamos o get para construir as turmas uma a uma
                res.add(t);                                 // Adiciona a turma ao resultado.
            }
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
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
