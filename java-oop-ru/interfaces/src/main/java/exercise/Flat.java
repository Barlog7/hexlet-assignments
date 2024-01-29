package exercise;

// BEGIN
class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }


    public double getArea() {
        return area + balconyArea;
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
    @Override
    public String toString() {
        return "Квартира площадью " + this.getArea() +" метров на " + this.floor + " этаже";
    }
}
// END
