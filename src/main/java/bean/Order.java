package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String oid;
    private Date ordertime;
    private double total;
    private Integer state;
    private String address;
    private String name;
    private String telephone;
    private String uid;
    private List<OrderItem> list = new ArrayList<OrderItem>();

    public Order(String oid, Date ordertime, double total, Integer state, String address, String name, String telephone,
                 String uid, List<OrderItem> list) {
        super();
        this.oid = oid;
        this.ordertime = ordertime;
        this.total = total;
        this.state = state;
        this.address = address;
        this.name = name;
        this.telephone = telephone;
        this.uid = uid;
        this.list = list;
    }

    public Order() {
        super();
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", address="
                + address + ", name=" + name + ", telephone=" + telephone + ", uid=" + uid + ", list=" + list + "]";
    }

}
