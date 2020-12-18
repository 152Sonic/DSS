package business;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Sistema {
    private int rDisp;
    private Robot robot;
    private Map<String,Palete> paletes;
    private Map<String,Palete> historico;
    private Map<String,Prateleira> prateleiras;
    private Gestor gestor;

    public Sistema (){
        rDisp = 0;
        robot = new Robot();
        paletes = new HashMap<>();
        historico = new HashMap<>();
        prateleiras = new HashMap<>();
        gestor = new Gestor();
    }

    public Sistema(int rDisp, Robot robot,Map<String,Palete> paletes,Map<String,Palete> historico, Map<String,Prateleira> prateleiras, Gestor gestor){
        this.rDisp = rDisp;
        this.robot = robot;
        setHistorico(historico);
        setPaletes(paletes);
        setPrateleiras(prateleiras);
        this.gestor = gestor;
    }

    public Sistema(Sistema system){
        rDisp = system.getrDisp();
        robot = system.getRobot();
        setHistorico(system.getHistorico());
        setPaletes(system.getPaletes());
        setPrateleiras(system.getPrateleiras());
        gestor = system.getGestor();
    }

    public void setPrateleiras(Map<String, Prateleira> prateleiras) {
        this.prateleiras = new HashMap<>();
        for(Prateleira n: prateleiras.values()){
            this.prateleiras.put(n.getCodPrateleira(), n);
        }
    }

    public void setHistorico(Map<String, Palete> paletes) {
        this.historico = new HashMap<>();
        for(Palete n: paletes.values()){
            this.historico.put(n.getCodPalete(), n);
        }
    }
    public Map<String, Palete> getHistorico() {
        Map<String, Palete> auxpaletes = new HashMap<>();
        for(Palete n: historico.values()){
            auxpaletes.put(n.getCodPalete(), n);
        }
        return auxpaletes;
    }

    public Map<String, Prateleira> getPrateleiras() {
        Map<String, Prateleira> auxprateletiras = new HashMap<>();
        for(Prateleira n: prateleiras.values()){
            auxprateletiras.put(n.getCodPrateleira(), n);
        }
        return auxprateletiras;
    }


    public Map<String, Palete> getPaletes() {
        Map<String, Palete> auxpaletes = new HashMap<>();
        for(Palete n: paletes.values()){
            auxpaletes.put(n.getCodPalete(), n);
        }
        return auxpaletes;
    }

    public void setPaletes(Map<String, Palete> paletes) {
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
        if (o == null || getClass() != o.getClass()) return false;
        Sistema sistema = (Sistema) o;
        return rDisp == sistema.rDisp &&
                Objects.equals(robot, sistema.robot) &&
                Objects.equals(paletes, sistema.paletes) &&
                Objects.equals(prateleiras, sistema.prateleiras) &&
                Objects.equals(gestor, sistema.gestor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rDisp, robot, paletes, prateleiras, gestor);
    }

    public Sistema clone(){
        return new Sistema(this);
    }

    public Map<String, Localizacao> consultalistagemdeLocalizacao() {
        Map<String, Localizacao> consultas = new HashMap<>();
        for (Map.Entry<String, Palete> p : this.paletes.entrySet()) {
            consultas.put(p.getKey(), p.getValue().getLocalizacao());
        }
        return consultas;
    }

    // função implementada para apenas um robot
    public void notificaRecolha(Palete p){
        Localizacao e = new Localizacao(0,0);
        p.setTransporte(robot.getCodRobot());
        if (p.getLocalizacao()!= e){
            Prateleira aux =  (Prateleira) this.prateleiras.values().stream().filter(a-> a.compara(p));
            aux.setDisponibilidade(true);
            ((Prateleira) this.prateleiras.values().stream().filter(a->a.compara(p))).setCodPalete("");
        }
    }

    public void notificaEntrega(Palete p){
        Localizacao e = new Localizacao(1,1);
        p.setTransporte("");
        if(p.getLocalizacao()!=e){
            Prateleira aux =  (Prateleira) this.prateleiras.values().stream().filter(a-> a.compara(p));
            aux.setDisponibilidade(false);
            robot.setLocalizacao(aux.getLocal());
            p.setLocalizacao(aux.getLocal());
            ((Prateleira) this.prateleiras.values().stream().filter(a->a.compara(p))).setCodPalete(p.getCodPalete());
        }
        paletes.remove(p);
    }

    public void comunicaQR(QRcode c){
        int i = historico.size()+1;
        Localizacao e = new Localizacao (0,0);
        Palete p = new Palete(i,e,null,c.getMateriaP());
        historico.put(p.getCodPalete(),p);
        paletes.put(p.getCodPalete(),p);
    }

}
