import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Paletes {
    private Map<String, Palete> paletes;

    public Paletes(Map<String, Palete> paletes) {
        setPaletes(paletes);
    }

    public Paletes(){
        paletes = new HashMap<>();
    }

    public Paletes(Paletes pal){
        setPaletes(pal.getPaletes());

    }

    public Map<String, Palete> getPaletes() {
        Map<String, Palete> auxpaletes = new HashMap<>();
        for(Palete n: paletes.values()){
            auxpaletes.put(n.getCodPalete(), n);
        }
        return auxpaletes;
    }

    public void setPaletes(Map<String, Palete> paletes) {
        this.paletes = new HashMap<>();
        for(Palete n: paletes.values()){
            this.paletes.put(n.getCodPalete(), n);
        }
    }

    public void adicionaPalete(Palete a){
        this.paletes.put(a.getCodPalete(), a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paletes paletes1 = (Paletes) o;
        return Objects.equals(paletes, paletes1.paletes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paletes);
    }

    public Paletes clone(){
        return new Paletes(this);
    }

    public Map<String,Localização> consulta(){
        Map<String,Localização> consultas = new HashMap<>();
        for(Map.Entry<String,Palete> p: this.paletes.entrySet()){
            consultas.put(p.getKey(), p.getValue().getLocalização());
        }
        return consultas;
    }

}
