/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@javax.persistence.Entity
@Table(name = "entity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entity.findAll", query = "SELECT e FROM Entity e"),
    @NamedQuery(name = "Entity.findById", query = "SELECT e FROM Entity e WHERE e.entityPK.id = :id"),
    @NamedQuery(name = "Entity.findByEntityType", query = "SELECT e FROM Entity e WHERE e.entityPK.entityType = :entityType"),
    @NamedQuery(name = "Entity.findByTitile", query = "SELECT e FROM Entity e WHERE e.titile = :titile"),
    @NamedQuery(name = "Entity.findByName", query = "SELECT e FROM Entity e WHERE e.name = :name"),
    @NamedQuery(name = "Entity.findByActive", query = "SELECT e FROM Entity e WHERE e.active = :active"),
    @NamedQuery(name = "Entity.findByContactNumber", query = "SELECT e FROM Entity e WHERE e.contactNumber = :contactNumber"),
    @NamedQuery(name = "Entity.findByLandLine", query = "SELECT e FROM Entity e WHERE e.landLine = :landLine"),
    @NamedQuery(name = "Entity.findByEmail", query = "SELECT e FROM Entity e WHERE e.email = :email"),
    @NamedQuery(name = "Entity.findByBrn", query = "SELECT e FROM Entity e WHERE e.entityPK.brn = :brn"),
    @NamedQuery(name = "Entity.findByCreditLimit", query = "SELECT e FROM Entity e WHERE e.creditLimit = :creditLimit"),
    @NamedQuery(name = "Entity.findByAddress", query = "SELECT e FROM Entity e WHERE e.address = :address"),
    @NamedQuery(name = "Entity.findByDatetime", query = "SELECT e FROM Entity e WHERE e.datetime = :datetime"),
    @NamedQuery(name = "Entity.findByPrefix", query = "SELECT e FROM Entity e WHERE e.prefix = :prefix")})
public class Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntityPK entityPK;
    @Column(name = "titile")
    private String titile;
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "land_line")
    private String landLine;
    @Column(name = "email")
    private String email;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "credit_limit")
    private Double creditLimit;
    @Column(name = "address")
    private String address;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entity")
    private List<SupplierProduct> supplierProductList;
    @OneToMany(mappedBy = "supplier")
    private List<GrnReturn> grnReturnList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entity1")
    private List<CreditNote> creditNoteList;
    @OneToMany(mappedBy = "supplier")
    private List<Grn> grnList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entity")
    private List<Jobs> jobsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entity")
    private List<Sample> sampleList;
    @OneToMany(mappedBy = "entity")
    private List<Cheques> chequesList;
    @OneToMany(mappedBy = "entity")
    private List<Accounts> accountsList;
    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoiceList;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne
    private Branch orgBranch;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public Entity() {
    }

    public Entity(EntityPK entityPK) {
        this.entityPK = entityPK;
    }

    public Entity(String id, int entityType, String brn) {
        this.entityPK = new EntityPK(id, entityType, brn);
    }

    public EntityPK getEntityPK() {
        return entityPK;
    }

    public void setEntityPK(EntityPK entityPK) {
        this.entityPK = entityPK;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @XmlTransient
    public List<SupplierProduct> getSupplierProductList() {
        return supplierProductList;
    }

    public void setSupplierProductList(List<SupplierProduct> supplierProductList) {
        this.supplierProductList = supplierProductList;
    }

    @XmlTransient
    public List<GrnReturn> getGrnReturnList() {
        return grnReturnList;
    }

    public void setGrnReturnList(List<GrnReturn> grnReturnList) {
        this.grnReturnList = grnReturnList;
    }

    @XmlTransient
    public List<CreditNote> getCreditNoteList() {
        return creditNoteList;
    }

    public void setCreditNoteList(List<CreditNote> creditNoteList) {
        this.creditNoteList = creditNoteList;
    }

    @XmlTransient
    public List<Grn> getGrnList() {
        return grnList;
    }

    public void setGrnList(List<Grn> grnList) {
        this.grnList = grnList;
    }

    @XmlTransient
    public List<Jobs> getJobsList() {
        return jobsList;
    }

    public void setJobsList(List<Jobs> jobsList) {
        this.jobsList = jobsList;
    }

    @XmlTransient
    public List<Sample> getSampleList() {
        return sampleList;
    }

    public void setSampleList(List<Sample> sampleList) {
        this.sampleList = sampleList;
    }

    @XmlTransient
    public List<Cheques> getChequesList() {
        return chequesList;
    }

    public void setChequesList(List<Cheques> chequesList) {
        this.chequesList = chequesList;
    }

    @XmlTransient
    public List<Accounts> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Accounts> accountsList) {
        this.accountsList = accountsList;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
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
        hash += (entityPK != null ? entityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entity)) {
            return false;
        }
        Entity other = (Entity) object;
        if ((this.entityPK == null && other.entityPK != null) || (this.entityPK != null && !this.entityPK.equals(other.entityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Entity[ entityPK=" + entityPK + " ]";
    }
    
}
