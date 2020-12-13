import java.util.Objects;

public class Localização {
    private int x;
    private int y;

    public Localização(){
        x = 0;
        y = 0;
    }

    public Localização(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Localização(Localização local){
        x = local.getX();
        y = local.getY();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localização that = (Localização) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Localização clone(){
        return new Localização(this);
    }
}
