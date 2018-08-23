/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author quang
 */
@Entity
@Table(name = "ORDER1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o")
    , @NamedQuery(name = "Order1.findByCodeorder", query = "SELECT o FROM Order1 o WHERE o.codeorder = :codeorder")
    , @NamedQuery(name = "Order1.findByNameorder", query = "SELECT o FROM Order1 o WHERE o.nameorder = :nameorder")
    , @NamedQuery(name = "Order1.findByMoneyorder", query = "SELECT o FROM Order1 o WHERE o.moneyorder = :moneyorder")
    , @NamedQuery(name = "Order1.findByFeeorder", query = "SELECT o FROM Order1 o WHERE o.feeorder = :feeorder")
    , @NamedQuery(name = "Order1.findByCodecustomer", query = "SELECT o FROM Order1 o WHERE o.codecustomer = :codecustomer")
    , @NamedQuery(name = "Order1.findByCodeuser", query = "SELECT o FROM Order1 o WHERE o.codeuser = :codeuser")
    , @NamedQuery(name = "Order1.findByDateorder", query = "SELECT o FROM Order1 o WHERE o.dateorder = :dateorder")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEORDER")
    private Integer codeorder;
    @Size(max = 100)
    @Column(name = "NAMEORDER")
    private String nameorder;
    @Column(name = "MONEYORDER")
    private Integer moneyorder;
    @Column(name = "FEEORDER")
    private Integer feeorder;
    @Column(name = "CODECUSTOMER")
    private Integer codecustomer;
    @Column(name = "CODEUSER")
    private Integer codeuser;
    @Column(name = "DATEORDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateorder;

    public Order1() {
    }

    public Order1(Integer codeorder) {
        this.codeorder = codeorder;
    }

    public Integer getCodeorder() {
        return codeorder;
    }

    public void setCodeorder(Integer codeorder) {
        this.codeorder = codeorder;
    }

    public String getNameorder() {
        return nameorder;
    }

    public void setNameorder(String nameorder) {
        this.nameorder = nameorder;
    }

    public Integer getMoneyorder() {
        return moneyorder;
    }

    public void setMoneyorder(Integer moneyorder) {
        this.moneyorder = moneyorder;
    }

    public Integer getFeeorder() {
        return feeorder;
    }

    public void setFeeorder(Integer feeorder) {
        this.feeorder = feeorder;
    }

    public Integer getCodecustomer() {
        return codecustomer;
    }

    public void setCodecustomer(Integer codecustomer) {
        this.codecustomer = codecustomer;
    }

    public Integer getCodeuser() {
        return codeuser;
    }

    public void setCodeuser(Integer codeuser) {
        this.codeuser = codeuser;
    }

    public Date getDateorder() {
        return dateorder;
    }

    public void setDateorder(Date dateorder) {
        this.dateorder = dateorder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeorder != null ? codeorder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.codeorder == null && other.codeorder != null) || (this.codeorder != null && !this.codeorder.equals(other.codeorder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.entities.Order1[ codeorder=" + codeorder + " ]";
    }
    
}
