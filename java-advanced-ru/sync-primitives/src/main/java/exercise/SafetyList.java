package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    // BEGIN
    private List<Integer> list = new ArrayList<Integer>();

    public synchronized void add(Integer number) {
        this.list.add(number);
    }

    public int get(Integer index) {
        return this.list.get(index);
    }

    public int getSize() {
        return this.list.size();
    }
    // END
}
