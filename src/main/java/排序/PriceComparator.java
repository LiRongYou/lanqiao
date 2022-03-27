package 排序;

import java.util.Comparator;

/*
价格排序器
 */
public class PriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        }
        return 0;
    }
}
