package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] numbers;
    private int max;
    @Override
    public void run() {
        max = numbers[0];
        for (int number : numbers) {
            max =  max < number ?  number : max;
        }
        // Метод getName() выводит имя потока
        //System.out.println("Thread " + getName());
    }
    public int getMax() {
        return max;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
// END
