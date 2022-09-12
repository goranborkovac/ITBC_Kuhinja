import javax.sound.midi.Receiver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BazaRecepata {

    public Fridge provera(ArrayList<WeightedIngredient> lista) {
        return new Fridge(lista);
    }

    public List<Recipe> dohvatiRecept() {

        List<Recipe> listaRecepata = new ArrayList<>();

        // Recept br 1
        Recipe jajaNaOko;

        List<WeightedIngredient> sastojciJajeNaOko = new ArrayList<>();
        WeightedIngredient jaja = new WeightedIngredient(5, "Jaja", 4, 12);
        WeightedIngredient so = new WeightedIngredient(2, "So", 0.01, 30);
        sastojciJajeNaOko.add(jaja);
        sastojciJajeNaOko.add(so);
        jajaNaOko = new Recipe("Jaja na oko", sastojciJajeNaOko);


        // Recept br 2
        Recipe musaka;

        List<WeightedIngredient> sastojciMusaka = new ArrayList<>();
        WeightedIngredient krompir = new WeightedIngredient(1, "Krompir", 2.0, 90);
        WeightedIngredient meso = new WeightedIngredient(2, "Mleveno meso", 0.8, 650);
        sastojciMusaka.add(krompir);
        sastojciMusaka.add(meso);
        musaka = new Recipe("Musaka", sastojciMusaka);

        // Recept br 3
        Recipe bolonjeze;

        List<WeightedIngredient> sastojciBolonjeze = new ArrayList<>();

        WeightedIngredient so1 = new WeightedIngredient(2, "So", 0.03, 30);
        WeightedIngredient biber = new WeightedIngredient(3, "Biber", 0.02, 20);
        WeightedIngredient mlevenoMeso = new WeightedIngredient(4, "Mleveno meso", 1.2, 650);
        WeightedIngredient sir = new WeightedIngredient(6, "Sir", 0.2, 850);
        WeightedIngredient spagete = new WeightedIngredient(12, "Spagete", 0.5, 130);
        sastojciBolonjeze.add(spagete);
        sastojciBolonjeze.add(mlevenoMeso);
        sastojciBolonjeze.add(so1);
        sastojciBolonjeze.add(biber);
        sastojciBolonjeze.add(sir);
        bolonjeze = new Recipe("Bolonjeze", sastojciBolonjeze);


        // Recept br 4
        Recipe punjenaPaprika;

        List<WeightedIngredient> sastojciPunjenaPaprika = new ArrayList<>();
        WeightedIngredient paprika = new WeightedIngredient(8, "Paprika", 0.8, 120);
        WeightedIngredient mlevenoMeso1 = new WeightedIngredient(2, "Mleveno meso", 0.5, 650);
        sastojciPunjenaPaprika.add(paprika);
        sastojciPunjenaPaprika.add(mlevenoMeso1);
        punjenaPaprika = new Recipe("Punjena paprika", sastojciPunjenaPaprika);

        // Recept br 5
        Recipe supa;

        List<WeightedIngredient> sastojciZaSupu = new ArrayList<>();
        WeightedIngredient piletina = new WeightedIngredient(13, "Piletina", 0.7, 350);
        WeightedIngredient so2 = new WeightedIngredient(2, "So", 0.04, 30);
        WeightedIngredient biber2 = new WeightedIngredient(3, "Biber", 0.02, 20);
        WeightedIngredient zacinBag = new WeightedIngredient(7, "Zacin BAG", 0.05, 400);
        WeightedIngredient krompir1 = new WeightedIngredient(1, "Krompir", 0.5, 90);
        sastojciZaSupu.add(piletina);
        sastojciZaSupu.add(so2);
        sastojciZaSupu.add(biber2);
        sastojciZaSupu.add(zacinBag);
        sastojciZaSupu.add(krompir1);
        supa = new Recipe("Supa", sastojciZaSupu);

        // Recept br 6
        Recipe tortilje;

        List<WeightedIngredient> sastojciZaTortilje = new ArrayList<>();
        WeightedIngredient piletina1 = new WeightedIngredient(13, "Piletina", 0.5, 350);
        WeightedIngredient so3 = new WeightedIngredient(2, "So", 0.01, 30);
        WeightedIngredient biber3 = new WeightedIngredient(3, "Biber", 0.01, 20);
        WeightedIngredient tortilja = new WeightedIngredient(15, "Tortilja", 2, 30);
        WeightedIngredient paradajz = new WeightedIngredient(9, "Paradajz", 0.5, 150);
        WeightedIngredient crniLuk = new WeightedIngredient(10, "Crni luk", 0.2, 60);
        sastojciZaTortilje.add(piletina1);
        sastojciZaTortilje.add(so3);
        sastojciZaTortilje.add(biber3);
        sastojciZaTortilje.add(tortilja);
        sastojciZaTortilje.add(paradajz);
        sastojciZaTortilje.add(crniLuk);
        tortilje = new Recipe("Tortilje", sastojciZaTortilje);

        // Recept br 7
        Recipe gulas;

        List<WeightedIngredient> sastojciZaGulas = new ArrayList<>();
        WeightedIngredient krompir3 = new WeightedIngredient(1, "Krompir", 0.7, 90);
        WeightedIngredient so4 = new WeightedIngredient(2, "So", 0.01, 30);
        WeightedIngredient biber4 = new WeightedIngredient(3, "Biber", 0.01, 20);
        WeightedIngredient zacinBag1 = new WeightedIngredient(7, "Zacin BAG", 0.1, 400);
        WeightedIngredient crniLuk1 = new WeightedIngredient(10, "Crni luk", 0.4, 60);
        WeightedIngredient svinjetina = new WeightedIngredient(14, "Svinjetina", 1.5, 700);
        sastojciZaGulas.add(krompir3);
        sastojciZaGulas.add(so4);
        sastojciZaGulas.add(biber4);
        sastojciZaGulas.add(zacinBag1);
        sastojciZaGulas.add(crniLuk1);
        sastojciZaGulas.add(svinjetina);
        gulas = new Recipe("Gulas", sastojciZaGulas);

        // Recept br 8
        Recipe sataras;

        List<WeightedIngredient> sastojciZaSataras = new ArrayList<>();

        WeightedIngredient so5 = new WeightedIngredient(2, "So", 0.01, 30);
        WeightedIngredient biber5 = new WeightedIngredient(3, "Biber", 0.02, 20);
        WeightedIngredient zacinBag2 = new WeightedIngredient(7, "Zacin BAG", 0.1, 400);
        WeightedIngredient paprika2 = new WeightedIngredient(8, "Paprika", 1, 120);
        WeightedIngredient paradajz2 = new WeightedIngredient(9, "Paradajz", 0.6, 150);
        WeightedIngredient crniLuk2 = new WeightedIngredient(10, "Crni luk", 0.5, 60);

        sastojciZaSataras.add(so5);
        sastojciZaSataras.add(biber5);
        sastojciZaSataras.add(zacinBag2);
        sastojciZaSataras.add(paprika2);
        sastojciZaSataras.add(paradajz2);
        sastojciZaSataras.add(crniLuk2);

        sataras = new Recipe("Sataras", sastojciZaSataras);


        // Recept br 9
        Recipe pilav;

        List<WeightedIngredient> sastojciZaPilav = new ArrayList<>();

        WeightedIngredient so6 = new WeightedIngredient(2, "So", 0.01, 30);
        WeightedIngredient crniLuk3 = new WeightedIngredient(10, "Crni luk", 0.3, 60);
        WeightedIngredient piletina3 = new WeightedIngredient(13, "Piletina", 0.5, 350);
        WeightedIngredient pirinac = new WeightedIngredient(16, "Pirinac", 0.5, 200);

        sastojciZaPilav.add(so6);
        sastojciZaPilav.add(crniLuk3);
        sastojciZaPilav.add(piletina3);
        sastojciZaPilav.add(pirinac);

        pilav = new Recipe("Pilav", sastojciZaPilav);

        // Recept br 10
        Recipe cufteUParadajzSosu;

        List<WeightedIngredient> sastojciZaCufte = new ArrayList<>();

        WeightedIngredient so7 = new WeightedIngredient(2, "So", 0.01, 30);
        WeightedIngredient mlevenoMeso3 = new WeightedIngredient(4, "Mleveno meso", 1, 650);
        WeightedIngredient jaja2 = new WeightedIngredient(5, "Jaja", 1, 12);
        WeightedIngredient crniLuk4 = new WeightedIngredient(10, "Crni luk", 0.2, 60);
        WeightedIngredient paradajz3 = new WeightedIngredient(9, "Paradajz", 1, 150);
        WeightedIngredient beliLuk = new WeightedIngredient(11, "Beli luk", 0.3, 450);

        sastojciZaCufte.add(so7);
        sastojciZaCufte.add(mlevenoMeso3);
        sastojciZaCufte.add(jaja2);
        sastojciZaCufte.add(crniLuk4);
        sastojciZaCufte.add(paradajz3);
        sastojciZaCufte.add(beliLuk);

        cufteUParadajzSosu = new Recipe("Cufte u paradajz sosu", sastojciZaCufte);

        ////////////////////////////////////////////

        listaRecepata.add(jajaNaOko);
        listaRecepata.add(musaka);
        listaRecepata.add(bolonjeze);
        listaRecepata.add(punjenaPaprika);
        listaRecepata.add(supa);
        listaRecepata.add(tortilje);
        listaRecepata.add(gulas);
        listaRecepata.add(sataras);
        listaRecepata.add(pilav);
        listaRecepata.add(cufteUParadajzSosu);

        return listaRecepata;
    }

    public Recipe nadjiSastojkeRecepta(String nazivJela, List<Recipe> recipeList) throws Exception {

        for (Recipe recipe : recipeList) {
            if (recipe.getNazivRecepta().equals(nazivJela)) {
                return recipe;
            }
        }
        return null;
    }
}


