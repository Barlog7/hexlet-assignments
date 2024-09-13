package exercise;

// BEGIN
public class ListThread extends Thread {
    SafetyList safetyList;
    ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }
    @Override
    public void run() {

        for (int i=1; i<=1000; i++) {
/*            try {
                this.wait(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            safetyList.add(1);
        }
    }
}
// END
