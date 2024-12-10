package bean;

public class OrderItems {
    private int oid;
    private int pid;
    private String uid;

    public OrderItems() {
        super();
    }

    public OrderItems(int oid, int pid, String uid) {
        this.oid = oid;
        this.pid = pid;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "oid=" + oid +
                ", pid=" + pid +
                ", uid='" + uid + '\'' +
                '}';
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
