public class House {
    private String address;
    private int yearBuilt;
    private double numBaths;
    private boolean isRenovated;


    public House(String address, int yearBuilt, double numBaths, boolean isRenovated) {
        this.address = address;
        this.yearBuilt = yearBuilt;
        this.numBaths = numBaths;
        this.isRenovated = isRenovated;
    }

    public House(String address, double numBaths) {
        this(address, 1984, numBaths, false);
    }

    public House() {
        this("North Ave NW, Atlanta, GA 30332", 1);
    }

    //Getters
    public String getAddress() {
        return address;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public double getNumBaths() {
        return numBaths;
    }

    public boolean getIsRenovated() {
        return isRenovated;
    }

    //Setters (should not be accessible to other classes)
    private void setAddress(String address) {
        this.address = address;
    }

    private void setYearBuilt(int yearBuilt) {
        if (yearBuilt >= 0) {
            this.yearBuilt = yearBuilt;
        }
    }

    private void setNumBaths(double numBaths) {
        if (numBaths >= 0 && numBaths % 0.5 == 0) {
            this.numBaths = numBaths;
        }
    }

    private void setIsRenovated(boolean isRenovated) {
        this.isRenovated = isRenovated;
    }
}
