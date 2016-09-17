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
@Table(name = "jobs_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobsLines.findAll", query = "SELECT j FROM JobsLines j"),
    @NamedQuery(name = "JobsLines.findById", query = "SELECT j FROM JobsLines j WHERE j.jobsLinesPK.id = :id"),
    @NamedQuery(name = "JobsLines.findByJob", query = "SELECT j FROM JobsLines j WHERE j.jobsLinesPK.job = :job"),
    @NamedQuery(name = "JobsLines.findByProduct", query = "SELECT j FROM JobsLines j WHERE j.jobsLinesPK.product = :product"),
    @NamedQuery(name = "JobsLines.findBySerial", query = "SELECT j FROM JobsLines j WHERE j.jobsLinesPK.serial = :serial"),
    @NamedQuery(name = "JobsLines.findByOurItem", query = "SELECT j FROM JobsLines j WHERE j.ourItem = :ourItem"),
    @NamedQuery(name = "JobsLines.findByItemBill", query = "SELECT j FROM JobsLines j WHERE j.itemBill = :itemBill"),
    @NamedQuery(name = "JobsLines.findByIswarranty", query = "SELECT j FROM JobsLines j WHERE j.iswarranty = :iswarranty"),
    @NamedQuery(name = "JobsLines.findByIsNew", query = "SELECT j FROM JobsLines j WHERE j.isNew = :isNew"),
    @NamedQuery(name = "JobsLines.findByDatetime", query = "SELECT j FROM JobsLines j WHERE j.datetime = :datetime"),
    @NamedQuery(name = "JobsLines.findByPrefix", query = "SELECT j FROM JobsLines j WHERE j.prefix = :prefix")})
public class JobsLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobsLinesPK jobsLinesPK;
    @Column(name = "our_item")
    private Boolean ourItem;
    @Column(name = "item_bill")
    private Integer itemBill;
    @Column(name = "iswarranty")
    private Boolean iswarranty;
    @Column(name = "isNew")
    private Boolean isNew;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @JoinColumn(name = "job", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jobs jobs;
    @JoinColumn(name = "product", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product1;
    @JoinColumn(name = "serial", referencedColumnName = "serial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrnLines grnLines;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public JobsLines() {
    }

    public JobsLines(JobsLinesPK jobsLinesPK) {
        this.jobsLinesPK = jobsLinesPK;
    }

    public JobsLines(String id, String job, String product, String serial) {
        this.jobsLinesPK = new JobsLinesPK(id, job, product, serial);
    }

    public JobsLinesPK getJobsLinesPK() {
        return jobsLinesPK;
    }

    public void setJobsLinesPK(JobsLinesPK jobsLinesPK) {
        this.jobsLinesPK = jobsLinesPK;
    }

    public Boolean getOurItem() {
        return ourItem;
    }

    public void setOurItem(Boolean ourItem) {
        this.ourItem = ourItem;
    }

    public Integer getItemBill() {
        return itemBill;
    }

    public void setItemBill(Integer itemBill) {
        this.itemBill = itemBill;
    }

    public Boolean getIswarranty() {
        return iswarranty;
    }

    public void setIswarranty(Boolean iswarranty) {
        this.iswarranty = iswarranty;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
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

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
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
        hash += (jobsLinesPK != null ? jobsLinesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobsLines)) {
            return false;
        }
        JobsLines other = (JobsLines) object;
        if ((this.jobsLinesPK == null && other.jobsLinesPK != null) || (this.jobsLinesPK != null && !this.jobsLinesPK.equals(other.jobsLinesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.JobsLines[ jobsLinesPK=" + jobsLinesPK + " ]";
    }
    
}
