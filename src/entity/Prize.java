package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by EliezerMdz on 09/09/2016.
 */

@ManagedBean
@RequestScoped

public class Prize {
    String description;
    String brand;
    int quantity;

    public Prize() {
    }

    public Prize(String description, String brand, int quantity) {
        this.description = description;
        this.brand = brand;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
