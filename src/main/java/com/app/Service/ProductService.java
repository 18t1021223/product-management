package com.app.Service;

import com.app.Utils.Utils;
import com.app.dao.ProductDAO;
import com.app.entity.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ProductService {
    private final String REGEX_NAME_PRODUCT = "^[a-zA-Z ]{1,50}$";
    private final String REGEX_UNIT_PRODUCT = "^[a-zA-Z ]+$";
    private final List<String> typeImage = Arrays.asList(
            "png",
            "jepg",
            "jpg"
    );

    private ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAO();
    }

    public void find(JTable table, String data, String category) {
        List<Product> productList = productDAO.find(data, category);
        if (productList != null && !productList.isEmpty()) {
            DefaultTableModel datarow = (DefaultTableModel) table.getModel();
            datarow.setRowCount(0);
            int index = 1;
            for (Product item : productList) {
                datarow.addRow(new String[]{index + "",
                        item.getProductId(),
                        item.getProductName(),
                        item.getProductUnit(),
                        Utils.numberToString(item.getProductPrice())});
                index++;
            }
        }
    }

    public DefaultListModel<String> find(String data, String category) {
        List<Product> productList = productDAO.find(data, category);
        if (productList != null && !productList.isEmpty()) {
            DefaultListModel<String> dataConvert = new DefaultListModel<>();
            productList.forEach(value ->
                    dataConvert.addElement(value.getProductId() + "-" + value.getProductName()));
            return dataConvert;
        }
        return null;
    }


    public List<Product> findAll() {
        return productDAO.findAll();
    }

    public Product findById(String id) {
        return productDAO.findById(id);
    }

    public boolean save(Product product) throws Exception {
        if (product.getProductId() == null || product.getProductId().isEmpty()) {
            throw new Exception("Điền mã sản phẩm");
        } else if (product.getProductId().length() > 6) {
            throw new Exception("Mã sản phẩm tối đa 6 ký tự");
        } else if (product.getProductName() == null) {
            throw new Exception("Điền tên sản phẩm");
        } else if (!Pattern.matches(REGEX_NAME_PRODUCT, product.getProductName())) {
            throw new Exception("Tên sản phẩm từ 1 - 50 ký tự và chỉ chứa ký tự chữ");
        } else if (product.getProductPrice() <= 0) {
            throw new Exception("Giá sản phẩm phải lớn hơn 0");
        } else if (!Pattern.matches(REGEX_UNIT_PRODUCT, product.getProductUnit())) {
            throw new Exception("Đơn vị tính sản phẩm chỉ chứa ký tự chữ");
        } else if (!typeImage.contains(product.getProductImage()
                .substring(product.getProductImage().lastIndexOf(".") + 1)
        )) {
            throw new Exception("Định dạng file chấp nhận " + typeImage);
        }
        if (productDAO.findById(product.getProductId()) != null) {
            throw new Exception("Sản phẩm đã tồn tại");
        }
        return productDAO.save(product);
    }

    public boolean update(Product product) {
        return productDAO.update(product);
    }

    public void remove(List<String> idList) {
        productDAO.deleteIn(idList);
    }
}
