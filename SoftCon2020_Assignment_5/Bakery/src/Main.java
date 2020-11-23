import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

        //initiate some test objects:
        //initiate CentralOffice
        CentralOffice CetrO = new CentralOffice();

        //initiate CityOffices
        CityOffice c1= new CityOffice("Roma");
        CityOffice c2= new CityOffice("Napoli");
        CityOffice c3= new CityOffice("Valencia");

        //initiate some bakeries
        NormalBakery  NB1 = new NormalBakery("Bakery Roma","Firsttreet",00,90000,"Roma");
        NormalBakery  NB2 = new NormalBakery("Bakery Rossi (in Roma)","Firsttreet",00,90000,"Roma");

        BakerySpecializedBread  NB3 = new BakerySpecializedBread("Bakery Napoli","Firsttreet",00,90000,"Napoli");
        BakerySpecilizedSweets  NB4 = new BakerySpecilizedSweets("Bakery Valencia","Firsttreet",00,90000,"Valencia");

        //with printName() a bakery prints its name
        NB1.printName();

        //with printAllOffices(); you can now see the list of city offices and their bakeries
        CetrO.printAllOffices();

        //FoodItems examples:
        //you can make a cake and add strawberries and print its price:
        FoodItem Cake = new Cake();
        Cake = new StrawberriesDecorator(Cake);
        Cake = new StrawberriesDecorator(Cake);
        System.out.println(Cake.price());

        //you can make a sandwich and add double ham and print its price:
        FoodItem Sandwich = new Sandwich();
        Sandwich = new HamDecorator(Sandwich);
        Sandwich = new HamDecorator(Sandwich);
        System.out.println(Sandwich.price());

        //you can also use sellsItems to let it be sold by a bakery
        //But not every bakery sells every product!
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

        NB1.sellItems("Cake",CakeDecor);
        NB1.sellItems("Sandwich", SandwichDecor);

    }


}