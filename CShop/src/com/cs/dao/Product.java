/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hasangi
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productPK.productId = :productId"),
    @NamedQuery(name = "Product.findByProductCatagoryId", query = "SELECT p FROM Product p WHERE p.productCatagoryId = :productCatagoryId"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByQty", query = "SELECT p FROM Product p WHERE p.qty = :qty"),
    @NamedQuery(name = "Product.findByBprice", query = "SELECT p FROM Product p WHERE p.bprice = :bprice"),
    @NamedQuery(name = "Product.findBySprice", query = "SELECT p FROM Product p WHERE p.sprice = :sprice"),
    @NamedQuery(name = "Product.findByUserId", query = "SELECT p FROM Product p WHERE p.userId = :userId"),
    @NamedQuery(name = "Product.findByTakeStockPrice", query = "SELECT p FROM Product p WHERE p.takeStockPrice = :takeStockPrice"),
    @NamedQuery(name = "Product.findByBranchId", query = "SELECT p FROM Product p WHERE p.productPK.branchId = :branchId"),
    @NamedQuery(name = "Product.findByUpdatedToServer", query = "SELECT p FROM Product p WHERE p.updatedToServer = :updatedToServer")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductPK productPK;
    @Column(name = "product_catagory_id")
    private Integer productCatagoryId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "qty")
    private Integer qty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "bprice")
    private Double bprice;
    @Column(name = "sprice")
    private Double sprice;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "take_stock_price")
    private Boolean takeStockPrice;
    @Column(name = "updated_to_server")
    private Integer updatedToServer;

    public Product() {
    }

    public Product(ProductPK productPK) {
        this.productPK = productPK;
    }

    public Product(int productId, int branchId) {
        this.productPK = new ProductPK(productId, branchId);
    }

    public ProductPK getProductPK() {
        return productPK;
    }

    public void setProductPK(ProductPK productPK) {
        this.productPK = productPK;
    }

    public Integer getProductCatagoryId() {
        return productCatagoryId;
    }

    public void setProductCatagoryId(Integer productCatagoryId) {
        this.productCatagoryId = productCatagoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getBprice() {
        return bprice;
    }

    public void setBprice(Double bprice) {
        this.bprice = bprice;
    }

    public Double getSprice() {
        return sprice;
    }

    public void setSprice(Double sprice) {
        this.sprice = sprice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getTakeStockPrice() {
        return takeStockPrice;
    }

    public void setTakeStockPrice(Boolean takeStockPrice) {
        this.takeStockPrice = takeStockPrice;
    }

    public Integer getUpdatedToServer() {
        return updatedToServer;
    }

    public void setUpdatedToServer(Integer updatedToServer) {
        this.updatedToServer = updatedToServer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productPK != null ? productPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productPK == null && other.productPK != null) || (this.productPK != null && !this.productPK.equals(other.productPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Product[ productPK=" + productPK + " ]";
    }
    
}
