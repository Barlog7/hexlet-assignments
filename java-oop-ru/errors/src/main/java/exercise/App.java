package exercise;

// BEGIN
class App {
    public static void printSquare(Circle circle) {
        double squere;
        try {
            squere = circle.getSquare();
            System.out.println(Math.round(squere));
        } catch (NegativeRadiusException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
