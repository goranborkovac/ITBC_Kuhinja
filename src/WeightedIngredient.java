public class WeightedIngredient extends Ingredient{

    private double weight;
    private double pricePerUnit;

    public WeightedIngredient(int id, String nazivSastojka, double weight, double pricePerUnit) {
        super(id, nazivSastojka);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
    }

    public WeightedIngredient(String nazivSastojka, double weight) {
        super(nazivSastojka);
        this.weight = weight;
    }

    public WeightedIngredient(){

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void preracunajTezinu(double tezina ,double skaliranje){
        tezina = getWeight();
        tezina = tezina * skaliranje;
        setWeight(tezina);
    }

    public double preracunajTezinuUReceptu(double tezina ,double skaliranje){
        tezina = getWeight();
        tezina = tezina * skaliranje;
        return tezina;
    }

    public void preracunajKolicinu(double tezina ,double kolicina){
        tezina = getWeight();
        tezina = tezina + kolicina;
        setWeight(tezina);
    }

    public void smanjiKolicinu(double tezinaFrizider ,double tezinaRecept){
        tezinaFrizider = getWeight();
        tezinaFrizider = tezinaFrizider - tezinaRecept;
        setWeight(tezinaFrizider);
    }

    @Override
    public double getPrice() {
        return weight * pricePerUnit;
    }

    @Override
    public String toString() {
        return "{" + getNazivSastojka() +
                ", tezina=" + weight +
                ", cena=" + pricePerUnit +
                '}';
    }
}
