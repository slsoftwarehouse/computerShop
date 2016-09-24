/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author home
 */
@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id"),
    @NamedQuery(name = "Invoice.findByShowinbill", query = "SELECT i FROM Invoice i WHERE i.showinbill = :showinbill"),
    @NamedQuery(name = "Invoice.findByTotalBillable", query = "SELECT i FROM Invoice i WHERE i.totalBillable = :totalBillable"),
    @NamedQuery(name = "Invoice.findByTotalDisscount", query = "SELECT i FROM Invoice i WHERE i.totalDisscount = :totalDisscount"),
    @NamedQuery(name = "Invoice.findByTotalWithoutDisscount", query = "SELECT i FROM Invoice i WHERE i.totalWithoutDisscount = :totalWithoutDisscount"),
    @NamedQuery(name = "Invoice.findByShowPrice", query = "SELECT i FROM Invoice i WHERE i.showPrice = :showPrice"),
    @NamedQuery(name = "Invoice.findByAdminHide", query = "SELECT i FROM Invoice i WHERE i.adminHide = :adminHide"),
    @NamedQuery(name = "Invoice.findByDatetime", query = "SELECT i FROM Invoice i WHERE i.datetime = :datetime")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "showinbill")
    private Boolean showinbill;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_billable")
    private Double totalBillable;
    @Column(name = "total_disscount")
    private Double totalDisscount;
    @Column(name = "total_without_disscount")
    private Double totalWithoutDisscount;
    @Column(name = "show_price")
    private Integer showPrice;
    @Column(name = "admin_hide")
    private Boolean adminHide;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "approved_user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users approvedUser;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch orgBranch;
    @JoinColumn(name = "customer", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private com.cs.dao.Entity customer;
    @JoinColumn(name = "payment_method", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationConstants paymentMethod;
    @JoinColumn(name = "recomended_user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users recomendedUser;
    @JoinColumn(name = "invoice_status", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationConstants invoiceStatus;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;
    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<InvoiceLines> invoiceLinesList;

    public Invoice() {
    }

    public Invoice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getShowinbill() {
        return showinbill;
    }

    public void setShowinbill(Boolean showinbill) {
        this.showinbill = showinbill;
    }

    public Double getTotalBillable() {
        return totalBillable;
    }

    public void setTotalBillable(Double totalBillable) {
        this.totalBillable = totalBillable;
    }

    public Double getTotalDisscount() {
        return totalDisscount;
    }

    public void setTotalDisscount(Double totalDisscount) {
        this.totalDisscount = totalDisscount;
    }

    public Double getTotalWithoutDisscount() {
        return totalWithoutDisscount;
    }

    public void setTotalWithoutDisscount(Double totalWithoutDisscount) {
        this.totalWithoutDisscount = totalWithoutDisscount;
    }

    public Integer getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(Integer showPrice) {
        this.showPrice = showPrice;
    }

    public Boolean getAdminHide() {
        return adminHide;
    }

    public void setAdminHide(Boolean adminHide) {
        this.adminHide = adminHide;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Users getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(Users approvedUser) {
        this.approvedUser = approvedUser;
    }

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
    }

    public com.cs.dao.Entity getCustomer() {
        return customer;
    }

    public void setCustomer(com.cs.dao.Entity customer) {
        this.customer = customer;
    }

    public ApplicationConstants getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(ApplicationConstants paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Users getRecomendedUser() {
        return recomendedUser;
    }

    public void setRecomendedUser(Users recomendedUser) {
        this.recomendedUser = recomendedUser;
    }

    public ApplicationConstants getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(ApplicationConstants invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @XmlTransient
    public List<InvoiceLines> getInvoiceLinesList() {
        return invoiceLinesList;
    }

    public void setInvoiceLinesList(List<InvoiceLines> invoiceLinesList) {
        this.invoiceLinesList = invoiceLinesList;
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
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Invoice[ id=" + id + " ]";
    }
    
}
