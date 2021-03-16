package no.dnb.studentonlineretailer;

public class MyVatBean {

    private double vatPercentage;

    public double setVatPercentage(double vatPercentage) {
        return this.vatPercentage = vatPercentage;
    }

    public double getVatPercentage() {
        return this.vatPercentage;
    }

    @Override
    public String toString() {
        return "MyVatBean{" +
                "vatPercentage=" + vatPercentage +
                '}';
    }
}
