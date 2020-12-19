package business;

import java.util.*;

public class SistemaFacade implements ISistemaFacade {
    private int rDisp;
    private Robot robot;
    private Map<Integer,Palete> paletes;
    private Map<Integer,Palete> historico;
    private Map<Integer,Prateleira> prateleiras;
    private List<Pair> espera;
    private Gestor gestor;
    private Leitor leitor;

    public SistemaFacade(){
        rDisp = 0;
        robot = new Robot();
        paletes = new HashMap<>();
        historico = new HashMap<>();
        prateleiras = new HashMap<>();
        espera = new ArrayList<>();
        gestor = new Gestor();
        leitor = new Leitor();
    }

    public SistemaFacade(int rDisp, Robot robot, Map<Integer,Palete> paletes, Map<Integer,Palete> historico,
                         Map<Integer,Prateleira> prateleiras, List<Pair> espera, Gestor gestor, Leitor l){
        this.rDisp = rDisp;
        this.robot = robot;
        setHistorico(historico);
        setPaletes(paletes);
        setPrateleiras(prateleiras);
        setEspera(espera);
        this.gestor = gestor;
        this.leitor = l;
    }

    public SistemaFacade(SistemaFacade system){
        rDisp = system.getrDisp();
        robot = system.getRobot();
        setHistorico(system.getHistorico());
        setPaletes(system.getPaletes());
        setPrateleiras(system.getPrateleiras());
        setEspera(system.getEspera());
        gestor = system.getGestor();
        leitor = system.getLeitor();
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public List<Pair> getEspera() {
        List<Pair> aux = new ArrayList<>();
        for(Pair p: this.espera)
            aux.add(p);
        return aux;
    }

    public void setEspera(List<Pair> espera) {
        this.espera = new ArrayList<>();
        for(Pair p: espera)
            this.espera.add(p);
    }

    public void setPrateleiras(Map<Integer, Prateleira> prateleiras) {
        this.prateleiras = new HashMap<>();
        for(Prateleira n: prateleiras.values()){
            this.prateleiras.put(n.getCodPrateleira(), n);
        }
    }

    public void setHistorico(Map<Integer, Palete> paletes) {
        this.historico = new HashMap<>();
        for(Palete n: paletes.values()){
            this.historico.put(n.getCodPalete(), n);
        }
    }
    public Map<Integer, Palete> getHistorico() {
        Map<Integer, Palete> auxpaletes = new HashMap<>();
        for(Palete n: historico.values()){
            auxpaletes.put(n.getCodPalete(), n);
        }
        return auxpaletes;
    }

    public Map<Integer, Prateleira> getPrateleiras() {
        Map<Integer, Prateleira> auxprateletiras = new HashMap<>();
        for(Prateleira n: prateleiras.values()){
            auxprateletiras.put(n.getCodPrateleira(), n);
        }
        return auxprateletiras;
    }


    public Map<Integer, Palete> getPaletes() {
        Map<Integer, Palete> auxpaletes = new HashMap<>();
        for(Palete n: paletes.values()){
            auxpaletes.put(n.getCodPalete(), n);
        }
        return auxpaletes;
    }

    public void setPaletes(Map<Integer, Palete> paletes) {
        this.paletes = new HashMap<>();
        for(Palete n: paletes.values()){
            this.paletes.put(n.getCodPalete(), n);
        }
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public int getrDisp() {
        return rDisp;
    }

    public void setrDisp(int rDisp) {
        this.rDisp = rDisp;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SistemaFacade)) return false;
        SistemaFacade that = (SistemaFacade) o;
        return getrDisp() == that.getrDisp() &&
                Objects.equals(getRobot(), that.getRobot()) &&
                Objects.equals(getPaletes(), that.getPaletes()) &&
                Objects.equals(getHistorico(), that.getHistorico()) &&
                Objects.equals(getPrateleiras(), that.getPrateleiras()) &&
                Objects.equals(getEspera(), that.getEspera()) &&
                Objects.equals(getGestor(), that.getGestor()) &&
                Objects.equals(getLeitor(), that.getLeitor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getrDisp(), getRobot(), getPaletes(), getHistorico(), getPrateleiras(), getEspera(), getGestor(), getLeitor());
    }

    public SistemaFacade clone(){
        return new SistemaFacade(this);
    }

    public Map<Integer, Localizacao> consultalistagemdeLocalizacao() {
        Map<Integer, Localizacao> consultas = new HashMap<>();
        for (Map.Entry<Integer, Palete> p : this.paletes.entrySet()) {
            consultas.put(p.getKey(), p.getValue().getLocalizacao());
        }
        return consultas;
    }

    // função implementada para apenas um robot
    public void notificaRecolha(Palete p){
        p.setTransporte(robot.getCodRobot());
        this.robot.setEntregue(1);
        if (!p.getLocalizacao().isEntrada()) {
            for (Map.Entry<Integer, Prateleira> aux : this.prateleiras.entrySet()) {
                if ((aux.getValue().getCodPal() == p.getCodPalete())) {
                    aux.getValue().setDisponibilidade(true);
                    aux.getValue().setCodPalete(-1);
                }
            }
        }
    }

    public void adicionaPar(Pair p){
        this.espera.add(p);
    }
    public void adicionaPalete(Palete p){
        this.paletes.put(p.getCodPalete(),p);
    }

    public void notificaEntrega(Palete p,Localizacao l) {
        p.setTransporte(-1);
        this.robot.setEntregue(0);
        if(p.getLocalizacao().equals(l));
        else if (l.isSaida()){
            this.paletes.remove(p.getCodPalete());
            this.robot.setaTranpos(new Palete());
            this.robot.setLocalizacaoFinal(new Localizacao());
        }
        else{
            for(Map.Entry<Integer,Prateleira> aux: this.prateleiras.entrySet()) {
                if (aux.getValue().getLocal().equals(l)) {
                    aux.getValue().setDisponibilidade(false);
                    this.robot.setLocalizacao(aux.getValue().getLocal());
                    p.setLocalizacao(aux.getValue().getLocal());
                    aux.getValue().setCodPalete(p.getCodPalete());
                    this.robot.setaTranpos(new Palete());
                    this.robot.setLocalizacaoFinal(new Localizacao());
                }
            }
        }
    }

    public void comunicaQR(QRcode c){
        int i = historico.size()+1;
        Localizacao e = new Localizacao (0,0);
        Palete p = new Palete(i,e,-1,c.getMateriaP());
        historico.put(p.getCodPalete(),p);
        paletes.put(p.getCodPalete(),p);
    }

    public void comunicaOT(){
        if(this.robot.getaTranpos() != null) {
            Pair p = this.espera.get(0);
            this.espera.remove(0);
            Palete pal = this.paletes.get(p.getX());
            this.robot.setaTranpos(pal);
            this.robot.setLocalizacaoFinal((Localizacao) p.getY());
            System.out.println(this.robot);
        }
    }



    /*public void main() {

        Localizacao l1 = new Localizacao(0, 0);
        Localizacao l2 = new Localizacao(1, 1);
        Localizacao l3 = new Localizacao(0, 1);

        Robot r1 = new Robot(1,l1,null);
        this.robot = r1;

        Palete p1 = new Palete(1, l1, -1, "Arroz");
        Palete p2 = new Palete(2, l2, -1, "Agua");
        Palete p3 = new Palete(3, l3, -1, "Massa");
        QRcode qr = new QRcode("Leite",4);


        Prateleira pr1 = new Prateleira(1, true, -1, l1);
        Prateleira pr2 = new Prateleira(2, true, -1, l2);
        Prateleira pr3 = new Prateleira(3, false, p1.getCodPalete(), l1);

        this.prateleiras.put(pr1.getCodPrateleira(), pr1);
        this.prateleiras.put(pr2.getCodPrateleira(), pr2);
        this.prateleiras.put(pr3.getCodPrateleira(), pr3);

        this.paletes.put(p1.getCodPalete(), p1);
        this.paletes.put(p2.getCodPalete(), p2);
        this.paletes.put(p3.getCodPalete(), p3);

        this.historico.put(p1.getCodPalete(),p1);
        this.historico.put(p2.getCodPalete(),p2);
        this.historico.put(p3.getCodPalete(),p3);

        this.espera.add(2);
        this.espera.add(1);



        Map<Integer, Localizacao> palo = consultalistagemdeLocalizacao();

        for(Map.Entry<Integer,Localizacao> i: palo.entrySet()){

            System.out.println("Palete " + i.getKey() + " :" + i.getValue());
        }
        /*for(Map.Entry<Integer,Palete> m : this.historico.entrySet())
            System.out.println("Palete "+  m.getKey() + " Material: " + m.getValue().getMateriaP());

        comunicaOT();
        for(int i: this.espera)
            System.out.println("Palete: "  +  i);
        System.out.println("Palete: " + this.robot.getaTranpos());

        notificaRecolha(p1);
        System.out.println("Robot " + p1.isTransporte());
        for (Map.Entry<Integer, Prateleira> i : this.prateleiras.entrySet()){
            if (i.getValue().isDisponibilidade())
                System.out.println("Prateleira " + i.getKey() + " Livre");
        }

        notificaEntrega(p2,l2);
        System.out.println("Prateleira" + pr2.getCodPrateleira() + "tem palete " + pr2.getCodPal());
        for (Map.Entry<Integer, Prateleira> i : this.prateleiras.entrySet()){
            if (i.getValue().isDisponibilidade())
                System.out.println("Prateleira " + i.getKey() + " Livre");
        }
    }
*/

}
