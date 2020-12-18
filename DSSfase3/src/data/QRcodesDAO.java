package data;

import business.QRcode;

import java.sql.*;
import java.util.*;

public class QRcodesDAO implements Map<String, QRcode> {
    private static QRcodesDAO singleton = null;


    private QRcodesDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS QRcodes (" +
                    "Cod varchar(10) NOT NULL PRIMARY KEY," +
                    "MateriaP varchar(45) DEFAULT NULL,";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static QRcodesDAO getInstance() {
        if (QRcodesDAO.singleton == null) {
            QRcodesDAO.singleton = new QRcodesDAO();
        }
        return QRcodesDAO.singleton;
    }

    public int size() {
        int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM QRcodes")) {
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
                     stm.executeQuery("SELECT Cod FROM QRcodes WHERE Cod='"+key.toString()+"'")) {
            r = rs.next();
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return r;
    }

    public boolean containsValue(Object value) {
        QRcode a = (QRcode) value;
        return this.containsKey(a.getCod());
    }

    public QRcode get(Object key) {
        QRcode a = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM QRcodes WHERE Cod='"+key+"'")) {
            if (rs.next()) {  // A chave existe na tabela
                // Reconstruir o QRcode com os dados obtidos da BD -
                a = new QRcode(rs.getString("Cod"), rs.getString("MateriaP"));
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return a;
    }

    public QRcode put(String key, QRcode a) {
        QRcode res = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {

            // Actualizar o QRcode
            stm.executeUpdate(
                    "INSERT INTO QRcodes VALUES ('"+a.getCod()+"', '"+a.getMateriaP()+"')" +
                            "ON DUPLICATE KEY UPDATE MateriaP=VALUES(MateriaP)");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    public QRcode remove(Object key) {
        QRcode t = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("DELETE FROM QRcodes WHERE Cod='" + key + "'");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return t;
    }

    public void putAll(Map<? extends String, ? extends QRcode> QRcodes) {
        for(QRcode a : QRcodes.values()) {
            this.put(a.getCod(), a);
        }
    }

    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("TRUNCATE QRcodes");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }
}

