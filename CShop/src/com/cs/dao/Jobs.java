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
@Table(name = "jobs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobs.findAll", query = "SELECT j FROM Jobs j"),
    @NamedQuery(name = "Jobs.findById", query = "SELECT j FROM Jobs j WHERE j.jobsPK.id = :id"),
    @NamedQuery(name = "Jobs.findByCustomer", query = "SELECT j FROM Jobs j WHERE j.jobsPK.customer = :customer"),
    @NamedQuery(name = "Jobs.findByDescription", query = "SELECT j FROM Jobs j WHERE j.description = :description"),
    @NamedQuery(name = "Jobs.findByServiceCharge", query = "SELECT j FROM Jobs j WHERE j.serviceCharge = :serviceCharge"),
    @NamedQuery(name = "Jobs.findByTotalItemBill", query = "SELECT j FROM Jobs j WHERE j.totalItemBill = :totalItemBill"),
    @NamedQuery(name = "Jobs.findByTotalBill", query = "SELECT j FROM Jobs j WHERE j.totalBill = :totalBill"),
    @NamedQuery(name = "Jobs.findByDisscount", query = "SELECT j FROM Jobs j WHERE j.disscount = :disscount"),
    @NamedQuery(name = "Jobs.findByDatetime", query = "SELECT j FROM Jobs j WHERE j.datetime = :datetime"),
    @NamedQuery(name = "Jobs.findByPrefix", query = "SELECT j FROM Jobs j WHERE j.prefix = :prefix")})
public class Jobs implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobsPK jobsPK;
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "service_charge")
    private Double serviceCharge;
    @Column(name = "total_item_bill")
    private Double totalItemBill;
    @Column(name = "total_bill")
    private Double totalBill;
    @Column(name = "disscount")
    private Double disscount;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobs")
    private List<JobsLines> jobsLinesList;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne
    private Branch orgBranch;
    @JoinColumn(name = "customer", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private com.cs.dao.Entity entity;
    @JoinColumn(name = "job_status", referencedColumnName = "id")
    @ManyToOne
    private ApplicationConstants jobStatus;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public Jobs() {
    }

    public Jobs(JobsPK jobsPK) {
        this.jobsPK = jobsPK;
    }

    public Jobs(String id, String customer) {
        this.jobsPK = new JobsPK(id, customer);
    }

    public JobsPK getJobsPK() {
        return jobsPK;
    }

    public void setJobsPK(JobsPK jobsPK) {
        this.jobsPK = jobsPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Double getTotalItemBill() {
        return totalItemBill;
    }

    public void setTotalItemBill(Double totalItemBill) {
        this.totalItemBill = totalItemBill;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }

    public Double getDisscount() {
        return disscount;
    }

    public void setDisscount(Double disscount) {
        this.disscount = disscount;
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
    public List<JobsLines> getJobsLinesList() {
        return jobsLinesList;
    }

    public void setJobsLinesList(List<JobsLines> jobsLinesList) {
        this.jobsLinesList = jobsLinesList;
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

    public ApplicationConstants getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(ApplicationConstants jobStatus) {
        this.jobStatus = jobStatus;
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
        hash += (jobsPK != null ? jobsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobs)) {
            return false;
        }
        Jobs other = (Jobs) object;
        if ((this.jobsPK == null && other.jobsPK != null) || (this.jobsPK != null && !this.jobsPK.equals(other.jobsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Jobs[ jobsPK=" + jobsPK + " ]";
    }
    
}
