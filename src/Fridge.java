import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fridge {

    private ArrayList<WeightedIngredient> namirnice = new ArrayList<>();
    private WeightedIngredient weightedIngredient;

    public Fridge(ArrayList<WeightedIngredient> namirnice) {
        this.namirnice = namirnice;
    }

    public Fridge() {
    }

    public ArrayList<WeightedIngredient> getNamirnice() {
        return namirnice;
    }

    public void setNamirnice(ArrayList<WeightedIngredient> namirnice) {
        this.namirnice = namirnice;
    }

    public void dodajNamirnice(WeightedIngredient namirnica, double kolicina) {

        for (int i = 0; i < namirnice.size(); i++) {
            if (namirnice.contains(namirnica)) {
                namirnica.preracunajKolicinu(namirnica.getWeight(), kolicina);
            } else {
                namirnica.preracunajKolicinu(namirnica.getWeight(), kolicina);
                this.namirnice.add(namirnica);
            }
        }
    }

    public void smanjiKolicinuNamirnicaUFrizideru(List<WeightedIngredient> sastojciRecept, List<WeightedIngredient> sastojciIzFrizidera) {

        for (WeightedIngredient sastojakFrizider : sastojciIzFrizidera) {
            String sastojakImeFriz = sastojakFrizider.getNazivSastojka();
            double tezinaFrizider = sastojakFrizider.getWeight();
            String nazivSastojka = sastojakFrizider.getNazivSastojka();

            for (WeightedIngredient sastojakRecept : sastojciRecept) {
                String sastojakImeRec = sastojakRecept.getNazivSastojka();
                if (sastojakImeRec.equals(sastojakImeFriz)) {
                    double tezinaRecept = sastojakRecept.getWeight();
                    String nazivSastojkaRecept = sastojakRecept.getNazivSastojka();
                    if (nazivSastojka.equals(nazivSastojkaRecept)) {
                        sastojakFrizider.smanjiKolicinu(tezinaFrizider, tezinaRecept);
                    }
                }
            }
        }
    }


    public void smanjiKolicinuNamirnice(String nazivNamirnice,double kolicina, List<WeightedIngredient> sastojciIzFrizidera) {

        for (WeightedIngredient sastojakFrizider : sastojciIzFrizidera) {
            String sastojakImeFriz = sastojakFrizider.getNazivSastojka();
            double tezinaFrizider = sastojakFrizider.getWeight();

                if (nazivNamirnice.equals(sastojakImeFriz)) {
                        sastojakFrizider.smanjiKolicinu(tezinaFrizider, kolicina);
                    }
                }
            }



    public void izbaciNamirnicu(String nazivNamirnice,List<WeightedIngredient> sastojciIzFrizidera) throws Exception {
        for (WeightedIngredient namirnica : sastojciIzFrizidera) {
            String nazivNamirniceIzListe = namirnica.getNazivSastojka();
            if(nazivNamirnice.equals(nazivNamirniceIzListe)) {
                sastojciIzFrizidera.remove(namirnica);
            }
                    else {
                        throw new Exception("Ova namirnica ne postoji");
                    }
                }
            }



    public boolean validanRecepat(List<WeightedIngredient> sastojciRecepta, List<WeightedIngredient> sastojciFrizider) {

        List<String> naziviSastojakaFriz = new ArrayList<>();
        List<String> naziviSastojakaRec = new ArrayList<>();

        for (WeightedIngredient temp : sastojciFrizider) {
            String nazivSastojka = temp.getNazivSastojka();
            naziviSastojakaFriz.add(nazivSastojka);
        }
        for (WeightedIngredient temp : sastojciRecepta) {
            String nazivSastojka = temp.getNazivSastojka();
            naziviSastojakaRec.add(nazivSastojka);
        }

        if (naziviSastojakaFriz.containsAll(naziviSastojakaRec)) {
            for (WeightedIngredient temp : sastojciFrizider) {
                double novaKolicina = temp.getWeight();
                String nazivSastojka = temp.getNazivSastojka();
                for (WeightedIngredient temp1 : sastojciRecepta) {
                    double kolicinaRecept = temp1.getWeight();
                    String nazivSastojka1 = temp1.getNazivSastojka();
                    if (nazivSastojka.equals(nazivSastojka1)) {
                        if (kolicinaRecept < novaKolicina) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean nazivNamirnice(String nazivNamirnice, ArrayList<WeightedIngredient> sastojciZaFrizider){
        for ( WeightedIngredient sastojakUListi : sastojciZaFrizider) {
            if (nazivNamirnice.equals(sastojakUListi.getNazivSastojka())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Namirnice: " + Arrays.asList(namirnice);
    }
}
