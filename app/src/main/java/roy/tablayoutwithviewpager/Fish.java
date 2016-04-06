package roy.tablayoutwithviewpager;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Fish implements Serializable {

    private String fishName;
    private String quantiity;
    private String quantity_type;
    private String price;
    private String location;


    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public String getQuantiity() {
        return quantiity;
    }

    public void setQuantiity(String quantiity) {
        this.quantiity = quantiity;
    }

    public String getQuantity_type() {
        return quantity_type;
    }

    public void setQuantity_type(String quantity_type) {
        this.quantity_type = quantity_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
