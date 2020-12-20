package data;
import business.Localizacao;
import business.Palete;
import business.Prateleira;

import java.sql.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

    public class PrateleirasDAO implements Map<Integer, Prateleira> {
        private static PrateleirasDAO singleton = null;


        private PrateleirasDAO() {
            try (Connection conn =
                         DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS localizacao (" +
                        "x int NOT NULL PRIMARY KEY," +
                        "y int NOT NULL PRIMARY KEY DEFAULT 0)";
                stm.executeUpdate(sql);
                sql = "CREATE TABLE IF NOT EXISTS gestores (" +
                        "codPrateleira int NOT NULL PRIMARY KEY," +
                        "disponibilidade boolean DEFAULT NULL," +
                        "codPalete int DEFAULT NULL," +
                        "local  DEFAULT NULL," +
                        "foreign key(Localizacao) references localizacao(x,y))";
                stm.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
        }

        public static PrateleirasDAO getInstance() {
            if (PrateleirasDAO.singleton == null) {
                PrateleirasDAO.singleton = new PrateleirasDAO();
            }
            return PrateleirasDAO.singleton;
        }

        //Necessitamos do put, entrySet,

        public Prateleira put(Integer key, Prateleira a) {
            Prateleira res = null;
            Localizacao l = a.getLocal();
            try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
                 Statement stm = conn.createStatement()) {
                // Actualizar o localização
                stm.executeUpdate(
                        "INSERT INTO localizacao " +
                                "VALUES ('"+ l.getX()+ "', "+
                                l.getY()+") ");

                // Actualizar o palete
                stm.executeUpdate(
                        "INSERT INTO prateleira" +
                                "VALUES ('"+ a.getCodPrateleira()+ "', '"+
                                a.isDisponibilidade()+"', '" +
                                a.getCodPal()+ "', "+
                                a.getLocal()+") ");
            } catch (SQLException e) {
                // Database error!
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return res;
        }

        public Set<Entry<Integer, Prateleira>> entrySet() {
            return null;
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

        public Prateleira get(Object key) {
            return null;
        }

        public Prateleira remove(Object key) {
            return null;
        }

        public void putAll(Map<? extends Integer, ? extends Prateleira> m) {

        }

        public void clear() {

        }

        public Set<Integer> keySet() {
            return null;
        }

        public Collection<Prateleira> values() {
            return null;
        }
    }
