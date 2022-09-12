import java.util.ArrayList;
import java.util.List;

public class BazaSastojaka {

    private List<WeightedIngredient> sastojci = new ArrayList<>();

    public BazaSastojaka() {
    }

    public List<WeightedIngredient> getSastojci() {
        return sastojci;
    }
    public void setSastojci(List<WeightedIngredient> sastojci) {
        this.sastojci = sastojci;
    }

    WeightedIngredient krompir = new WeightedIngredient(1, "Krompir", 1, 90);
    WeightedIngredient so = new WeightedIngredient(2, "So", 0.05, 30);
    WeightedIngredient biber = new WeightedIngredient(3, "Biber", 0.02, 20);
    WeightedIngredient mlevenoMeso = new WeightedIngredient(4, "Mleveno meso", 1, 650);
    WeightedIngredient jaja = new WeightedIngredient(5, "Jaja", 1, 12);
    WeightedIngredient sir = new WeightedIngredient(6, "Sir", 1, 850);
    WeightedIngredient zacinBag = new WeightedIngredient(7, "Zacin BAG", 0.5, 400);
    WeightedIngredient paprika = new WeightedIngredient(8, "Paprika", 1, 120);
    WeightedIngredient paradajz = new WeightedIngredient(9, "Paradajz", 1, 150);
    WeightedIngredient crniLuk = new WeightedIngredient(10, "Crni luk", 1, 60);
    WeightedIngredient beliLuk = new WeightedIngredient(11, "Beli luk", 1, 450);
    WeightedIngredient spagete = new WeightedIngredient(12, "Spagete", 0.5, 130);
    WeightedIngredient piletina = new WeightedIngredient(13, "Piletina", 1, 350);
    WeightedIngredient svinjetina = new WeightedIngredient(14, "Svinjetina", 1, 700);
    WeightedIngredient tortilja = new WeightedIngredient(15, "Tortilja", 1, 30);
    WeightedIngredient pirinac = new WeightedIngredient(16, "Pirinac", 1, 200);


    public List<WeightedIngredient> napuniBazu(){
        sastojci.add(krompir);
        sastojci.add(so);
        sastojci.add(biber);
        sastojci.add(mlevenoMeso);
        sastojci.add(jaja);
        sastojci.add(sir);
        sastojci.add(zacinBag);
        sastojci.add(paprika);
        sastojci.add(paradajz);
        sastojci.add(crniLuk);
        sastojci.add(beliLuk);
        sastojci.add(spagete);
        sastojci.add(piletina);
        sastojci.add(svinjetina);
        sastojci.add(tortilja);
        sastojci.add(pirinac);
        return sastojci;
    }

    public List<WeightedIngredient> dohvatiSastojke(List<String> sastojci, List<WeightedIngredient> lista) {

        List<WeightedIngredient> listaZaRecept = new ArrayList<>();
        WeightedIngredient sastojak = null;

        for (String s : sastojci) {
            for (WeightedIngredient weightedIngredient : lista) {
                if (weightedIngredient.getNazivSastojka().equals(s)) {
                    sastojak = weightedIngredient;
                    listaZaRecept.add(sastojak);
                }
            }
        }
        return listaZaRecept;
    }

}
