package business;

public class QRcode {
    private String cod;
    private String materiaP;


    public QRcode(){
        materiaP = new String();
        cod = new String();
    }

    public QRcode(String materiaP, String cod) {
        this.materiaP = materiaP;
        this.cod = cod;
    }

    public QRcode(QRcode lei){
        materiaP = lei.getMateriaP();
        cod = lei.getCod();
    }

    public String getMateriaP() {
        return materiaP;
    }

    public void setMateriaP(String materiaP) {
        this.materiaP = materiaP;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
