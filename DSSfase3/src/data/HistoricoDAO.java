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
            String sql = "CREATE TABLE IF NOT EXISTS historico (" +
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
    public static HistoricoDAO getInstance() {
        if (HistoricoDAO.singleton == null) {
            HistoricoDAO.singleton = new HistoricoDAO();
        }
        return HistoricoDAO.singleton;
    }


    /**
     * Dá-nos o tamanho da amostra
     * @return número de paletes referentes ao histórico na base de dados
     */
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

    /**
     * Método que insere uma palete referente ao histórico na base de dados
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
                    "INSERT INTO historico VALUES ('"+a.getCodPalete()+"', '"+a.getX()+"', '"+a.getY()+ "', '" +a.isTransporte()+"', '"+a.getMateriaP()+"')" +
                           "ON DUPLICATE KEY UPDATE x=VALUES(x), y=VALUES(y), transporte =VALUES(transporte), materialP = VALUES(materialP)");
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


    /**
     * Obtem-se uma palete referente ao histórico, dado o seu código
     * @param key Código da palete
     * @return Palete
     */
    public Palete get(Object key) {
        Palete a = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM historico WHERE codPaletes='"+key+"'")) {
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


    /**
     * Devolve todas as paletes referentes ao histórico da base de dados
     * @return Todas as paletes
     */
    public Collection<Palete> values() {
        Collection<Palete> res = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT codPaletes FROM historico")) { // ResultSet com os ids de todas as turmas
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


    public Set<Entry<Integer, Palete>> entrySet() {
        return null;
    }
}
