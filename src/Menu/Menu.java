package src.Menu;
import java.util.HashMap;


public class Menu {

    HashMap<java.lang.Integer,HashMap<String,Object>> menuItems;


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


    /// CONSTRUCTOR
    public Menu() {
        this.menuItems = new HashMap<>();
        this.populateMenu();

    }

    public void displayMenuItems(){
        if(menuItems.isEmpty()){
            System.out.println("No menu items found");
            return;
        }
        System.out.println(this.menuItems);
    }
}
