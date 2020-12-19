package business;

import java.util.List;
import java.util.Map;

public interface ISistemaFacade {
    void comunicaOT();
    void comunicaQR(QRcode c);
    void notificaEntrega(Palete p,Localizacao l);
    void notificaRecolha(Palete p);
    Map<Integer, Localizacao> consultalistagemdeLocalizacao();
    Leitor getLeitor();
    Robot getRobot();
    List<Pair> getEspera();
    void adicionaPar(Pair p);
    void adicionaPalete(Palete p);
}
