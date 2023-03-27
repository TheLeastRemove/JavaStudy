package Solutions;

public abstract class Product {
    private String id;
    private String name;
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

class Food extends Product {
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

class Toy extends Product {
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
    }
}
