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
        treadMin.start();
        try {
            treadMax.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            treadMin.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int max = treadMax.getMax();
        int min = treadMin.getMin();
        var map = new HashMap<String, Integer>();
        map.put("max",max);
        map.put("min", min);
        return map;

    }

    // END
}
