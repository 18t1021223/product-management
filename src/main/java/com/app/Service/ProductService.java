package com.app.Service;

import com.app.Utils.Utils;
import com.app.dao.ProductDAO;
import com.app.entity.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Collections;
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

    /**
     * sort by price
     *
     * @return
     */
    public List<Product> findAll() {
        List<Product> list = productDAO.findAll();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getProductPrice() > list.get(j).getProductPrice()) {
                    Collections.swap(list, i, j);
                }
            }
        }
        return list;
    }

    public Product findById(String id) {
        return productDAO.findById(id);
    }

    public boolean save(Product product) throws Exception {
        if (product.getProductId() == null || product.getProductId().isEmpty()) {
            throw new Exception("??i???n m?? s???n ph???m");
        } else if (product.getProductId().length() > 6) {
            throw new Exception("M?? s???n ph???m t???i ??a 6 k?? t???");
        } else if (product.getProductName() == null) {
            throw new Exception("??i???n t??n s???n ph???m");
        } else if (!Pattern.matches(REGEX_NAME_PRODUCT, product.getProductName())) {
            throw new Exception("T??n s???n ph???m t??? 1 - 50 k?? t??? v?? ch??? ch???a k?? t??? ch???");
        } else if (product.getProductPrice() <= 0) {
            throw new Exception("Gi?? s???n ph???m ph???i l???n h??n 0");
        } else if (!Pattern.matches(REGEX_UNIT_PRODUCT, product.getProductUnit())) {
            throw new Exception("????n v??? t??nh s???n ph???m ch??? ch???a k?? t??? ch???");
        } else if (!typeImage.contains(product.getProductImage()
                .substring(product.getProductImage().lastIndexOf(".") + 1)
        )) {
            throw new Exception("?????nh d???ng file ch???p nh???n " + typeImage);
        }
        if (productDAO.findById(product.getProductId()) != null) {
            throw new Exception("S???n ph???m ???? t???n t???i");
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
