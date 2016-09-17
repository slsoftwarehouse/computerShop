/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "credit_note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditNote.findAll", query = "SELECT c FROM CreditNote c"),
    @NamedQuery(name = "CreditNote.findById", query = "SELECT c FROM CreditNote c WHERE c.creditNotePK.id = :id"),
    @NamedQuery(name = "CreditNote.findByEntity", query = "SELECT c FROM CreditNote c WHERE c.creditNotePK.entity = :entity"),
    @NamedQuery(name = "CreditNote.findByEntityType", query = "SELECT c FROM CreditNote c WHERE c.creditNotePK.entityType = :entityType"),
    @NamedQuery(name = "CreditNote.findByEntityReferance", query = "SELECT c FROM CreditNote c WHERE c.creditNotePK.entityReferance = :entityReferance"),
    @NamedQuery(name = "CreditNote.findByTotal", query = "SELECT c FROM CreditNote c WHERE c.total = :total"),
    @NamedQuery(name = "CreditNote.findByDatetime", query = "SELECT c FROM CreditNote c WHERE c.datetime = :datetime"),
    @NamedQuery(name = "CreditNote.findByPrefix", query = "SELECT c FROM CreditNote c WHERE c.prefix = :prefix")})
public class CreditNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CreditNotePK creditNotePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @OneToMany(mappedBy = "creditNote")
    private List<GrnReturn> grnReturnList;
    @JoinColumn(name = "entity", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private com.cs.dao.Entity entity1;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne
    private Branch orgBranch;
    @JoinColumn(name = "credit_note_status", referencedColumnName = "id")
    @ManyToOne
    private ApplicationConstants creditNoteStatus;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;
    @OneToMany(mappedBy = "creditNote")
    private List<Grn> grnList;

    public CreditNote() {
    }

    public CreditNote(CreditNotePK creditNotePK) {
        this.creditNotePK = creditNotePK;
    }

    public CreditNote(String id, String entity, int entityType, String entityReferance) {
        this.creditNotePK = new CreditNotePK(id, entity, entityType, entityReferance);
    }

    public CreditNotePK getCreditNotePK() {
        return creditNotePK;
    }

    public void setCreditNotePK(CreditNotePK creditNotePK) {
        this.creditNotePK = creditNotePK;
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

    public com.cs.dao.Entity getEntity1() {
        return entity1;
    }

    public void setEntity1(com.cs.dao.Entity entity1) {
        this.entity1 = entity1;
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
        hash += (creditNotePK != null ? creditNotePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditNote)) {
            return false;
        }
        CreditNote other = (CreditNote) object;
        if ((this.creditNotePK == null && other.creditNotePK != null) || (this.creditNotePK != null && !this.creditNotePK.equals(other.creditNotePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.CreditNote[ creditNotePK=" + creditNotePK + " ]";
    }
    
}
