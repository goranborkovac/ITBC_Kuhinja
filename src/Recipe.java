
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe implements Priceable{

    private String nazivRecepta;
    private List<WeightedIngredient> weightedIngredients;
    private double skaliranje;
    private BazaSastojaka bazaSastojaka;

    public Recipe(String nazivRecepta, List<WeightedIngredient> weightedIngredients) {
        this.nazivRecepta = nazivRecepta;
        this.weightedIngredients = weightedIngredients;
    }

    public Recipe() {}

    public String getNazivRecepta() {
        return nazivRecepta;
    }

    public List<WeightedIngredient> getWeightedIngredients() {
        return weightedIngredients;
    }

    public double getSkaliranje() {
        return skaliranje;
    }

    public void dodajSastojke(WeightedIngredient sastojak){
    this.weightedIngredients.add(sastojak);
    }

    public void izbaciSastojke(WeightedIngredient sastojak) throws Exception {
        for (int i = 0; i < weightedIngredients.size(); i++){
            if (weightedIngredients.contains(sastojak)){
                this.weightedIngredients.remove(sastojak);
            }
            else {
                throw new Exception("Ovaj sastojak ne postoji");
            }
        }
    }

    public void getScaledRecipe(double skaliranje, List<WeightedIngredient> listaRecept){
        for (WeightedIngredient sastojak : listaRecept) {
            sastojak.preracunajTezinu(sastojak.getWeight(), skaliranje/100);
        }
    }

    @Override
    public double getPrice() {
        double cena = 0;
        for (WeightedIngredient sastojak : weightedIngredients){
           cena += sastojak.getPrice();
        }
        return cena;
    }

    public double getNumberOfIngredients(){
        return weightedIngredients.size();
    }

    @Override
    public String toString() {
        return "Naziv jela: " + nazivRecepta + ", " + "sastojci: " + weightedIngredients;
    }
}
