package 排序;

/*
实现Comparable接口（可排序）
 */
//public class Product implements Comparable<Product>{
public class Product {
    private String pName;
    private float price;
    private long pNo;
    private float weight;
    private String location;
    private String capacity;
    private String interfaces;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public long getpNo() {
        return pNo;
    }

    public void setpNo(long pNo) {
        this.pNo = pNo;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pName='" + pName + '\'' +
                ", price=" + price +
                ", pNo=" + pNo +
                ", weight=" + weight +
                ", location='" + location + '\'' +
                ", capacity='" + capacity + '\'' +
                ", interfaces='" + interfaces + '\'' +
                '}';
    }

    // 没使用泛型
    /*@Override
    public int compareTo(Object o) {
        return 0;
    }*/

    //@Override
    //public int compareTo(Product o) {
        /*
        升序排序
         */
        /*if(this.getPrice()>o.getPrice()){
            return 1;
        }else if(this.getPrice()<o.getPrice()){
            return -1;
        }
        return 0;*/
        /*String capacity=this.getCapacity();
        String tempCapacity=o.getCapacity();

        return tempCapacity.compareTo(capacity);*/
    //}
}
