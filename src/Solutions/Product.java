package Solutions;

import java.beans.Customizer;

public abstract sealed class Product
    permits Food, Toy
{
    private final String id;
    private final String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public abstract void showInfo();
}

final class Food extends Product {
    private String productionDate;
    private String expirationDate;
    private String mainIngredient;

    public Food(String id, String name, double price, String productionDate, String expirationDate, String mainIngredient) {
        super(id, name, price);
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.mainIngredient = mainIngredient;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void showInfo() {
        System.out.println("商品号：" + super.getId() + "，商品名：" + super.getName() + "，价格：" + super.getPrice() + "，生产日期：" + productionDate + "，保质期：" + expirationDate + "，主要成分：" + mainIngredient);
    }
}

final class Toy extends Product {
    private String model;
    private String material;
    private String safetyLevel;

    public Toy(String id, String name, double price, String model, String material, String safetyLevel) {
        super(id, name, price);
        this.model = model;
        this.material = material;
        this.safetyLevel = safetyLevel;
    }

    public String getModel() {
        return model;
    }

    public String getMaterial() {
        return material;
    }

    public String getSafetyLevel() {
        return safetyLevel;
    }

    public void setSafetyLevel(String safetyLevel) {
        this.safetyLevel = safetyLevel;
    }

    @Override
    public void showInfo() {
        System.out.println("商品号：" + super.getId() + "，商品名：" + super.getName() + "，价格：" + super.getPrice() + "，型号：" + model + "，材料：" + material + "，安全级别：" + safetyLevel);
    }

}

class Customer{

    private final String name;
    private final String id;
    private String address;
    private String phone;

    protected Customer(String name, String id, String address, String phone) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
    }

    private Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    private Customer(String name, String id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public static Customer createCustomer(String name, String id, String address, String phone) {
        return new Customer(name, id, address, phone);
    }

    public static Customer createCustomer(String name, String id) {
        return new Customer(name, id);
    }

    public static Customer createCustomer(String name, String id, String address) {
        return new Customer(name, id, address);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void showInfo() {
        System.out.println("姓名：" + name + "，会员卡号：" + id + "，地址：" + address + "，电话：" + phone);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}



class TestProduct {
    public static void main(String[] args) {
        Product food = new Food("001", "菠萝", 8.5, "2022-03-22", "2022-04-22", "水果、热带");
        food.showInfo();
        ((Food) food).setExpirationDate("2022-05-22");
        food.showInfo();

        Product toy = new Toy("002", "挖掘机", 22.8, "X-123", "塑料", "接触级");
        toy.showInfo();
        ((Toy) toy).setSafetyLevel("食用级");
        toy.showInfo();

        var xiaoMing = new Customer("小明", "001", "北京市海淀区", "12345678901");
        xiaoMing.showInfo();

        var xiaoWang = Customer.createCustomer("小王", "002", "北京市海淀区", "12345678901");
        xiaoWang.showInfo();

    }
}
