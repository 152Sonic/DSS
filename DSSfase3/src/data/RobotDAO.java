package data;

import business.Palete;
import business.Robot;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RobotDAO implements Map<Integer, Robot> {
    private static RobotDAO singleton = null;

    private RobotDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS robot (" +
                    "codRobot int NOT NULL PRIMARY KEY," +
                    "xRobot int DEFAULT NULL," +
                    "yRobot int DEFAULT NULL," +
                    "aTransp int DEFAULT NULL," +
                    "localizacaoXRobot int DEFAULT NULL," +
                    "localizacaoYRobot int DEFAULT NULL," +
                    "entregue int DEFAULT NULL)";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static RobotDAO getInstance() {
        if (RobotDAO.singleton == null) {
            RobotDAO.singleton = new RobotDAO();
        }
        return RobotDAO.singleton;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Robot get(Object key) {
        Robot a = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM robot WHERE codRobot='"+key+"'")) {
            if (rs.next()) {  // A chave existe na tabela
                // Reconstruir o aluno com os dados obtidos da BD - a chave estranjeira da turma, não é utilizada aqui.
                a = new Robot(rs.getInt("codRobot"), rs.getInt("xRobot"), rs.getInt("yRobot"),rs.getInt("aTransp"),rs.getInt("localizacaoXRobot"),rs.getInt("localizacaoYRobot"),rs.getInt("entregue"));
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return a;
    }

    @Override
    public Robot put(Integer key, Robot r) {
        Robot res = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate(
                    "INSERT INTO robot VALUES ('"+r.getCodRobot()+"', '"+r.getxRobot()+"', '"+r.getyRobot()+ "', '" +r.getaTranpos()+"', '"+r.getLocalizacaoXFinal()+"', '"+r.getLocalizacaoYFinal()+"', '"+r.getEntregue()+"')" +
                            "ON DUPLICATE KEY UPDATE xRobot=VALUES(xRobot), yRobot=VALUES(yRobot), aTransp =VALUES(aTransp), localizacaoXRobot = VALUES(localizacaoXRobot),localizacaoYRobot =VALUES(localizacaoYRobot), entregue= VALUES(entregue)");
        }
        catch (Exception e){
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public Robot remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Robot> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Integer> keySet() {
        return null;
    }

    @Override
    public Collection<Robot> values() {
        Collection<Robot> res = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT codRobot FROM robot")) { // ResultSet com os ids de todas as turmas
            while (rs.next()) {
                String idt = rs.getString("codRobot"); // Obtemos um id de turma do ResultSet
                Robot t = this.get(idt);                    // Utilizamos o get para construir as turmas uma a uma
                res.add(t);                                 // Adiciona a turma ao resultado.
            }
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Robot>> entrySet() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}


