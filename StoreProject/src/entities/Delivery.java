package entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;

public abstract class Delivery {

    static int aux3=0;
    protected int id;
    protected LocalDate deliveryDate;
    protected Boolean delivered; //True for being delivered, false for pending

    public Delivery() {

        this.id = aux3+1;
        aux3 = this.id;
        this.delivered = false;

    }

    public int getId() {
        return id;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }
}
