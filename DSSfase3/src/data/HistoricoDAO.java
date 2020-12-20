package data;

import business.Localizacao;
import business.Palete;
import business.Prateleira;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HistoricoDAO implements Map<Integer,Palete> {
    private static HistoricoDAO singleton = null;

    private HistoricoDAO(){
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

    public static HistoricoDAO getInstance() {
        if (HistoricoDAO.singleton == null) {
            HistoricoDAO.singleton = new HistoricoDAO();
        }
        return HistoricoDAO.singleton;
    }

    //Necessitamos do size, put

    public int size() {
        int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM historico")) {
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
                            a.getMateriaP()+") ");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }


    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public Palete get(Object key) {
        return null;
    }

    public Palete remove(Object key) {
        return null;
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

    public Set<Entry<Integer, Palete>> entrySet() {
        return null;
    }
}
