/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author home
 */
@Entity
@Table(name = "application_constants")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationConstants.findAll", query = "SELECT a FROM ApplicationConstants a"),
    @NamedQuery(name = "ApplicationConstants.findById", query = "SELECT a FROM ApplicationConstants a WHERE a.id = :id"),
    @NamedQuery(name = "ApplicationConstants.findByFieldName", query = "SELECT a FROM ApplicationConstants a WHERE a.fieldName = :fieldName"),
    @NamedQuery(name = "ApplicationConstants.findByValue", query = "SELECT a FROM ApplicationConstants a WHERE a.value = :value"),
    @NamedQuery(name = "ApplicationConstants.findByText", query = "SELECT a FROM ApplicationConstants a WHERE a.text = :text")})
public class ApplicationConstants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "field_name")
    private String fieldName;
    @Column(name = "value")
    private Integer value;
    @Column(name = "text")
    private String text;
    @OneToMany(mappedBy = "creditNoteStatus", fetch = FetchType.LAZY)
    private List<CreditNote> creditNoteList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<SampleLines> sampleLinesList;
    @OneToMany(mappedBy = "jobStatus", fetch = FetchType.LAZY)
    private List<Jobs> jobsList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Sample> sampleList;
    @OneToMany(mappedBy = "statusCode", fetch = FetchType.LAZY)
    private List<Cheques> chequesList;
    @OneToMany(mappedBy = "paymentMethod", fetch = FetchType.LAZY)
    private List<Invoice> invoiceList;
    @OneToMany(mappedBy = "invoiceStatus", fetch = FetchType.LAZY)
    private List<Invoice> invoiceList1;

    public ApplicationConstants() {
    }

    public ApplicationConstants(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlTransient
    public List<CreditNote> getCreditNoteList() {
        return creditNoteList;
    }

    public void setCreditNoteList(List<CreditNote> creditNoteList) {
        this.creditNoteList = creditNoteList;
    }

    @XmlTransient
    public List<SampleLines> getSampleLinesList() {
        return sampleLinesList;
    }

    public void setSampleLinesList(List<SampleLines> sampleLinesList) {
        this.sampleLinesList = sampleLinesList;
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
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList1() {
        return invoiceList1;
    }

    public void setInvoiceList1(List<Invoice> invoiceList1) {
        this.invoiceList1 = invoiceList1;
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
        if (!(object instanceof ApplicationConstants)) {
            return false;
        }
        ApplicationConstants other = (ApplicationConstants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return text;
    }
    
}
