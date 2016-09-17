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
import javax.persistence.Entity;
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
@Table(name = "sample")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sample.findAll", query = "SELECT s FROM Sample s"),
    @NamedQuery(name = "Sample.findById", query = "SELECT s FROM Sample s WHERE s.samplePK.id = :id"),
    @NamedQuery(name = "Sample.findByCustomer", query = "SELECT s FROM Sample s WHERE s.samplePK.customer = :customer"),
    @NamedQuery(name = "Sample.findByDatetime", query = "SELECT s FROM Sample s WHERE s.datetime = :datetime"),
    @NamedQuery(name = "Sample.findByPrefix", query = "SELECT s FROM Sample s WHERE s.prefix = :prefix")})
public class Sample implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SamplePK samplePK;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sample1")
    private List<SampleLines> sampleLinesList;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private ApplicationConstants status;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne
    private Branch orgBranch;
    @JoinColumn(name = "customer", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private com.cs.dao.Entity entity;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public Sample() {
    }

    public Sample(SamplePK samplePK) {
        this.samplePK = samplePK;
    }

    public Sample(String id, String customer) {
        this.samplePK = new SamplePK(id, customer);
    }

    public SamplePK getSamplePK() {
        return samplePK;
    }

    public void setSamplePK(SamplePK samplePK) {
        this.samplePK = samplePK;
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
    public List<SampleLines> getSampleLinesList() {
        return sampleLinesList;
    }

    public void setSampleLinesList(List<SampleLines> sampleLinesList) {
        this.sampleLinesList = sampleLinesList;
    }

    public ApplicationConstants getStatus() {
        return status;
    }

    public void setStatus(ApplicationConstants status) {
        this.status = status;
    }

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
    }

    public com.cs.dao.Entity getEntity() {
        return entity;
    }

    public void setEntity(com.cs.dao.Entity entity) {
        this.entity = entity;
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
        hash += (samplePK != null ? samplePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sample)) {
            return false;
        }
        Sample other = (Sample) object;
        if ((this.samplePK == null && other.samplePK != null) || (this.samplePK != null && !this.samplePK.equals(other.samplePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Sample[ samplePK=" + samplePK + " ]";
    }
    
}
