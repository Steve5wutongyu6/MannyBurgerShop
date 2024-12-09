package bean;

import java.util.Date;

public class Order {
    private String oid,name,telephone,uid;
    private Double total;
    private Date orderTime;

    public Order() {
        super();
    }

    public Order(String oid, String name, String telephone, String uid, Double total, Date orderTime) {
        this.oid = oid;
        this.name = name;
        this.telephone = telephone;
        this.uid = uid;
        this.total = total;
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", uid='" + uid + '\'' +
                ", total=" + total +
                ", orderTime=" + orderTime +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
