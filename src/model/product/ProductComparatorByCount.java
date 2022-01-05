package model.product;

import java.util.Comparator;

// so sánh sản phẩm theo số lượng
public class ProductComparatorByCount implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getCount() - o1.getCount();
    }
}
