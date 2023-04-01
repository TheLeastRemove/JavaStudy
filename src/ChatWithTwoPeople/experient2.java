package ChatWithTwoPeople;


class Commerdity{
    String CID;
    String Cname;
    double Cprice;
    public Commerdity(){
    }
    public Commerdity(String cid,String cname,double cprice){
        CID=cid;
        Cname=cname;
        Cprice=cprice;
    }
    public String getCID(){
        return CID;
    }
    public String getCname(){
        return Cname;
    }
    public double getCprice(){
        return Cprice;
    }
    public void setCprice(double newprice){
        Cprice=newprice;
    }
    public String toString() {
        return "商品号："+CID+"商品名："+Cname+"商品价格："+Cprice+"元。";
    }
}
class Food extends Commerdity{
    public String ProductionDate;
    public String ExpirationDate;
    public String Basis;
    public Food() {
    }
    public Food(String cid,String cname,double cprice,String productiondate,String expirationdate,String basis) {
        super(cid,cname,cprice);
        ProductionDate=productiondate;
        ExpirationDate=expirationdate;
        Basis=basis;
    }
    public String toString() {
        return "商品编号："+CID+"商品名称："+Cname+"商品价格："+Cprice+"生产日期："+ProductionDate+"保质期："+ExpirationDate+"主要成分："+Basis;
    }
}
class Toy extends Commerdity{
    String type;
    String materials;
    String safety;
    public Toy() {}
    public Toy(String cid,String cname,double cprice,String type,String materials,String safety) {
        super(cid,cname,cprice);
        this.type=type;
        this.materials=materials;
        this.safety=safety;
    }
    public String toString() {
        return "商品编号："+CID+"商品名称："+Cname+"商品价格："+Cprice+"玩具型号："+type+"商品材料："+materials+"安全级别："+safety;
    }
}
class Customer{
    String name;
    String gendaer;
    double balance;
    boolean vip=true;
    public Customer() {}
    public Customer(String name,String gendaer,double balance) {
        this.name=name;
        this.gendaer=gendaer;
        this.balance=balance;
    }
    public float shop(Food food,Toy toy,int num1,int num2) {
        float sum=(float)((food.getCprice()*num1+toy.getCprice()*num2));
        return sum;
    }
    public String toString() {
        return "顾客信息如下：\n"+"姓名："+name+"性别："+gendaer+"账户余额："+balance+"元";
    }
    public void discount(float sum) {
        if(vip) {
            System.out.println(("您可以享受八折优惠。折扣后，您需要支付%.2f元。").formatted(sum*0.8));
        }
        else {
            System.out.println("您需要支付"+sum+"元。");
        }
    }
}
public class experient2{
    public static void main(String args[]) {
        Commerdity C1=new Commerdity("63", "商品", 15.0);
        System.out.println(C1.toString());
        C1.setCprice(30);
        System.out.println(C1.toString());
        Food food=new Food("064","泡芙",12.0,"2021年4月1日","1天","奶油");
        System.out.println(food.toString());
        Toy toy=new Toy("186","巴斯光年",300.0,"小型","塑料","一级");
        System.out.println(toy.toString());
        Customer C=new Customer("小张","男",500.0);
        System.out.println(C.toString());
        C.discount(C.shop(food, toy, 1, 1));
    }
}