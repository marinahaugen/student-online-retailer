package no.dnb.studentonlineretailer.bizlayer;

public class MyVatBean {

    private double vatPercentage;

    public void setVatPercentage(double vatPercentage) {
        this.vatPercentage = vatPercentage;
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
