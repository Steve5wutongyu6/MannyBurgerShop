package bean;

public class OrderItem {
    private String itemid;
    private Integer count;
    private Double subtotal;

    private Product product;
    private String oid;

    public OrderItem(String itemid, Integer count, Double subtotal, Product product, String oid) {
        super();
        this.itemid = itemid;
        this.count = count;
        this.subtotal = subtotal;
        this.product = product;
        this.oid = oid;
    }

    public OrderItem() {
        super();
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "OrderItem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + ", product=" + product
                + ", oid=" + oid + "]";
    }

}
