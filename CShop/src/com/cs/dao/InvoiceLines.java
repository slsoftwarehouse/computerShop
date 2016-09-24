/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author home
 */
@Entity
@Table(name = "invoice_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceLines.findAll", query = "SELECT i FROM InvoiceLines i"),
    @NamedQuery(name = "InvoiceLines.findById", query = "SELECT i FROM InvoiceLines i WHERE i.id = :id"),
    @NamedQuery(name = "InvoiceLines.findByQty", query = "SELECT i FROM InvoiceLines i WHERE i.qty = :qty"),
    @NamedQuery(name = "InvoiceLines.findByWarrantyInDays", query = "SELECT i FROM InvoiceLines i WHERE i.warrantyInDays = :warrantyInDays"),
    @NamedQuery(name = "InvoiceLines.findByCostPrice", query = "SELECT i FROM InvoiceLines i WHERE i.costPrice = :costPrice"),
    @NamedQuery(name = "InvoiceLines.findByActualCostPrice", query = "SELECT i FROM InvoiceLines i WHERE i.actualCostPrice = :actualCostPrice"),
    @NamedQuery(name = "InvoiceLines.findByEndUserPrice", query = "SELECT i FROM InvoiceLines i WHERE i.endUserPrice = :endUserPrice"),
    @NamedQuery(name = "InvoiceLines.findByDealerPrice", query = "SELECT i FROM InvoiceLines i WHERE i.dealerPrice = :dealerPrice"),
    @NamedQuery(name = "InvoiceLines.findBySellingPrice", query = "SELECT i FROM InvoiceLines i WHERE i.sellingPrice = :sellingPrice"),
    @NamedQuery(name = "InvoiceLines.findByDisscount", query = "SELECT i FROM InvoiceLines i WHERE i.disscount = :disscount"),
    @NamedQuery(name = "InvoiceLines.findByTotal", query = "SELECT i FROM InvoiceLines i WHERE i.total = :total"),
    @NamedQuery(name = "InvoiceLines.findByIsreturn", query = "SELECT i FROM InvoiceLines i WHERE i.isreturn = :isreturn"),
    @NamedQuery(name = "InvoiceLines.findByReturnDate", query = "SELECT i FROM InvoiceLines i WHERE i.returnDate = :returnDate"),
    @NamedQuery(name = "InvoiceLines.findByDatetime", query = "SELECT i FROM InvoiceLines i WHERE i.datetime = :datetime")})
public class InvoiceLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "warranty_in_days")
    private Integer warrantyInDays;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost_price")
    private Double costPrice;
    @Column(name = "actual_cost_price")
    private Double actualCostPrice;
    @Column(name = "end_user_price")
    private Double endUserPrice;
    @Column(name = "dealer_price")
    private Double dealerPrice;
    @Column(name = "selling_price")
    private Double sellingPrice;
    @Column(name = "disscount")
    private Double disscount;
    @Column(name = "total")
    private Double total;
    @Column(name = "isreturn")
    private Boolean isreturn;
    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "invoice", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Invoice invoice;
    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "serial", referencedColumnName = "serial")
    @ManyToOne(fetch = FetchType.LAZY)
    private GrnLines serial;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    public InvoiceLines() {
    }

    public InvoiceLines(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getWarrantyInDays() {
        return warrantyInDays;
    }

    public void setWarrantyInDays(Integer warrantyInDays) {
        this.warrantyInDays = warrantyInDays;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getActualCostPrice() {
        return actualCostPrice;
    }

    public void setActualCostPrice(Double actualCostPrice) {
        this.actualCostPrice = actualCostPrice;
    }

    public Double getEndUserPrice() {
        return endUserPrice;
    }

    public void setEndUserPrice(Double endUserPrice) {
        this.endUserPrice = endUserPrice;
    }

    public Double getDealerPrice() {
        return dealerPrice;
    }

    public void setDealerPrice(Double dealerPrice) {
        this.dealerPrice = dealerPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getDisscount() {
        return disscount;
    }

    public void setDisscount(Double disscount) {
        this.disscount = disscount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getIsreturn() {
        return isreturn;
    }

    public void setIsreturn(Boolean isreturn) {
        this.isreturn = isreturn;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public GrnLines getSerial() {
        return serial;
    }

    public void setSerial(GrnLines serial) {
        this.serial = serial;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceLines)) {
            return false;
        }
        InvoiceLines other = (InvoiceLines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.InvoiceLines[ id=" + id + " ]";
    }
    
}
