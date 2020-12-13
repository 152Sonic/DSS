
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Robot {
    private String codRobot;
    private List<String> listaEspera;
    private Localização localização;


    public Robot(String codRobot, List<String> listaEspera, Localização localização) {
        this.codRobot = codRobot;
        setListaEspera(listaEspera);
        this.localização = localização;
    }

    public Robot(){
        codRobot = new String();
        listaEspera = new ArrayList<>();
        localização = new Localização();
    }

    public Robot(Robot ro){
        codRobot = ro.getCodRobot();
        setListaEspera(ro.getListaEspera());
        localização = ro.getLocalização();

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

    public Localização getLocalização() {
        return localização;
    }

    public void setLocalização(Localização localização) {
        this.localização = localização;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(codRobot, robot.codRobot) &&
                Objects.equals(listaEspera, robot.listaEspera) &&
                Objects.equals(localização, robot.localização);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codRobot, listaEspera, localização);
    }

    public Robot clone(){
        return new Robot(this);
    }
}
