package business;

import data.EsperaDAO;
import data.HistoricoDAO;
import data.PaletesDAO;
import data.PrateleirasDAO;

import java.util.*;

/**
 * Classe que contém a implementação do sistema
 */
public class SistemaFacade implements ISistemaFacade {
    private int rDisp;
    private Robot robot;
    private Map<Integer,Palete> paletes;
    private Map<Integer,Palete> historico;
    private Map<Integer,Prateleira> prateleiras;
    private List<Pair> espera;
    private Gestor gestor;
    private Leitor leitor;


    /**
     * Construtor vazio
     */
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

    /**
     * Construtor parametrizado
     * @param rDisp
     * @param robot
     * @param paletes
     * @param historico
     * @param prateleiras
     * @param espera
     * @param gestor
     * @param l
     */
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

    /**
     * Construtor por cópia
     * @param system
     */
    public SistemaFacade(SistemaFacade system){
        rDisp = system.getrDisp();
        robot = system.getRobot();
        this.historico = HistoricoDAO.getInstance();
        this.paletes = PaletesDAO.getInstance();
        this.prateleiras = PrateleirasDAO.getInstance();
        this.espera = EsperaDAO.getInstance();
        /*setEspera(system.getEspera());
        setHistorico(system.getHistorico());
        setPaletes(system.getPaletes());
        setPrateleiras(system.getPrateleiras());*/
        gestor = system.getGestor();
        leitor = system.getLeitor();
    }

    /**
     * Devolve o leitor
     * @return Leitor
     */
    public Leitor getLeitor() {
        return leitor;
    }

    /**
     * Define o leitor
     * @param leitor
     */
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    /**
     * Devolve a lista de espera
     * @return List<Pair>
     */
    public List<Pair> getEspera() {
        List<Pair> aux = new ArrayList<>();
        for(Pair p: this.espera)
            aux.add(p);
        return aux;
    }

    /**
     * Define a lista de espera
     * @param espera
     */
    public void setEspera(List<Pair> espera) {
        this.espera = new ArrayList<>();
        for(Pair p: espera)
            this.espera.add(p);
    }

    /**
     * Define o conjunto de prateleiras
     * @param prateleiras
     */
    public void setPrateleiras(Map<Integer, Prateleira> prateleiras) {
        this.prateleiras = new HashMap<>();
        for(Prateleira n: prateleiras.values()){
            this.prateleiras.put(n.getCodPrateleira(), n);
        }
    }

    /**
     * Define o conjunto de paletes no histórico
     * @param paletes
     */
    public void setHistorico(Map<Integer, Palete> paletes) {
        this.historico = new HashMap<>();
        for(Palete n: paletes.values()){
            this.historico.put(n.getCodPalete(), n);
        }
    }

    /**
     * Devolve o conjunto de paletes no histórico
     * @return Map<Integer, Palete>
     */
    public Map<Integer, Palete> getHistorico() {
        Map<Integer, Palete> auxpaletes = new HashMap<>();
        for(Palete n: historico.values()){
            auxpaletes.put(n.getCodPalete(), n);
        }
        return auxpaletes;
    }

    /**
     * Devolve o conjunto de prateleiras
     * @return Map<Integer, Prateleira>
     */
    public Map<Integer, Prateleira> getPrateleiras() {
        Map<Integer, Prateleira> auxprateletiras = new HashMap<>();
        for(Prateleira n: prateleiras.values()){
            auxprateletiras.put(n.getCodPrateleira(), n);
        }
        return auxprateletiras;
    }

    /**
     * Devolve o conjunto de paletes
     * @return Map<Integer, Palete>
     */
    public Map<Integer, Palete> getPaletes() {
        Map<Integer, Palete> auxpaletes = new HashMap<>();
        for(Palete n: paletes.values()){
            auxpaletes.put(n.getCodPalete(), n);
        }
        return auxpaletes;
    }

    /**
     * Define o conjunto de paletes
     * @param paletes
     */
    public void setPaletes(Map<Integer, Palete> paletes) {
        this.paletes = new HashMap<>();
        for(Palete n: paletes.values()){
            this.paletes.put(n.getCodPalete(), n);
        }
    }

    /**
     * Devolve o gestor
     * @return Gestor
     */
    public Gestor getGestor() {
        return gestor;
    }

    /**
     * Define o gestor
     * @param gestor
     */
    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    /**
     * Devolve o robot disponível
     * @return int
     */
    public int getrDisp() {
        return rDisp;
    }

    /**
     * Define o robot disponível
     * @param rDisp
     */
    public void setrDisp(int rDisp) {
        this.rDisp = rDisp;
    }

    /**
     * Devolve o robot
     * @return Robot
     */
    public Robot getRobot() {
        return robot;
    }

    /**
     * Define o robot
     * @param robot
     */
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    /**
     * Verifica a igualdade com outro objeto
     * @param o Objeto a comparar
     * @return boolean
     */
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

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(getrDisp(), getRobot(), getPaletes(), getHistorico(), getPrateleiras(), getEspera(), getGestor(), getLeitor());
    }

    /**
     * Devolve uma cópia da instância
     * @return SistemaFacade
     */
    public SistemaFacade clone(){
        return new SistemaFacade(this);
    }

    /**
     * Método que faz a listagem de todos os códigos de paletes e as correspondentes localizações
     * @return Map<Integer, Localizacao>
     */
    public Map<Integer, Localizacao> consultalistagemdeLocalizacao() {
        Map<Integer, Localizacao> consultas = new HashMap<>();
        for (Map.Entry<Integer, Palete> p : this.paletes.entrySet()) {
            consultas.put(p.getKey(), p.getValue().getLocalizacao());
        }
        return consultas;
    }

    /**
     * Método que notifica quando uma determinada palete é recolhida de uma prateleira pelo robot
     * @param p
     */
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

    /**
     * Método que notifica quando uma determinda palete é entregue numa determinada localização pelo robot
     * @param p
     * @param l
     * @return Palete
     */
    public Palete notificaEntrega(Palete p,Localizacao l) {
        p.setTransporte(-1);
        Palete palete = p.clone();
        this.robot.setEntregue(0);
        System.out.println(this.robot.getEntregue());
        if(p.getLocalizacao().equals(l));
        else if (l.isSaida()){
            this.paletes.remove(p.getCodPalete());
            this.robot.setaTranpos(new Palete());
            this.robot.setLocalizacaoFinal(new Localizacao());
            palete.setLocalizacao(l);
        }
        else{
            for(Map.Entry<Integer,Prateleira> aux: this.prateleiras.entrySet()) {
                if (aux.getValue().getLocal().equals(l)) {
                    aux.getValue().setDisponibilidade(false);
                    this.robot.setLocalizacao(l);
                    this.historico.get(p.getCodPalete()).setLocalizacao(l);
                    this.paletes.get(p.getCodPalete()).setLocalizacao(l);
                    aux.getValue().setCodPalete(p.getCodPalete());
                    this.robot.setaTranpos(new Palete());
                    palete.setLocalizacao(l);
                }
            }
        }
        return palete;
    }

    /**
     * Método que regista o código QR
     * @param c
     */
    public void comunicaQR(QRcode c){
        int i = historico.size()+1;
        Localizacao e = new Localizacao (0,0);
        Palete p = new Palete(i,e,-1,c.getMateriaP());
        historico.put(p.getCodPalete(),p);
        paletes.put(p.getCodPalete(),p);
        Iterator<Prateleira> it = prateleiras.values().iterator();
        int flag = 0;
        while(it.hasNext() && flag == 0) {
            Prateleira prat = it.next();
            if (prat.isDisponibilidade()){
                flag = 1;
                espera.add(new Pair(p.getCodPalete(), prat.getLocal()));
            }
        }
    }

    /**
     * Método que nos diz a ordem de transporte do robot
     * @return boolean
     */
    public boolean comunicaOT(){
        boolean flag = false;
        if(this.robot.hasPalete()) {
            if (!espera.isEmpty()) {
                Pair p = this.espera.get(0);
                this.espera.remove(0);
                Palete pal = this.paletes.get(p.getX());
                this.robot.setaTranpos(pal);
                this.robot.setLocalizacaoFinal((Localizacao) p.getY());
                System.out.println(this.robot);
            }
            flag = true;
        }
        return flag;
    }

    /**
     * Método que adiciona uma prateleira
     * @param p
     */
    public void add(Prateleira p){
        this.prateleiras.put(p.getCodPrateleira(),p);
    }
}
