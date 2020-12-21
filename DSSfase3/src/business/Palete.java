package business;

import java.util.Objects;


/**
 * Classe que contém a implementação da Palete
 */
public class Palete {
    private int codPalete;
    private int x;
    private int y;
    private int robot;
    private String materiaP;


    public Palete(int codPalete, int x, int y, int robot, String materiaP) {
        this.codPalete = codPalete;
        this.x = x;
        this.y = y;
        this.robot = robot;
        this.materiaP = materiaP;
    }

    /**
     * Construtor vazio
     */
    public Palete(){
        codPalete = -1;
        x = -1;
        y = -1;
        robot = -1;
        materiaP = new String();
    }

    /**
     * Construtor por cópia
     * @param pal
     */
    public Palete(Palete pal){
        codPalete = pal.getCodPalete();
        x = pal.getX();
        y = pal.getY();
        robot = pal.isTransporte();
        materiaP = pal.getMateriaP();
    }

    /**
     * Devolve o código da palete
     * @return int
     */
    public int getCodPalete() {
        return codPalete;
    }

    /**
     * Define o código da palete
     * @param codPalete
     */
    public void setCodPalete(int codPalete) {
        this.codPalete = codPalete;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Método que nos diz qual robot transporta a palete
     * @return
     */
    public int isTransporte() {
        return robot;
    }

    /**
     * Método que altera o robot responsável pelo transporte da palete
     * @param robot
     */
    public void setTransporte(int robot) {
        this.robot = robot;
    }


    /**
     * Devolve o material da palete
     * @return String
     */
    public String getMateriaP() {
        return materiaP;
    }

    /**
     * Define o material da palete
     * @param materiaP
     */
    public void setMateriaP(String materiaP) {
        this.materiaP = materiaP;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Palete)) return false;
        Palete palete = (Palete) o;
        return getCodPalete() == palete.getCodPalete() &&
                getX() == palete.getX() &&
                getY() == palete.getY() &&
                robot == palete.robot &&
                Objects.equals(getMateriaP(), palete.getMateriaP());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodPalete(), getX(), getY(), robot, getMateriaP());
    }

    /**
     * Devolve uma cópia da instância
     * @return Palete
     */
    public Palete clone(){
        return new Palete(this);
    }

    /**
     * Método toString do objeto
     * @return Objeto em modo string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Palete{");
        sb.append("codPalete=").append(codPalete);
        sb.append(", x = ").append(x);
        sb.append(", y = ").append(y);
        sb.append(", robot=").append(robot);
        sb.append(", materiaP='").append(materiaP).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método que nos diz se está vazio
     * @return boolean
     */
    public boolean isEmpty(){
        return codPalete == -1 && x == -1 && y == -1 && robot == -1 && materiaP.equals("");
    }

}
