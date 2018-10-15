package lk.ijse.git.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private String customerName;
    private String address;
    private String contct;
    private String imageUrl;

    public Customer() {
    }

    public Customer(String customerName, String address, String contct, String imageUrl) {
        this.customerName = customerName;
        this.address = address;
        this.contct = contct;
        this.imageUrl = imageUrl;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContct() {
        return contct;
    }

    public void setContct(String contct) {
        this.contct = contct;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", contct='" + contct + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
