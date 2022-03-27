package 排序;

import java.util.Comparator;

/*
容量排序器
 */
public class CapacityComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {

        String capacity=o1.getCapacity();
        String tempCapacity=o2.getCapacity();

        return tempCapacity.compareTo(capacity);
    }
}
