package model.bill;

import model.person.Buyer;

import model.person.Seller;
import model.product.Product;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {
    private String id;
    private Product product;
    private Seller seller;
    private Buyer buyer;
    private int quantity;
    private double money;
    private LocalDate dateCreated;
    private LocalDate dateOfPayment;
    private boolean status;

    public Bill() {}

    public Bill(Product product, Buyer buyer, int quantity) {
        this.product = product;
        this.buyer = buyer;
        this.quantity = quantity;
        this.money = quantity * product.getPrice();
        this.seller = product.getSeller();
        this.id = String.valueOf(System.currentTimeMillis() + " " + buyer.getPhone());
        this.dateCreated = LocalDate.now();
        status = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "_____Bill_____" + "\n" +
                "M?? h??a ????n: " + id + "\n" +
                "S???n ph???m: " + product.getName() + "\n" +
                "Ng?????i b??n: " + seller.getAccount().getName() + "\n" +
                "Ng?????i mua: " + buyer.getAccount().getName() + "\n" +
                "S??? l?????ng: " + quantity + "\n" +
                "S??? ti???n ph???i thanh to??n: " + money + "\n" +
                "Ng??y t???o: " + dateCreated.toString() + "\n" +
                "Ng??y thanh to??n: " + ((dateOfPayment == null) ? "tr???ng" : dateOfPayment.toString()) + "\n" +
                "T??nh tr???ng thanh to??n: " + status + "\n" +
                "----------"
                ;
    }
}
