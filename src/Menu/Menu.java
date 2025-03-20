package src.Menu;

// Importerer nødvendige klasser fra Jackson-biblioteket og Java standardbiblioteket
// Jackson ObjectMapper bruges til at arbejde med JSON (læse/skrive JSON)
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File; // Bruges til at repræsentere filstien til JSON-filen
import java.io.IOException; // Håndterer input/output fejl
import java.util.Map; // Bruges til at holde JSON-data i et nøgle-værdi-par format
import java.util.HashMap;

/*
    Hvad er JSON og hvordan bruges det - tutorial:
    https://www.youtube.com/watch?v=bV85_gIrHTc
    Jar fil installation tutorial:
    https://www.youtube.com/watch?v=WLErNRhiZNQ

    Download følgende:

    Download link til JSON-CORE Library:
    https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.18.3/jackson-core-2.18.3.jar
    Download link til JSON-DATABIND Library:
    https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.18.3/jackson-databind-2.18.3.jar
    Download link til JSON-ANNOTATIONS Library:
    https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.18.3/jackson-annotations-2.18.3.jar
*/


public class Menu {
    /// IGNORE
    HashMap<java.lang.Integer,HashMap<String,Object>> menuItems;

    /// OLD NON-JSON EXAMPLE
    private void populateMenu(){
        double[] prices = {
                1
                ,2
                ,3
                ,4
                ,5
                ,6
                ,7
                ,8
                ,9
                ,10};

        String[] names = {
                "Span",
                "Kanlam",
                "Gembucket",
                "Cookley",
                "Tres-Zap",
                "It",
                "Tresom",
                "Solarbreeze",
                "Latlux",
                "It",
        };
        String[] descriptions = {
                "Mulberry",
                "BISACODYL",
                "TERBINAFINE HYDROCHLORIDE",
                "Diphenhydramine Hydrochloride",
                "retapamulin",
                "POISON TREATMENT ADSORBENT SUSPENSION",
                "rosiglitazone maleate and glimepiride",
                "norgestimate and ethinyl estradiol",
                "Flaxseed",
                "Miconazole Nitrate",
        };
        for (int i = 0; i < prices.length; i++) {

            double price = prices[i];
            String name = names[i];
            String description = descriptions[i];

            HashMap<String,Object> menuItem = new HashMap<>();
            menuItem.put("price", price);
            menuItem.put("name",name);
            menuItem.put("description",description);

            this.menuItems.put(i+1, menuItem);
        }

    }

    /// 1. JSON og ObjectMapper:
    ///
    ///     JSON (JavaScript Object Notation) er et tekstformat, der bruges til at repræsentere data struktureret i nøgle-værdi-par. Det er populært til dataudveksling mellem servere og applikationer.
    ///
    ///     ObjectMapper fra Jackson gør det muligt at konvertere JSON-data til Java-objekter (som Map) og tilbage.
    ///
    /// 2. Læse JSON-filen:
    ///
    ///     new File("src/Menu/menu.json") henviser til filstien, hvor dataene er gemt i JSON-format.
    ///
    ///     mapper.readValue(file, Map.class) fortæller ObjectMapper, at det forventer, at JSON-strukturen skal mappes til et Java-objekt af typen Map.
    ///
    /// 3. Fejlhåndtering (try-catch):
    ///
    ///     Hvis JSON-filen ikke findes, har forkert format, eller hvis der opstår en læsefejl, bliver fejlen fanget i catch-blokken og kastet som en runtime-fejl.
    ///
    /// 3. Udskrift af data:
    ///
    ///     Metoden men.values() henter kun værdierne fra JSON-filen og udskriver dem til konsollen.
    public void readMenuFromFile() {
        // Opretter en ObjectMapper-instans, som er kernen i Jackson-biblioteket.
        // Denne klasse bruges til at konvertere JSON-data til Java-objekter og omvendt.
        ObjectMapper mapper = new ObjectMapper();

        // Definerer filen, hvor JSON-data er gemt. I dette tilfælde peger stien på
        // "src/Menu/menu.json". Sørg for, at denne sti er korrekt i dit projekt.
        File file = new File("src/Menu/menu.json");

        try {
            // Mapper JSON-filen til en Java Map.
            // Map repræsenterer JSON-data som nøgle-værdi-par, hvilket gør det nemt at arbejde med.
            Map menu = mapper.readValue(file, Map.class);

            // Udskriver værdierne fra Map til konsollen.
            // Dette giver en liste over data fra JSON-filen.
            System.out.println(menu.values());
        } catch (IOException e) { // Håndterer alle input/output-relaterede fejl
            // Smider en RuntimeException, hvis der opstår en fejl, og konverterer fejlbeskeden til en string.
            throw new RuntimeException(String.valueOf(e));
        }
    }
    /// CONSTRUCTOR
    public Menu() {
        this.menuItems = new HashMap<>();
//        this.populateMenu();
        this.readMenuFromFile();

    }
    /// IGNORE
    public void displayMenuItems(){
        if(menuItems.isEmpty()){
            System.out.println("No menu items found");
            return;
        }
        System.out.println(this.menuItems);
    }
}
