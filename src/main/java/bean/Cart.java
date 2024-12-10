package bean;

import java.sql.Time;

public class Cart {
    private int cid, oid,pid;
    private String uid;
    private Time time;

    public Cart() {
        super();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", oid=" + oid +
                ", pid=" + pid +
                ", uid='" + uid + '\'' +
                ", time=" + time +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Cart(int cid, int oid, int pid, String uid, Time time) {
        this.cid = cid;
        this.oid = oid;
        this.pid = pid;
        this.uid = uid;
        this.time = time;
    }
}
