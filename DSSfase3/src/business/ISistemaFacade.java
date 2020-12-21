package business;

import java.util.List;
import java.util.Map;

public interface ISistemaFacade {
    boolean comunicaOT();
    void comunicaQR(QRcode c);
    Palete notificaEntrega(Palete p,int x, int y);
    void notificaRecolha(Palete p);
    Map<Integer, Map.Entry<Integer,Integer>> consultalistagemdeLocalizacao();
    Leitor getLeitor();
    Robot getRobot();
    List<Palete> getEspera();
}
