package business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Robot {
    private String codRobot;
    private List<String> listaEspera;
    private Localizacao localizacao;


    public Robot(String codRobot, List<String> listaEspera, Localizacao localizacao) {
        this.codRobot = codRobot;
        setListaEspera(listaEspera);
        this.localizacao = localizacao;
    }

    public Robot(){
        codRobot = new String();
        listaEspera = new ArrayList<>();
        localizacao = new Localizacao();
    }

    public Robot(Robot ro){
        codRobot = ro.getCodRobot();
        setListaEspera(ro.getListaEspera());
        localizacao = ro.getLocalizacao();

    }

    public String getCodRobot() {
        return codRobot;
    }

    public void setCodRobot(String codRobot) {
        this.codRobot = codRobot;
    }

    public List<String> getListaEspera() {
        List<String> aux = new ArrayList<>();
        for(String n: listaEspera){
            aux.add(n);
        }
        return aux;
    }

    public void setListaEspera(List<String> listaEspera) {
        this.listaEspera = new ArrayList<>();
        for(String n: listaEspera){
            this.listaEspera.add(n);
        }
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(codRobot, robot.codRobot) &&
                Objects.equals(listaEspera, robot.listaEspera) &&
                Objects.equals(localizacao, robot.localizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codRobot, listaEspera, localizacao);
    }

    public Robot clone(){
        return new Robot(this);
    }
}
