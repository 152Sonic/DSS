package data;
import business.Prateleira;

import java.sql.*;
import java.util.*;

public class PrateleirasDAO implements Map<Integer, Prateleira> {
        private static PrateleirasDAO singleton = null;


        private PrateleirasDAO() {
            try (Connection conn =
                         DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS prateleiras (" +
                        "codPrateleira int NOT NULL PRIMARY KEY," +
                        "disponibilidade int DEFAULT NULL," +
                        "codPalete int DEFAULT NULL," +
                        "x int  DEFAULT NULL," +
                        "y int  DEFAULT NULL)";
                stm.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
        }

    /**
     * Implementação do Singleton
     *
     * @return instância única desta classe
     */
        public static PrateleirasDAO getInstance() {
            if (PrateleirasDAO.singleton == null) {
                PrateleirasDAO.singleton = new PrateleirasDAO();
            }
            return PrateleirasDAO.singleton;
        }

    /**
     * Método que insere uma prateleira na base de dados
     * @param key Código da prateleira
     * @param a Prateleira
     * @return Prateleira
     */
        public Prateleira put(Integer key, Prateleira a) {
            Prateleira res = null;
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement()) {
                // Actualizar o palete
                stm.executeUpdate("INSERT INTO prateleiras VALUES ('"+a.getCodPrateleira()+"', '"+a.isDisponibilidade()+"', '"+a.getCodPal()+ "', '" +a.getX()+"', '"+a.getY()+"') "  +
                        "ON DUPLICATE KEY UPDATE disponibilidade=VALUES(disponibilidade), codPalete=VALUES(codPalete), x =VALUES(x), y = VALUES(y)");
            } catch (SQLException e) {
                // Database error!
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return res;
        }

    /**
     * Método que devolve um conjunto de pares com prateleira e o respetivo código
     * @return Conjunto com prateleira e o seu código
     */
        public Set<Entry<Integer, Prateleira>> entrySet() {
            Set<Entry<Integer,Prateleira>> r = new HashSet<>();
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement();
                 ResultSet rs = stm.executeQuery("SELECT * from prateleiras")){
                while(rs.next()){
                    r.add(new AbstractMap.SimpleEntry<>(rs.getInt("codPrateleira"),this.get(rs.getInt("codPrateleira"))));
                }
            }
            catch (Exception e){
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return r;
        }


        public int size() {
            return 0;
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
     * Obtem-se uma prateleira, dado o seu código
     * @param key Código da prateleira
     * @return Palete
     */
        public Prateleira get(Object key) {
            Prateleira a = null;
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement();
                 ResultSet rs = stm.executeQuery("SELECT * FROM prateleiras WHERE codPrateleira='"+key+"'")) {
                if (rs.next()) {  // A chave existe na tabela
                    // Reconstruir o aluno com os dados obtidos da BD - a chave estranjeira da turma, não é utilizada aqui.
                    a = new Prateleira(rs.getInt("codPrateleira"), rs.getInt("disponibilidade"), rs.getInt("codPalete"),rs.getInt("x"),rs.getInt("y"));
                }
            } catch (SQLException e) {
                // Database error!
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return a;
        }


        public Prateleira remove(Object key) {
            return null;
        }


        public void putAll(Map<? extends Integer, ? extends Prateleira> m) {

        }


        public void clear() {

        }

    /**
     * Devolve o conjunto dos códigos das prateleiras que estão na base de dados
     * @return Conjunto dos códigos
     */
        public Set<Integer> keySet() {
            return null;
        }

        public Collection<Prateleira> values() {
            Collection<Prateleira> res = new HashSet<>();
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement();
                 ResultSet rs = stm.executeQuery("SELECT codPrateleira FROM prateleiras")) { // ResultSet com os ids de todas as turmas
                while (rs.next()) {
                    String idt = rs.getString("codPrateleira"); // Obtemos um id de turma do ResultSet
                    Prateleira t = this.get(idt);                    // Utilizamos o get para construir as turmas uma a uma
                    res.add(t);                                 // Adiciona a turma ao resultado.
                }
            } catch (Exception e) {
                // Database error!
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return res;
        }


    }
