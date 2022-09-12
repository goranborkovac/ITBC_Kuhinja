public abstract class Ingredient implements Priceable{

    private int id;
    private String nazivSastojka;

    public Ingredient(int id, String nazivSastojka) {
        this.id = id;
        this.nazivSastojka = nazivSastojka;
    }
    public Ingredient(){

    }

    public Ingredient(String nazivSastojka) {
        this.nazivSastojka = nazivSastojka;
    }

    public int getId() {
        return id;
    }

    public String getNazivSastojka() {
        return nazivSastojka;
    }

    @Override
    public String toString() {
        return "Sastojak " + getId() + ": " + nazivSastojka;
    }
}
