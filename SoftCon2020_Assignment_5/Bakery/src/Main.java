import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!"); // Display the string.
        CentralOffice CetrO = new CentralOffice();

        CityOffice c1= new CityOffice("Roma");
        CityOffice c2= new CityOffice("Napoli");
        CityOffice c3= new CityOffice("Valencia");

        System.out.println(CentralOffice.AllCityOffices);
        NormalBakery  NB1 = new NormalBakery("Bakery Roma","Firsttreet",00,90000,"Roma");
        NormalBakery  NB2 = new NormalBakery("Bakery Rossi (in Roma)","Firsttreet",00,90000,"Roma");

        BakerySpecializedBread  NB3 = new BakerySpecializedBread("Bakery Napoli","Firsttreet",00,90000,"Napoli");
        BakerySpecilizedSweets  NB4 = new BakerySpecilizedSweets("Bakery Valencia","Firsttreet",00,90000,"Valencia");

        System.out.println(c1.CityOfficeNameComplete);
        //c1.printAllBakeriesNames();
        CetrO.printAllOffices();

        //FoodItems
        FoodItem Cake = new Cake();
        Cake = new StrawberriesDecorator(Cake);
        Cake = new StrawberriesDecorator(Cake);
        //System.out.println(Cake.price());

        FoodItem Sandwich = new Sandwich();
        Sandwich = new HamDecorator(Sandwich);
        Sandwich = new HamDecorator(Sandwich);
        //System.out.println(Sandwich.price());
        ArrayList CakeDecor = new ArrayList();
        CakeDecor.add("strawberries");
        CakeDecor.add("cream");
        CakeDecor.add("cream");
        CakeDecor.add("chocolate");

        NB4.sellItems("Cake",CakeDecor);

        ArrayList SandwichDecor = new ArrayList();
        SandwichDecor.add("ham");
        SandwichDecor.add("tomatoes");
        SandwichDecor.add("cheese");
        SandwichDecor.add("tuna");
        NB3.sellItems("Sandwich",SandwichDecor);


    }


}