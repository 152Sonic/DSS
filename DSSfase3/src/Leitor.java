import java.util.Objects;

public class Leitor {
    private String qrcode;

    public Leitor(){
        qrcode = new String();
    }

    public Leitor(String qrcode) {
        this.qrcode = qrcode;
    }

    public Leitor(Leitor lei){
        qrcode = lei.getQrcode();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
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
