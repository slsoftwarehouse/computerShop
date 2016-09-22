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
@Table(name = "credit_note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditNote.findAll", query = "SELECT c FROM CreditNote c"),
    @NamedQuery(name = "CreditNote.findById", query = "SELECT c FROM CreditNote c WHERE c.id = :id"),
    @NamedQuery(name = "CreditNote.findByEntityType", query = "SELECT c FROM CreditNote c WHERE c.entityType = :entityType"),
    @NamedQuery(name = "CreditNote.findByEntityReferance", query = "SELECT c FROM CreditNote c WHERE c.entityReferance = :entityReferance"),
    @NamedQuery(name = "CreditNote.findByTotal", query = "SELECT c FROM CreditNote c WHERE c.total = :total"),
    @NamedQuery(name = "CreditNote.findByDatetime", query = "SELECT c FROM CreditNote c WHERE c.datetime = :datetime"),
    @NamedQuery(name = "CreditNote.findByPrefix", query = "SELECT c FROM CreditNote c WHERE c.prefix = :prefix")})
public class CreditNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "entity_type")
    private Integer entityType;
    @Column(name = "entity_referance")
    private String entityReferance;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @OneToMany(mappedBy = "creditNote", fetch = FetchType.LAZY)
    private List<GrnReturn> grnReturnList;
    @JoinColumn(name = "entity", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private com.cs.dao.Entity entity;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch orgBranch;
    @JoinColumn(name = "credit_note_status", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationConstants creditNoteStatus;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;
    @OneToMany(mappedBy = "creditNote", fetch = FetchType.LAZY)
    private List<Grn> grnList;

    public CreditNote() {
    }

    public CreditNote(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getEntityType() {
        return entityType;
    }

    public void setEntityType(Integer entityType) {
        this.entityType = entityType;
    }

    public String getEntityReferance() {
        return entityReferance;
    }

    public void setEntityReferance(String entityReferance) {
        this.entityReferance = entityReferance;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
    public List<GrnReturn> getGrnReturnList() {
        return grnReturnList;
    }

    public void setGrnReturnList(List<GrnReturn> grnReturnList) {
        this.grnReturnList = grnReturnList;
    }

    public com.cs.dao.Entity getEntity() {
        return entity;
    }

    public void setEntity(com.cs.dao.Entity entity) {
        this.entity = entity;
    }

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
    }

    public ApplicationConstants getCreditNoteStatus() {
        return creditNoteStatus;
    }

    public void setCreditNoteStatus(ApplicationConstants creditNoteStatus) {
        this.creditNoteStatus = creditNoteStatus;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @XmlTransient
    public List<Grn> getGrnList() {
        return grnList;
    }

    public void setGrnList(List<Grn> grnList) {
        this.grnList = grnList;
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
        if (!(object instanceof CreditNote)) {
            return false;
        }
        CreditNote other = (CreditNote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "com.cs.dao.CreditNote[ id=" + id + " ]";
        return id;
    }
    
}
