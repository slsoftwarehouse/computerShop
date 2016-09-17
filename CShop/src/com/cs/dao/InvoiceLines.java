/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "InvoiceLines.findById", query = "SELECT i FROM InvoiceLines i WHERE i.invoiceLinesPK.id = :id"),
    @NamedQuery(name = "InvoiceLines.findByInvoice", query = "SELECT i FROM InvoiceLines i WHERE i.invoiceLinesPK.invoice = :invoice"),
    @NamedQuery(name = "InvoiceLines.findByProduct", query = "SELECT i FROM InvoiceLines i WHERE i.invoiceLinesPK.product = :product"),
    @NamedQuery(name = "InvoiceLines.findBySerial", query = "SELECT i FROM InvoiceLines i WHERE i.invoiceLinesPK.serial = :serial"),
    @NamedQuery(name = "InvoiceLines.findByQty", query = "SELECT i FROM InvoiceLines i WHERE i.qty = :qty"),
    @NamedQuery(name = "InvoiceLines.findByWarrantyEndDate", query = "SELECT i FROM InvoiceLines i WHERE i.warrantyEndDate = :warrantyEndDate"),
    @NamedQuery(name = "InvoiceLines.findByCostPrice", query = "SELECT i FROM InvoiceLines i WHERE i.costPrice = :costPrice"),
    @NamedQuery(name = "InvoiceLines.findByActualCostPrice", query = "SELECT i FROM InvoiceLines i WHERE i.actualCostPrice = :actualCostPrice"),
    @NamedQuery(name = "InvoiceLines.findByEndUserPrice", query = "SELECT i FROM InvoiceLines i WHERE i.endUserPrice = :endUserPrice"),
    @NamedQuery(name = "InvoiceLines.findByDealerPrice", query = "SELECT i FROM InvoiceLines i WHERE i.dealerPrice = :dealerPrice"),
    @NamedQuery(name = "InvoiceLines.findBySellingPrice", query = "SELECT i FROM InvoiceLines i WHERE i.sellingPrice = :sellingPrice"),
    @NamedQuery(name = "InvoiceLines.findByDisscount", query = "SELECT i FROM InvoiceLines i WHERE i.disscount = :disscount"),
    @NamedQuery(name = "InvoiceLines.findByTotal", query = "SELECT i FROM InvoiceLines i WHERE i.total = :total"),
    @NamedQuery(name = "InvoiceLines.findByIsreturn", query = "SELECT i FROM InvoiceLines i WHERE i.isreturn = :isreturn"),
    @NamedQuery(name = "InvoiceLines.findByReturnDate", query = "SELECT i FROM InvoiceLines i WHERE i.returnDate = :returnDate"),
    @NamedQuery(name = "InvoiceLines.findByDatetime", query = "SELECT i FROM InvoiceLines i WHERE i.datetime = :datetime"),
    @NamedQuery(name = "InvoiceLines.findByPrefix", query = "SELECT i FROM InvoiceLines i WHERE i.prefix = :prefix")})
public class InvoiceLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvoiceLinesPK invoiceLinesPK;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "warranty_end_date")
    @Temporal(TemporalType.DATE)
    private Date warrantyEndDate;
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
    @Column(name = "prefix")
    private String prefix;
    @JoinColumn(name = "invoice", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Invoice invoice1;
    @JoinColumn(name = "product", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product1;
    @JoinColumn(name = "serial", referencedColumnName = "serial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrnLines grnLines;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public InvoiceLines() {
    }

    public InvoiceLines(InvoiceLinesPK invoiceLinesPK) {
        this.invoiceLinesPK = invoiceLinesPK;
    }

    public InvoiceLines(String id, String invoice, String product, String serial) {
        this.invoiceLinesPK = new InvoiceLinesPK(id, invoice, product, serial);
    }

    public InvoiceLinesPK getInvoiceLinesPK() {
        return invoiceLinesPK;
    }

    public void setInvoiceLinesPK(InvoiceLinesPK invoiceLinesPK) {
        this.invoiceLinesPK = invoiceLinesPK;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public void setWarrantyEndDate(Date warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Invoice getInvoice1() {
        return invoice1;
    }

    public void setInvoice1(Invoice invoice1) {
        this.invoice1 = invoice1;
    }

    public Product getProduct1() {
        return product1;
    }

    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    public GrnLines getGrnLines() {
        return grnLines;
    }

    public void setGrnLines(GrnLines grnLines) {
        this.grnLines = grnLines;
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
        hash += (invoiceLinesPK != null ? invoiceLinesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceLines)) {
            return false;
        }
        InvoiceLines other = (InvoiceLines) object;
        if ((this.invoiceLinesPK == null && other.invoiceLinesPK != null) || (this.invoiceLinesPK != null && !this.invoiceLinesPK.equals(other.invoiceLinesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.InvoiceLines[ invoiceLinesPK=" + invoiceLinesPK + " ]";
    }
    
}
