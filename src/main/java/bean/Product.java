package bean;

public class Product {
    private int pid;
    private String pname;
    private double marketPrice;
    private double shopPrice;
    private String pimage;
    private String pdate;
    private int isHot;
    private String pdesc;
    private int pflag;
    private String cid;


    public Product() {
        super();
    }

    public Product(int pid, String pname, double marketPrice, double shopPrice, String pimage, String pdate, int isHot, String pdesc, int pflag, String cid) {
        this.pid = pid;
        this.pname = pname;
        this.marketPrice = marketPrice;
        this.shopPrice = shopPrice;
        this.pimage = pimage;
        this.pdate = pdate;
        this.isHot = isHot;
        this.pdesc = pdesc;
        this.pflag = pflag;
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", pimage='" + pimage + '\'' +
                ", pdate='" + pdate + '\'' +
                ", isHot=" + isHot +
                ", pdesc='" + pdesc + '\'' +
                ", pflag=" + pflag +
                ", cid='" + cid + '\'' +
                '}';
    }
}
