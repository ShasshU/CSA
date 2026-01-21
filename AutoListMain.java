class AutoListMain {
    public static void main(String[] args) {
        AutoList belAir = new AutoList("Chevrolet Bel Air", 1957, 60000);
        AutoList impala = new AutoList("Chevrolet Impala SS Coupe", 1964, 58000);
        AutoList torpedo = new AutoList("Pontiac Torpedo", 1941, 27000);
        AutoList coupe = new AutoList("Cadillac Coupe De Ville", 1984, 40000);
        AutoList delray = new AutoList("Chevrolet Delray Delivery", 1958, 35000);
        AutoList continental = new AutoList("Lincoln Continental", 1962, 54995);

        System.out.println("The oldest car in the showroom is the " + AutoList.oldestCar());
        System.out.println("\nThe best car in the showroom is the " + AutoList.getBestInShow());
        System.out.println("I'll buy it!");
        AutoList.gotBought(0);
        System.out.println("\nHere's the new showroom: " + AutoList.printShowroom());
    }
}