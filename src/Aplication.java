import java.util.*;

public class Aplication {
  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);
    Scanner scc = new Scanner(System.in);

    ArrayList<WeightedIngredient> sastojciZaFrizider = new ArrayList<>();
    Fridge fridge = new Fridge();
    Recipe recipe = new Recipe();
    BazaRecepata bazaRecepata = new BazaRecepata();
    List<Recipe> listaRecepata = bazaRecepata.dohvatiRecept();
    List<Recipe> spisakOmiljenihRecepata = new ArrayList<>();

    System.out.println("Dobro dosli u kuhinju!");
    System.out.println("_________________________________");
    System.out.println("Odaberite ponudjenu opciju: ");
    System.out.println("1. Napuni frizider");
    System.out.println("2. Brisanje/menjanje kolicine namirnica u frizideru");
    System.out.println("3. Pogledajte recepte i odaberite dostupna jela na osnovu namirnica iz frizidera");
    System.out.println("4. Pogledajte koja sve skalirana jela mogu da se naprave");
    System.out.println("5. Pogledajte koja sve jela mogu da se naprave za odredjenu cenu");
    System.out.println("6. Pogledajte nivoe tezine recepata");
    System.out.println("7. Pogledajte jela sortirana po kompleksnosti sastojaka");
    System.out.println("8. Sortirajte recepte po ceni");
    // 9. Комбинација 5. и 6. услова
    System.out.println("10. Omiljeni recepti");
    System.out.println("___________________________________");

    int opcija = sc.nextInt();

    while (true) {

      if (opcija == 0) {
        System.out.println("Birajte ponovo opciju: ");
        System.out.println("1. Napuni frizider");
        System.out.println("2. Brisanje/menjanje kolicine namirnica u frizideru");
        System.out.println("3. Pogledajte recepte i odaberite dostupna jela na osnovu namirnica iz frizidera");
        System.out.println("4. Pogledajte koja sve skalirana jela mogu da se naprave");
        System.out.println("5. Pogledajte koja sve jela mogu da se naprave za odredjenu cenu");
        System.out.println("6. Pogledajte nivoe tezine recepata");
        System.out.println("7. Pogledajte jela sortirana po kompleksnosti sastojaka");
        System.out.println("8. Sortirajte recepte po ceni");
        // 9. Комбинација 5. и 6. услова
        System.out.println("10. Omiljeni recepti");
        System.out.println("___________________________________");
        opcija = sc.nextInt();
      }

      if (opcija == 1) {
        stampajOpcijeSastojaka();
        System.out.println("___________________________________");
        System.out.println("Unesite sastojke za frizider: ");
        while (opcija != 0) {
          System.out.println("Unesite naziv sastojka: ");
          String nazivSastojka = scc.nextLine();

          System.out.println("Unesite tezinu/kolicinu: ");
          double tezina = sc.nextDouble();

          WeightedIngredient sastojak = new WeightedIngredient(nazivSastojka, tezina);
          sastojciZaFrizider.add(sastojak);

          System.out.println("Da li zelite da unesete jos sastojaka?");
          System.out.println("0.Ne");
          System.out.println("1.Da");
          opcija = sc.nextInt();
        }

        System.out.println("Lista sastojaka u frizideru: " + sastojciZaFrizider);

      } else if (opcija == 2) {
        while (opcija != 0) {

          System.out.println("Izaberite opciju: ");
          System.out.println("1. Smanjenje kolicine odredjene namirnice.");
          System.out.println("2. Uklanjanje namirnice.");

          int odabirOpcije = sc.nextInt();

          if (odabirOpcije == 1) {
            System.out.println("Unesite kojoj namirnici zelite da smanjite kolicinu: ");
            String opcijaNamirnice = scc.nextLine();
            System.out.println("Unesite za koliko zelite da smanjite kolicinu: ");
            double kolicina = sc.nextDouble();

            if (fridge.nazivNamirnice(opcijaNamirnice, sastojciZaFrizider)) {

              //  System.out.println("Pre smanjenja " + sastojciZaFrizider);
              fridge.smanjiKolicinuNamirnice(opcijaNamirnice, kolicina, sastojciZaFrizider);
              //  System.out.println("Posle smanjenja " + sastojciZaFrizider);
            }

          } else if (odabirOpcije == 2) {

            System.out.println("Unesite koju namirnicu zelite da uklonite: ");
            String opcijaNamirnice = scc.nextLine();

            if (fridge.nazivNamirnice(opcijaNamirnice, sastojciZaFrizider)) {
              //  System.out.println("Pre uklanjanja " + sastojciZaFrizider);
              fridge.izbaciNamirnicu(opcijaNamirnice, sastojciZaFrizider);
              //  System.out.println("Posle uklanjanja " + sastojciZaFrizider);
            }
          }
          System.out.println("Da li zelite da smanjite ili uklonite jos namirnica?");
          System.out.println("1. Da");
          System.out.println("2. Ne");
          int broj = sc.nextInt();
          if (broj == 1) {
            opcija = 2;
          } else {
            opcija = 0;
          }
        }

      } else if (opcija == 3) {

        System.out.println("Odaberite opciju: ");
        System.out.println("1. Naruci jelo");
        System.out.println("2. Glavni meni");
        int odabir = sc.nextInt();

        if (odabir == 1) {

          stampajOpcije();
          System.out.println("_________________________________");
          System.out.println("Unesite slovima jelo koje zelite da narucite: ");
          String opcijaJela = scc.nextLine();

          if (opcijaJela.equals("Jaja na oko")) {
            try {
              Recipe jajaNaOko = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciJajaRecept = jajaNaOko.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciJajaRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();

              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              }else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          if (opcijaJela.equals("Musaka")) {
            try {
              Recipe musaka = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciMusakaRecept = musaka.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciMusakaRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();

              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              }else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          if (opcijaJela.equals("Bolonjeze")) {
            try {
              Recipe bolonjeze = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciBolonjezeRecept = bolonjeze.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciBolonjezeRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();

              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              }else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          if (opcijaJela.equals("Punjena paprika")) {
            try {
              Recipe punjenaPaprika = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciPunjenaPaprikaRecept = punjenaPaprika.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciPunjenaPaprikaRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();

              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              }else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }
            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          if (opcijaJela.equals("Supa")) {
            try {
              Recipe supa = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciSupaRecept = supa.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciSupaRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();

              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              } else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          if (opcijaJela.equals("Tortilje")) {
            try {
              Recipe tortilje = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciTortiljeRecept = tortilje.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciTortiljeRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();

              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              } else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          if (opcijaJela.equals("Gulas")) {
            try {
              Recipe gulas = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciGulasRecept = gulas.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciGulasRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();

              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              } else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          if (opcijaJela.equals("Sataras")) {
            try {
              Recipe sataras = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciSatarasRecept = sataras.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciSatarasRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();
              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              } else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          if (opcijaJela.equals("Pilav")) {
            try {
              Recipe pilav = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciPilavRecept = pilav.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciPilavRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();

              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              } else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          if (opcijaJela.equals("Cufte u paradajz sosu")) {
            try {
              Recipe cufte = bazaRecepata.nadjiSastojkeRecepta(opcijaJela, listaRecepata);
              List<WeightedIngredient> sastojciCufteRecept = cufte.getWeightedIngredients();

              proveraStanjaNamirnicaUFrizideru(fridge, sastojciCufteRecept, sastojciZaFrizider);

              System.out.println("Da li zelite da narucite jos neko jelo?");
              System.out.println("1. Da");
              System.out.println("2. Ne");
              int broj = sc.nextInt();
              if (broj == 1) {
                opcija = 3;
              } else if (broj == 2) {
                opcija = 0;
              } else {
                System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
                opcija = 0;
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        }
      } else if (opcija == 4) {

        List<Recipe> recepti = bazaRecepata.dohvatiRecept();
        List<Recipe> noviRecepti = new ArrayList<>();

        for (Recipe recept : recepti) {
          String naziv = recept.getNazivRecepta();
          List<WeightedIngredient> sastojciReceptNovo = recept.getWeightedIngredients();
          Recipe gotovRecept = new Recipe(naziv, sastojciReceptNovo);
          noviRecepti.add(gotovRecept);
        }

        stampajOpcije();
        System.out.println("Unesi opciju: ");
        int odabir = sc.nextInt();

        if (odabir == 1) {
          try {
            String jelo = "Jaja na oko";
            Recipe jajaNaOko = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciJajaRecept = jajaNaOko.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciJajaRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciJajaRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();

            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            }else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }

          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        if (odabir == 2) {
          try {
            String jelo = "Musaka";
            Recipe musaka = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciMusakaRecept = musaka.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciMusakaRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciMusakaRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();
            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            } else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }

          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        if (odabir == 3) {
          try {
            String jelo = "Bolonjeze";
            Recipe bolonjeze = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciBolonjezeRecept = bolonjeze.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciBolonjezeRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciBolonjezeRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();

            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            } else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        if (odabir == 4) {
          try {
            String jelo = "Punjena paprika";
            Recipe punjenaPaprika = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciPaprikaRecept = punjenaPaprika.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciPaprikaRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciPaprikaRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();

            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            } else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        if (odabir == 5) {
          try {
            String jelo = "Supa";
            Recipe supa = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciSupaRecept = supa.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciSupaRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciSupaRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();

            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            } else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        if (odabir == 6) {
          try {
            String jelo = "Tortilje";
            Recipe tortilje = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciTortiljeRecept = tortilje.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciTortiljeRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciTortiljeRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();

            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            } else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        if (odabir == 7) {
          try {
            String jelo = "Gulas";
            Recipe gulas = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciGulasRecept = gulas.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciGulasRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciGulasRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();

            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            } else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        if (odabir == 8) {
          try {
            String jelo = "Sataras";
            Recipe sataras = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciSatarasRecept = sataras.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciSatarasRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciSatarasRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();

            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            } else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        if (odabir == 9) {
          try {
            String jelo = "Pilav";
            Recipe pilav = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciPilavRecept = pilav.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciPilavRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciPilavRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();

            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            } else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        if (odabir == 10) {
          try {
            String jelo = "Cufte u paradajz sosu";
            Recipe cufte = bazaRecepata.nadjiSastojkeRecepta(jelo, recepti);
            List<WeightedIngredient> sastojciCufteRecept = cufte.getWeightedIngredients();

            System.out.println("Za koliko zelite da skalirate jelo: ");
            double skala = sc.nextDouble();
            recipe.getScaledRecipe(skala, sastojciCufteRecept);

            proveraStanjaNamirnicaUFrizideru(fridge, sastojciCufteRecept, sastojciZaFrizider);

            System.out.println("Da li zelite da narucite jos neko jelo?");
            System.out.println("1. Da");
            System.out.println("2. Ne");
            int broj = sc.nextInt();

            if (broj == 1) {
              opcija = 4;
            } else if (broj == 2) {
              opcija = 0;
            } else {
              System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
              opcija = 0;
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

      } else if (opcija == 5) {

        System.out.println("Unesite za koliko novca zelite da narucite jelo: ");
        double novac = sc.nextDouble();
        double cenaRecepta = 0.0;
        int brojac = 1;
        for (Recipe recept : listaRecepata) {
          cenaRecepta = recept.getPrice();
          if (cenaRecepta < novac) {
            System.out.println(brojac + ". " + recept.getNazivRecepta());
            brojac++;
          }
        }
        System.out.println("Da li zelite da nastavite sa unosom novca?");
        System.out.println("1. Da");
        System.out.println("2. Ne");
        int unosNovca = sc.nextInt();

        if (unosNovca == 1) {
          opcija = 5;
        } else if (unosNovca == 2){
          opcija = 0;
        } else {
          System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
          opcija = 0;
        }

      } else if (opcija == 6) {

        System.out.println("Tezine recepata su: ");
        int brojac = 1;
        for (NivoRecepta level : NivoRecepta.values()) {
          System.out.println(brojac + ". " + level);
          brojac++;
        }
        System.out.println("Unesite zeljenu tezina da biste pogledali koja sve jela se nalaze na spisku: ");
        int unos1 = sc.nextInt();
        if (unos1 == 1) {
          System.out.println("1. Jaja na oko" + '\n' + "2. Musaka");
        } else if (unos1 == 2) {
          System.out.println("1. Bolonjeze" + '\n' + "2. Tortilje");
        } else if (unos1 == 3) {
          System.out.println("1. Supa" + '\n' + "2. Sataras");
        } else if (unos1 == 4) {
          System.out.println("1. Punjena paprika" + '\n' + "2. Pilav");
        } else if (unos1 == 5) {
          System.out.println("1. Gulas" + '\n' + "2. Cufte u paradajz sosu");
        }

        System.out.println("Da li zelite da ponovite radnju?");
        System.out.println("1. Da");
        System.out.println("2. Ne");
        int unosRadnje = sc.nextInt();
        if (unosRadnje == 1) {
          opcija = 6;
        } else if (unosRadnje == 2){
          opcija = 0;
        } else {
          System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
          opcija = 0;
        }

      } else if (opcija == 7) {

          System.out.println("Prikaz jela po rastucem redosledu(od najmanje sastojaka ka najvise) ");
          // Rastuci
          List<Recipe> lista = bazaRecepata.dohvatiRecept();
          Collections.sort(lista, new Comparator<Recipe>() {
              @Override
              public int compare(Recipe o1, Recipe o2) {
                  return Double.compare(o1.getNumberOfIngredients(), o2.getNumberOfIngredients());
              }
          });

        int brojac = 1;
        for (Recipe recept : lista) {
          System.out.println(brojac + ". " + recept.getNazivRecepta());
          brojac++;
        }
        System.out.println("_________________________________");
        opcija = 0;

      } else if (opcija == 8) {

        System.out.println("Odaberite nacin sortiranja: ");
        System.out.println("1. Po rastucem redosledu");
        System.out.println("2. Po opadajucem redosledu");
        int unos2 = sc.nextInt();

        if (unos2 == 1) {
          // Rastuci
          List<Recipe> lista = bazaRecepata.dohvatiRecept();
          Collections.sort(lista, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
              return Double.compare(o1.getPrice(), o2.getPrice());
            }
          });
          int brojac = 1;
          for (Recipe recept : lista) {
            System.out.println(brojac + ". " + recept.getNazivRecepta());
            brojac++;
          }

          System.out.println("Zelite da ponovite sortiranje?");
          System.out.println("1. Da");
          System.out.println("2. Ne");
          int ponoviSortiranje = sc.nextInt();

          if (ponoviSortiranje == 1) {
            opcija = 8;
          } else if (ponoviSortiranje == 2){
            opcija = 0;
          } else {
            System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
            opcija = 0;
          }
        }

        if (unos2 == 2) {
          // Opadajuci
          List<Recipe> lista = bazaRecepata.dohvatiRecept();
          Collections.sort(lista, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
              return Double.compare(o2.getPrice(), o1.getPrice());
            }
          });
          int brojac = 1;
          for (Recipe recept : lista) {
            System.out.println(brojac + ". " + recept.getNazivRecepta());
            brojac++;
          }

          System.out.println("Zelite da ponovite sortiranje?");
          System.out.println("1. Da");
          System.out.println("2. Ne");
          int ponoviSortiranje = sc.nextInt();

          if (ponoviSortiranje == 1) {
            opcija = 8;
          } else if (ponoviSortiranje == 2){
            opcija = 0;
          } else {
            System.out.println("Uneli ste pogresnu opciju!" + '\n' + "Odaberite ponovo");
            opcija = 0;
          }
        }

      } else if (opcija == 10) {

        stampajOpcijeOmiljeniRecept();

        int unos = sc.nextInt();

        if (unos == 0) {

          System.out.println("ODABERITE OPCIJU: ");
          System.out.println("1. Unesite recepte koje zelite da dodate u omiljene");
          System.out.println("2. Pregled omiljenih jela");
          System.out.println("3. Izbrisite jelo iz omiljenih");
          System.out.println("4. Proverite koje jelo iz omiljenih mozete da narucite za odredjenu cenu");
          System.out.println("5. Vratite se na pocetak!");

        } else if (unos == 1) {

          stampajOpcije();
          System.out.println("Odaberite recepte koje zelite da dodate u omiljene: ");
          int odabirOpcije = sc.nextInt();

          if (odabirOpcije == 1) {

            String jelo = "Jaja na oko";
            Recipe jajaNaOko = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(jajaNaOko)) {
              spisakOmiljenihRecepata.add(jajaNaOko);
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          } else if (odabirOpcije == 2) {

            String jelo = "Musaka";
            Recipe musaka = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(musaka)) {
              spisakOmiljenihRecepata.add(musaka);
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          }
          else if (odabirOpcije == 3) {

            String jelo = "Bolonjeze";
            Recipe bolonjeze = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(bolonjeze)) {
              spisakOmiljenihRecepata.add(bolonjeze);
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          } else if (odabirOpcije == 4) {

            String jelo = "Punjena paprika";
            Recipe punjenaPaprika = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(punjenaPaprika)) {
              spisakOmiljenihRecepata.add(punjenaPaprika);
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          } else if (odabirOpcije == 5) {

            String jelo = "Supa";
            Recipe supa = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(supa)) {
              spisakOmiljenihRecepata.add(supa);
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          } else if (odabirOpcije == 6) {

            String jelo = "Tortilje";
            Recipe tortilje = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(tortilje)) {
              spisakOmiljenihRecepata.add(tortilje);
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          } else if (odabirOpcije == 7) {

            String jelo = "Gulas";
            Recipe gulas = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(gulas)) {
              spisakOmiljenihRecepata.add(gulas);
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          } else if (odabirOpcije == 8) {

            String jelo = "Sataras";
            Recipe sataras = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(sataras)) {
              spisakOmiljenihRecepata.add(sataras);
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          } else if (odabirOpcije == 9) {

            String jelo = "Pilav";
            Recipe pilav = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(pilav)) {
              spisakOmiljenihRecepata.add(pilav);
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          } else if (odabirOpcije == 10) {

            String jelo = "Cufte u paradajz sosu";
            Recipe cufte = bazaRecepata.nadjiSastojkeRecepta(jelo, listaRecepata);

            if (!spisakOmiljenihRecepata.contains(cufte)) {
              spisakOmiljenihRecepata.add(cufte);
              System.out.println("________________________________________");
            } else {
              System.out.println("Odabrani recept je vec medju omiljenim!");
            }
          }
          ///////////////////////////////////////////////////////////////////////////

          System.out.println("Da li zelite da izaberete jos neko jelo?");
          System.out.println("0.Ne");
          System.out.println("1.Da");
          System.out.println("2.Vrati na pocetak!");
          int odabirPonovo = sc.nextInt();

          if (odabirPonovo == 0) {
            unos = 0;
          } else if (odabirPonovo == 1) {
            unos = 1;
          } else {
            opcija = 0;
          }
        } else if (unos == 2) {
          if (spisakOmiljenihRecepata.isEmpty()){
            System.out.println("Nema jela u omiljenim");
            System.out.println("________________________________________");
          } else {
            System.out.println("________________________________________");
            System.out.println("Vasa omiljena jela su: ");
            int brojac = 1;
            for (Recipe recept : spisakOmiljenihRecepata){
              System.out.println(brojac + ". " + recept.getNazivRecepta());
              brojac++;
            }
          }
          System.out.println("________________________________________");
          System.out.println("1. Vratite se u meni za omiljena jela");
          System.out.println("2. Dodajte jelo u omiljene?");
          System.out.println("3. Vratite se u glavni meni");
          int odabirPonovo = sc.nextInt();

          if (odabirPonovo == 1) {
            unos = 0;
          } else if (odabirPonovo == 2) {
            unos = 1;
          } else if (odabirPonovo == 3){
            opcija = 0;
          } else {
            System.out.println("Uneli ste pogresnu opciju." + '\n' + "Birajte ponovo");
            opcija = 0;
          }

        } else if (unos == 3) {

          System.out.println("________________________________________");
          if (!spisakOmiljenihRecepata.isEmpty()){
            int brojac = 1;
            for (Recipe recept : spisakOmiljenihRecepata){
              System.out.println(brojac + ". " + recept.getNazivRecepta());
              brojac++;
            }
            System.out.println("_________________________________");
            System.out.println("Unesite slovima koje jelo zelite da izbacite iz omiljenih: ");
            String omiljenoJelo = scc.nextLine();
            spisakOmiljenihRecepata.removeIf(recept -> omiljenoJelo.equalsIgnoreCase(recept.getNazivRecepta().toLowerCase(Locale.ROOT)));
          } else {
              System.out.println("Nema omiljenih recepata na spisku");
          }
          int brojac = 1;
          for (Recipe recept : spisakOmiljenihRecepata){
            System.out.println(brojac + ". " + recept.getNazivRecepta());
            brojac++;
          }
          System.out.println("_________________________________");
          System.out.println("1. Vratite se u meni za omiljena jela");
          System.out.println("2. Vratite se u glavni meni");
          int odabirPonovo = sc.nextInt();

          if (odabirPonovo == 1) {
            unos = 0;
          } else if (odabirPonovo == 2) {
            opcija = 0;
          } else {
            System.out.println("Uneli ste pogresnu opciju." + '\n' + "Birajte ponovo");
            opcija = 0;
          }
        } else if (unos == 4){
          System.out.println("________________________________________");
          System.out.println("Unesite za koliko novca zelite da narucite jelo: ");
          double novac = sc.nextDouble();
          double cenaRecepta = 0.0;
          int brojac = 1;
          for (Recipe recept : spisakOmiljenihRecepata) {
            cenaRecepta = recept.getPrice();
            if (cenaRecepta < novac) {
              System.out.println(brojac + ". " + recept.getNazivRecepta());
              brojac++;
            }
          }
          System.out.println("________________________________________");
          System.out.println("Da li zelite da nastavite sa unosom novca?");
          System.out.println("1. Da");
          System.out.println("2. Ne");
          System.out.println("3. Vratite se u glavni meni");
          int odabirPonovo = sc.nextInt();

          if (odabirPonovo == 1) {
            unos = 4;
          } else if (odabirPonovo == 2) {
            unos = 0;
          } else if (odabirPonovo == 3){
            opcija = 0;
          }
          else {
            System.out.println("Uneli ste pogresnu opciju." + '\n' + "Birajte ponovo");
            opcija = 0;
          }
        }
      }
    }
  }

  public static void proveraStanjaNamirnicaUFrizideru(Fridge fridge, List<WeightedIngredient> sastojciJajaRecept, List<WeightedIngredient> sastojciZaFrizider) {

    boolean provera = fridge.validanRecepat(sastojciJajaRecept, sastojciZaFrizider);
    if (provera) {
      System.out.println("Uspesno ste napravili jelo!");
      System.out.println("Kolicina namirnica pre pravljenja jela: " + sastojciZaFrizider);
      fridge.smanjiKolicinuNamirnicaUFrizideru(sastojciJajaRecept, sastojciZaFrizider);
      System.out.println("Kolicina namirnica nakon pravljenja jela: " + sastojciZaFrizider);
    } else {
      System.out.println("Nemate dovoljno namirnica za ovo jelo!");
    }
  }

  public static void stampajOpcije() {

    System.out.println("Dostupni recepti su: ");
    System.out.println("1. Jaja na oko");
    System.out.println("2. Musaka");
    System.out.println("3. Bolonjeze");
    System.out.println("4. Punjena paprika");
    System.out.println("5. Supa");
    System.out.println("6. Tortilje");
    System.out.println("7. Gulas");
    System.out.println("8. Sataras");
    System.out.println("9. Pilav");
    System.out.println("10. Cufte u paradajz sosu");
  }

  public static void stampajOpcijeOmiljeniRecept() {
    System.out.println("ODABERITE OPCIJU: ");
    System.out.println("1. Unesite recepte koje zelite da dodate u omiljene");
    System.out.println("2. Pregled omiljenih jela");
    System.out.println("3. Izbrisite jelo iz omiljenih");
    System.out.println("4. Proverite koje jelo iz omiljenih mozete da narucite za odredjenu cenu");
  }
  public static void stampajOpcijeSastojaka() {

    System.out.println("Dostupni sastojci su: ");
    System.out.println("* Krompir");
    System.out.println("* So");
    System.out.println("* Biber");
    System.out.println("* Mleveno meso");
    System.out.println("* Jaja");
    System.out.println("* Sir");
    System.out.println("* Zacin BAG");
    System.out.println("* Paprika");
    System.out.println("* Paradajz");
    System.out.println("* Crni luk");
    System.out.println("* Beli luk");
    System.out.println("* Spagete");
    System.out.println("* Piletina");
    System.out.println("* Svinjetina");
    System.out.println("* Tortilja");
    System.out.println("* Pirinac");
  }
}
