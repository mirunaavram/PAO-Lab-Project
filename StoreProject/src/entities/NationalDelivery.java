package entities;

import java.math.BigDecimal;

public class NationalDelivery extends Delivery{

    private double costEasyBox;

    public NationalDelivery(double costEasyBox) {
        this.costEasyBox = costEasyBox;
    }

    public double getCostEasyBox() {
        return costEasyBox;
    }
}
