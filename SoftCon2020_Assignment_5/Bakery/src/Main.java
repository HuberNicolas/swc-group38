class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.
        NormalBakery  obj1 = new NormalBakery("Example","Firsttreet",00,90000,"Napoli");
        NormalBakery  obj2 = new NormalBakery("Example2","Firsttreet",00,90000,"Napoli");

        System.out.println(obj1.BakeryName);
        System.out.println(obj2.BakeryName);
        System.out.println(obj1.AllBakeries);
        obj1.printName();

    }

}