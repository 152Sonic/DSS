/*package data;
import business.Localizacao;
import business.Palete;
import java.sql.*;
import java.util.*;

public class PaletesDAO implements Map<String,Palete> {
    private static PaletesDAO singleton = null;

    private PaletesDAO(){
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
        Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS localizacao (" +
                    "x int NOT NULL PRIMARY KEY," +
                    "y int NOT NULL PRIMARY KEY DEFAULT 0)";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS paletes (" +
                    "codPaletes varchar(10) NOT NL PRIMARY KEY," +
                    "localizacao DEFAULT NULL," +
                    "transporte char(1) DEFAULT NULL," +
                    "materialP varchar(100), foreign key(Localizacao) references localizacao(x,y))";  // Assume-se uma relação 1-n entre Turma e Aluno
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static PaletesDAO getInstance() {
        if (PaletesDAO.singleton == null) {
            PaletesDAO.singleton = new PaletesDAO();
        }
        return PaletesDAO.singleton;
    }

    public int size() {
        int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM paletes")) {
            if(rs.next()) {
                i = rs.getInt(1);
            }
        }
        catch (Exception e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return i;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean containsKey(Object key) {
        boolean r;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs =
                     stm.executeQuery("SELECT codPaletes FROM paletes WHERE =codPaletes = '"+key.toString()+"'")) {
            r = rs.next();
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return r;
    }

        public boolean containsValue(Object value) {
            Palete a = (Palete) value;
            return this.containsKey(a.getCodPalete());
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
                p = new Palete(rs.getString("codPaletes"), l, rs.getBoolean("Transporte"),rs.getString("Material"));
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return p;
    }

    public Palete put(String key, Palete a) {
        Palete res = null;
        Localizacao l = a.getLocalizacao();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            // Actualizar o localização
            stm.executeUpdate(
                    "INSERT INTO localizacao " +
                            "VALUES ('"+ l.getX()+ "', "+
                                         l.getY()+") " +
                            "ON DUPLICATE KEY UPDATE X = Values(X), " +
                                                    "Y = Values(Y)");

            // Actualizar o palete
            stm.executeUpdate(
                    "INSERT INTO paletes" +
                            "VALUES ('"+ a.getCodPalete()+ "', '"+
                                         a.getLocalizacao()+"', '" +
                                         a.isTransporte()+ "', "+
                                         a.getMateriaP()+") " +
                            "ON DUPLICATE KEY UPDATE codPalete=VALUES(codPalete), " +
                                                    "Material=VALUES(Material)");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
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

    public void putAll(Map<? extends String, ? extends Palete> palete) {
        for(Palete p : palete.values()) {
            this.put(p.getCodPalete(), p);
        }
    }

    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("TRUNCATE paletes");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    //HNNNNNNNNNNNNNNNNN
    public Set<String> keySet() {
        throw new NullPointerException("Not implemented!");
    }

    public Collection<Palete> values() {
        Collection<Palete> res = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT codPalete FROM paletes")) {
            while (rs.next()) {
                String idt = rs.getString("Id");
                Palete p = this.get(idt);
                res.add(p);
            }
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    //HNNNNNNNNNNNNNNNNN
    public Set<Entry<String, Palete>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }



}*/
