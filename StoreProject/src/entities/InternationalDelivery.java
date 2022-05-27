package entities;

import java.math.BigDecimal;

public class InternationalDelivery extends Delivery{

    static double customsTaxes;
    static double costInternationalDelivery;


    public InternationalDelivery() {

    }

    public double getCustomsTaxes() {
        return customsTaxes;
    }

    public double getCostInternationalDelivery() {
        return costInternationalDelivery;
    }

    public static void setCustomsTaxes(double customsTaxes) {
        InternationalDelivery.customsTaxes = customsTaxes;
    }

    public static void setCostInternationalDelivery(double costInternationalDelivery) {
        InternationalDelivery.costInternationalDelivery = costInternationalDelivery;
    }
}
