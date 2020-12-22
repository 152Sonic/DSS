package business;

import java.util.List;
import java.util.Map;

/**
 * Interface Sistema
 */
public interface ISistemaFacade {
    boolean comunicaOT();
    void comunicaQR(QRcode c);
    Palete notificaEntrega(Palete p,int x, int y);
    void notificaRecolha(int p);
    Map<Integer, Map.Entry<Integer,Integer>> consultalistagemdeLocalizacao();
    Leitor getLeitor();
    List<Palete> getEspera();
    Map<Integer, Palete> getPaletes();
    Map<Integer,Robot> getRobot();
    Palete getP();
    Robot getRobot(int c);
    Palete getPaletes(int c);
}
