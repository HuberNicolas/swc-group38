class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!"); // Display the string.
        CityOffice c1= new CityOffice("Roma");
        CityOffice c2= new CityOffice("Napoli");
        CityOffice c3= new CityOffice("Valencia");

        System.out.println(CentralOffice.AllCityOffices);
        NormalBakery  NB1 = new NormalBakery("Example","Firsttreet",00,90000,"Roma");
        NormalBakery  NB2 = new NormalBakery("Example2","Firsttreet",00,90000,"Roma");

        NormalBakery  NB3 = new NormalBakery("Example3","Firsttreet",00,90000,"Napoli");
        NormalBakery  NB4 = new NormalBakery("Example4","Firsttreet",00,90000,"Valencia");

        System.out.println(c1.CityOfficeNameComplete);
        c1.printAllBakeriesNames();



    }

}