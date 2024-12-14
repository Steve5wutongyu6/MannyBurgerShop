package utils;

import bean.Product;

import java.util.List;

public class JsonUtil {

    /**
     * 将商品列表转换为JSON字符串
     *
     * @param products 商品列表
     * @return JSON字符串
     */
    public static String toJson(List<Product> products) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            jsonBuilder.append("{")
                    .append("\"pid\": \"").append(product.getPid()).append("\", ")
                    .append("\"pname\": \"").append(product.getPname()).append("\"")
                    .append("}");
            if (i < products.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}
