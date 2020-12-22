package business;
import data.DAOconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;
import java.lang.Object;


/**
 * Classe que contém a implementação do Robot
 */
public class Robot {
    private int codRobot;
    private int xRobot;
    private int yRobot;
    private int aTranpos;
    private int localizacaoXFinal;
    private int localizacaoYFinal;
    private int entregue;


    /**
     * Construtor parametrizado
     * @param codRobot Código do Robot
     * @param xr abcissa do Robot
     * @param yr Ordenada do Robot
     * @param aTranspos Código da palete a transportar
     * @param xf abcissa final
     * @param yf ordenada final
     * @param entregue Entregue
     */
    public Robot(int codRobot, int xr, int yr,int aTranspos,int xf, int yf,int entregue) {
        this.codRobot = codRobot;
        this.xRobot = xr;
        this.yRobot = yr;
        this.aTranpos = aTranspos;
        this.localizacaoXFinal = xf;
        this.localizacaoYFinal = yf;
        this.entregue = entregue;
    }

    /**
     * Construtor vazio
     */
    public Robot(){
        codRobot = 1;
        xRobot = 0;
        yRobot = 0;
        aTranpos = -1;
        localizacaoXFinal = -1;
        localizacaoYFinal = -1;
        entregue = 0;
    }

    /**
     * Construtor por cópia
     * @param ro Robot
     */
    public Robot(Robot ro){
        codRobot = ro.getCodRobot();
        xRobot = ro.getxRobot();
        yRobot = ro.getyRobot();
        aTranpos  = ro.getaTranpos();
        localizacaoXFinal = ro.getLocalizacaoXFinal();
        localizacaoYFinal = ro.getLocalizacaoYFinal();
        entregue =  ro.getEntregue();
    }

    /**
     * Devolve o entregue
     * @return int
     */
    public int getEntregue() {
        return entregue;
    }

    /**
     * Define o entregue
     * @param entregue Entregue
     */
    public void setEntregue(int entregue) {
        this.entregue = entregue;
    }

    /**
     * Devolve o  codigo da palete a transportar
     * @return palete
     */
    public int getaTranpos() {
        return aTranpos;
    }

    /**
     * Define o código da palete a transportar
     * @param aTranpos Código da palete
     */
    public void setaTranpos(int aTranpos) {
        this.aTranpos = aTranpos;
    }

    /**
     * Devolve o código do robot
     * @return int
     */
    public int getCodRobot() {
        return codRobot;
    }

    /**
     * Define  o código do robot
     * @param codRobot Código do Robot
     */
    public void setCodRobot(int codRobot) {
        this.codRobot = codRobot;
    }

    /**
     * Devolve o X do Robot
     * @return int
     */
    public int getxRobot() {
        return xRobot;
    }

    /**
     * Define o X do Robot
     * @param xRobot abcissa do Robot
     */
    public void setxRobot(int xRobot) {
        this.xRobot = xRobot;
    }

    /**
     * Devolve o Y do Robot
     * @return int
     */
    public int getyRobot() {
        return yRobot;
    }

    /**
     * Define o Y do Robot
     * @param yRobot ordenada do Robot
     */
    public void setyRobot(int yRobot) {
        this.yRobot = yRobot;
    }

    /**
     * Devolve o X final
     * @return int
     */
    public int getLocalizacaoXFinal() {
        return localizacaoXFinal;
    }

    /**
     * Define o X final
     * @param localizacaoXFinal abcissa final
     */
    public void setLocalizacaoXFinal(int localizacaoXFinal) {
        this.localizacaoXFinal = localizacaoXFinal;
    }

    /**
     * Devolve o Y final
     * @return int
     */
    public int getLocalizacaoYFinal() {
        return localizacaoYFinal;
    }

    /**
     * Define o Y final
     * @param localizacaoYFinal ordenada final
     */
    public void setLocalizacaoYFinal(int localizacaoYFinal) {
        this.localizacaoYFinal = localizacaoYFinal;
    }

    /**
     * Verifica a igualdade com outro objeto.
     * @param o Objeto a comparar
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot)) return false;
        Robot robot = (Robot) o;
        return getCodRobot() == robot.getCodRobot() &&
                getxRobot() == robot.getxRobot() &&
                getyRobot() == robot.getyRobot() &&
                getLocalizacaoXFinal() == robot.getLocalizacaoXFinal() &&
                getLocalizacaoYFinal() == robot.getLocalizacaoYFinal() &&
                getEntregue() == robot.getEntregue() &&
                Objects.equals(getaTranpos(), robot.getaTranpos());
    }

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(getCodRobot(), getxRobot(), getyRobot(), getaTranpos(), getLocalizacaoXFinal(), getLocalizacaoYFinal(), getEntregue());
    }

    /**
     * Devolve uma cópia da instância
     * @return Robot
     */
    public Robot clone(){
        return new Robot(this);
    }

    /**
     * Método toString do objeto
     * @return Objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Robot{");
        sb.append("codRobot=").append(codRobot);
        sb.append(", xRobot=").append(xRobot);
        sb.append(", yRobot=").append(yRobot);
        sb.append(", aTranpos=").append(aTranpos);
        sb.append(", localizacaoXFinal=").append(localizacaoXFinal);
        sb.append(", localizacaoYFinal=").append(localizacaoYFinal);
        sb.append(", entregue=").append(entregue);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método que nos diz se o robot tem uma determinada palete
     * @return boolean
     */
    //Se tiver palete dá true
    public boolean hasPalete(){
        return aTranpos != -1;
    }

}
