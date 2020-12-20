package business;

import java.util.Objects;

/**
 * Classe que contém a implementação do Leitor
 */
public class  Leitor {
    private String info;
    private QRcode qrcode;


    /**
     * Construtor vazio
     */
    public Leitor(){
        qrcode = new QRcode();
        info = new String();
    }

    /**
     * Construtor parametrizado
     * @param info
     * @param qr
     */
    public Leitor(String info,QRcode qr) {
        this.qrcode = qr;
        this.info = info;
    }

    /**
     * Construtor por cópia
     * @param lei
     */
    public Leitor(Leitor lei){
        qrcode = lei.getQrcode();
        info = lei.getInfo();
    }

    /**
     * Devolve o QrCode
     * @return QrCode
     */
    public QRcode getQrcode() {
        return qrcode;
    }

    /**
     * Define o QrCode
     * @param qrcode
     */
    public void setQrcode(QRcode qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * Devolve a info
     * @return String
     */
    public String  getInfo() {
        return info;
    }

    /**
     * Define a info
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Verifica a igualdade com outro objeto
     * @param o Objeto a comparar
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leitor)) return false;
        Leitor leitor = (Leitor) o;
        return Objects.equals(getInfo(), leitor.getInfo()) &&
                Objects.equals(getQrcode(), leitor.getQrcode());
    }

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(getInfo(), getQrcode());
    }

    /**
     * Devolve uma cópia da instância
     * @return leitor
     */
    public Leitor clone(){
        return new Leitor(this);
    }
}
