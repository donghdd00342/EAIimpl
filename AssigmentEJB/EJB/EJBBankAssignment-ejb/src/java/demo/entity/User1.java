/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USER1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User1.findAll", query = "SELECT u FROM User1 u")
    , @NamedQuery(name = "User1.findByCodegd", query = "SELECT u FROM User1 u WHERE u.codegd = :codegd")
    , @NamedQuery(name = "User1.findByPassgd", query = "SELECT u FROM User1 u WHERE u.passgd = :passgd")
    , @NamedQuery(name = "User1.findByCodeuser", query = "SELECT u FROM User1 u WHERE u.codeuser = :codeuser")
    , @NamedQuery(name = "User1.findByCodepin", query = "SELECT u FROM User1 u WHERE u.codepin = :codepin")
    , @NamedQuery(name = "User1.findByMoneyuser", query = "SELECT u FROM User1 u WHERE u.moneyuser = :moneyuser"),
})
public class User1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODEGD")
    private Integer codegd;
    @Column(name = "PASSGD")
    private Integer passgd;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEUSER")
    private Integer codeuser;
    @Column(name = "CODEPIN")
    private Integer codepin;
    @Column(name = "MONEYUSER")
    private Integer moneyuser;

    public User1() {
    }

    public User1(Integer codeuser) {
        this.codeuser = codeuser;
    }

    public Integer getCodegd() {
        return codegd;
    }

    public void setCodegd(Integer codegd) {
        this.codegd = codegd;
    }

    public Integer getPassgd() {
        return passgd;
    }

    public void setPassgd(Integer passgd) {
        this.passgd = passgd;
    }

    public Integer getCodeuser() {
        return codeuser;
    }

    public void setCodeuser(Integer codeuser) {
        this.codeuser = codeuser;
    }

    public Integer getCodepin() {
        return codepin;
    }

    public void setCodepin(Integer codepin) {
        this.codepin = codepin;
    }

    public Integer getMoneyuser() {
        return moneyuser;
    }

    public void setMoneyuser(Integer moneyuser) {
        this.moneyuser = moneyuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeuser != null ? codeuser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User1)) {
            return false;
        }
        User1 other = (User1) object;
        if ((this.codeuser == null && other.codeuser != null) || (this.codeuser != null && !this.codeuser.equals(other.codeuser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.entity.User1[ codeuser=" + codeuser + " ]";
    }
    
}
