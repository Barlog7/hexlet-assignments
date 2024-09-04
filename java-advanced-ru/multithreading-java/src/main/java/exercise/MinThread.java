package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private int min;
    @Override
    public void run() {
        min = numbers[0];
        for (int number : numbers) {
            min =  min > number ?  number : min;
        }
        // Метод getName() выводит имя потока
        //System.out.println("Thread " + getName());
    }
    public int getMin() {
        return min;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
// END
