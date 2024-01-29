package exercise;

// BEGIN
class Cottage implements Home {
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.getArea() +" метров";
    }
    public int compareTo(Home home) {
        int ret = 0;
        double currentArea = this.getArea();
        double getAreaOther = home.getArea();
        if (currentArea > getAreaOther) {
            ret =1;
        } else if (currentArea < getAreaOther) {
            ret = -1;
        }
        return ret;
    }
}
// END
