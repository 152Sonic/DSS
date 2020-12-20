package business;
import java.util.Objects;
import java.lang.Object;


/**
 * Classe que contém a implementação do Robot
 */
public class Robot {
    private int codRobot;
    private Localizacao localizacao;
    private Palete aTranpos;
    private Localizacao localizacaoFinal;
    private int entregue;


    /**
     * Construtor parametrizado
     * @param codRobot
     * @param localizacao
     * @param aTranspos
     * @param lf
     * @param entregue
     */
    public Robot(int codRobot, Localizacao localizacao,Palete aTranspos,Localizacao lf,int entregue) {
        this.codRobot = codRobot;
        this.localizacao = localizacao;
        this.aTranpos = aTranspos;
        this.localizacaoFinal = lf;
        this.entregue = entregue;
    }

    /**
     * Construtor vazio
     */
    public Robot(){
        codRobot = 1;
        localizacao = new Localizacao(0,0);
        aTranpos = new Palete();
        localizacaoFinal = new Localizacao();
        entregue = 0;
    }

    /**
     * Construtor por cópia
     * @param ro
     */
    public Robot(Robot ro){
        codRobot = ro.getCodRobot();
        localizacao = ro.getLocalizacao();
        aTranpos  = ro.getaTranpos();
        localizacaoFinal = ro.getLocalizacaoFinal();
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
     * @param entregue
     */
    public void setEntregue(int entregue) {
        this.entregue = entregue;
    }

    /**
     * Devolve a localização final
     * @return localização
     */
    public Localizacao getLocalizacaoFinal() {
        return localizacaoFinal;
    }

    /**
     * Define a localização final
     * @param localizacaoFinal
     */
    public void setLocalizacaoFinal(Localizacao localizacaoFinal) {
        this.localizacaoFinal = localizacaoFinal;
    }

    /**
     * Devolve a palete a transportar
     * @return palete
     */
    public Palete getaTranpos() {
        return aTranpos;
    }

    /**
     * Define a palete a transportar
     * @param aTranpos
     */
    public void setaTranpos(Palete aTranpos) {
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
     * @param codRobot
     */
    public void setCodRobot(int codRobot) {
        this.codRobot = codRobot;
    }

    /**
     * Devolve a localização do robot
     * @return localização
     */
    public Localizacao getLocalizacao() {
        return localizacao;
    }

    /**
     * Define a localização do robot
     * @param localizacao
     */
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Verifica a igualdade com outro objeto
     * @param o Objeto a comparar
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot)) return false;
        Robot robot = (Robot) o;
        return getCodRobot() == robot.getCodRobot() &&
                getEntregue() == robot.getEntregue() &&
                Objects.equals(getLocalizacao(), robot.getLocalizacao()) &&
                Objects.equals(getaTranpos(), robot.getaTranpos()) &&
                Objects.equals(getLocalizacaoFinal(), robot.getLocalizacaoFinal());
    }

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(getCodRobot(), getLocalizacao(), getaTranpos(), getLocalizacaoFinal(), getEntregue());
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
        sb.append(", localizacao=").append(localizacao);
        sb.append(", aTranpos=").append(aTranpos);
        sb.append(", localizacaoFinal=").append(localizacaoFinal);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método que nos diz se o robot tem uma determinada palete
     * @return boolean
     */
    //Se não tiver palete dá true
    public boolean hasPalete(){
        return aTranpos.getCodPalete() == -1;
    }
}
