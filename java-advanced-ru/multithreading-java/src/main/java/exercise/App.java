package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MinThread treadMin = new MinThread();
        treadMin.setNumbers(numbers);
        MaxThread treadMax = new MaxThread();
        treadMax.setNumbers(numbers);
        treadMax.start();
        LOGGER.log(Level.INFO, "Thread " + treadMax.getName() + " started");
        treadMin.start();
        LOGGER.log(Level.INFO, "Thread " + treadMin.getName() + " started");


        try {
            treadMax.join();
            LOGGER.log(Level.INFO, "Thread " + treadMax.getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
            //throw new RuntimeException(e);
        }
        try {
            treadMin.join();
            LOGGER.log(Level.INFO, "Thread " + treadMin.getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
            //throw new RuntimeException(e);
        }
/*        int max = treadMax.getMax();
        int min = treadMin.getMin();
        var map = new HashMap<String, Integer>();
        map.put("max",max);
        map.put("min", min);*/
        Map result = Map.of(
                "min", treadMin.getMin(),
                "max", treadMax.getMax()
        );

        LOGGER.log(Level.INFO, "Result: " + result.toString());
        return result;

    }

    // END
}
