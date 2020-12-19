package business;
import java.util.Objects;
import java.lang.Object;




public class Robot {
    private int codRobot;
    private Localizacao localizacao;
    private Palete aTranpos;
    private Localizacao localizacaoFinal;
    private int entregue;


    public Robot(int codRobot, Localizacao localizacao,Palete aTranspos,Localizacao lf,int entregue) {
        this.codRobot = codRobot;
        this.localizacao = localizacao;
        this.aTranpos = aTranspos;
        this.localizacaoFinal = lf;
        this.entregue = entregue;
    }

    public Robot(){
        codRobot = -1;
        localizacao = new Localizacao();
        aTranpos = new Palete();
        localizacaoFinal = new Localizacao();
        entregue = 0;
    }

    public Robot(Robot ro){
        codRobot = ro.getCodRobot();
        localizacao = ro.getLocalizacao();
        aTranpos  = ro.getaTranpos();
        localizacaoFinal = ro.getLocalizacaoFinal();
        entregue =  ro.getEntregue();
    }

    public int getEntregue() {
        return entregue;
    }

    public void setEntregue(int entregue) {
        this.entregue = entregue;
    }

    public Localizacao getLocalizacaoFinal() {
        return localizacaoFinal;
    }

    public void setLocalizacaoFinal(Localizacao localizacaoFinal) {
        this.localizacaoFinal = localizacaoFinal;
    }

    public Palete getaTranpos() {
        return aTranpos;
    }

    public void setaTranpos(Palete aTranpos) {
        this.aTranpos = aTranpos;
    }

    public int getCodRobot() {
        return codRobot;
    }

    public void setCodRobot(int codRobot) {
        this.codRobot = codRobot;
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
        if (!(o instanceof Robot)) return false;
        Robot robot = (Robot) o;
        return getCodRobot() == robot.getCodRobot() &&
                getEntregue() == robot.getEntregue() &&
                Objects.equals(getLocalizacao(), robot.getLocalizacao()) &&
                Objects.equals(getaTranpos(), robot.getaTranpos()) &&
                Objects.equals(getLocalizacaoFinal(), robot.getLocalizacaoFinal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodRobot(), getLocalizacao(), getaTranpos(), getLocalizacaoFinal(), getEntregue());
    }

    public Robot clone(){
        return new Robot(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Robot{");
        sb.append("codRobot=").append(codRobot);
        sb.append(", localizacao=").append(localizacao);
        sb.append(", aTranpos=").append(aTranpos);
        sb.append(", localizacaoFinal=").append(localizacaoFinal);
        sb.append('}');
        return sb.toString();
    }
}
