import java.util.Objects;

public class Leitor {
    private String qrcode;
    private QRcode info;


    public Leitor(){
        qrcode = new String();
        info = new QRcode();
    }

    public Leitor(String qrcode) {
        this.qrcode = qrcode;
        this.info = info;
    }

    public Leitor(Leitor lei){
        qrcode = lei.getQrcode();
        info = lei.getInfo();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public QRcode getInfo() {
        return info;
    }

    public void setInfo(QRcode info) {
        this.info = info;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leitor leitor = (Leitor) o;
        return Objects.equals(qrcode, leitor.qrcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qrcode);
    }

    public Leitor clone(){
        return new Leitor(this);
    }
}
