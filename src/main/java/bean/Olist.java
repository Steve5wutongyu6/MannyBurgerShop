package bean;

public class Olist {
    private String listid;
    private String uid;
    private String time;
    private String item;

    public Olist() {
        super();
    }

    public Olist(String listid, String uid, String time, String item) {
        this.listid = listid;
        this.uid = uid;
        this.time = time;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Olist{" +
                "listid='" + listid + '\'' +
                ", uid='" + uid + '\'' +
                ", time='" + time + '\'' +
                ", item='" + item + '\'' +
                '}';
    }

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
