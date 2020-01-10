package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(DiscountPK.class)
@Table(name = "discount", schema = "cnpm", catalog = "")
public class Discount {
    private int eventId;
    private int productId;
    private int discount;

    @Id
    @Column(name = "event_id")
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "discount")
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return eventId == discount1.eventId &&
                productId == discount1.productId &&
                discount == discount1.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, productId, discount);
    }
}
