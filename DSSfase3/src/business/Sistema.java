package business;

import java.util.Map;
import java.util.Objects;

public class Sistema {
    private int rDisp;
    private Robot robot;
    private Paletes paletes;
    private Prateleiras prateleiras;
    private Gestor gestor;

    public Sistema (){
        rDisp = 0;
        robot = new Robot();
        paletes = new Paletes();
        prateleiras = new Prateleiras();
        gestor = new Gestor();
    }

    public Sistema(int rDisp, Robot robot, Paletes paletes, Prateleiras prateleiras, Gestor gestor){
        this.rDisp = rDisp;
        this.robot = robot;
        this.paletes = paletes;
        this.prateleiras = prateleiras;
        this.gestor = gestor;
    }

    public Sistema(Sistema system){
        rDisp = system.getrDisp();
        robot = system.getRobot();
        paletes = system.getPaletes();
        prateleiras = system.getPrateleiras();
        gestor = system.getGestor();
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

    public Paletes getPaletes() {
        return paletes;
    }

    public void setPaletes(Paletes paletes) {
        this.paletes = paletes;
    }

    public Prateleiras getPrateleiras() {
        return prateleiras;
    }

    public void setPrateleiras(Prateleiras prateleiras) {
        this.prateleiras = prateleiras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sistema sistema = (Sistema) o;
        return rDisp == sistema.rDisp &&
                Objects.equals(robot, sistema.robot) &&
                Objects.equals(paletes, sistema.paletes) &&
                Objects.equals(prateleiras, sistema.prateleiras);
    }

    public Sistema clone(){
        return new Sistema(this);
    }

    public Map<String, Localizacao> consulta(){
        return paletes.consulta();
    }
}
