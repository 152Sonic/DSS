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


    /**
     * Construtor parametrizado
     * @param codPalete Código da palete
     * @param x abcissa
     * @param y ordenada
     * @param robot Robot
     * @param materiaP Material da palete
     */
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
     * @param pal Palete
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
     * @param codPalete Código da palete
     */
    public void setCodPalete(int codPalete) {
        this.codPalete = codPalete;
    }

    /**
     * Dveolve o X
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Define o X
     * @param x abcissa
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Devolve o Y
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Define o Y
     * @param y ordenada
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Método que nos diz qual robot transporta a palete
     * @return int
     */
    public int isTransporte() {
        return robot;
    }

    /**
     * Método que altera o robot responsável pelo transporte da palete
     * @param robot Robot atual
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
     * @param materiaP Material da palete
     */
    public void setMateriaP(String materiaP) {
        this.materiaP = materiaP;
    }


    /**
     * Verifica a igualdade com outro objeto.
     * @param o Objeto a comparar
     * @return boolean
     */
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

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
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
