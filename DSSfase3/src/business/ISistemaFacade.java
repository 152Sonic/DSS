package business;

import java.util.List;
import java.util.Map;

public interface ISistemaFacade {
    boolean comunicaOT();
    void comunicaQR(QRcode c);
    Palete notificaEntrega(Palete p,Localizacao l);
    void notificaRecolha(Palete p);
    Map<Integer, Localizacao> consultalistagemdeLocalizacao();
    Leitor getLeitor();
    Robot getRobot();
    List<Pair> getEspera();
    void add(Prateleira p);
}
