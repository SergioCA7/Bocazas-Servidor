/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inftel10
 */
@Entity
@Table(name = "ICONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Icons.findAll", query = "SELECT i FROM Icons i")
    , @NamedQuery(name = "Icons.findByIdIcon", query = "SELECT i FROM Icons i WHERE i.idIcon = :idIcon")
    , @NamedQuery(name = "Icons.findByUrlIcon", query = "SELECT i FROM Icons i WHERE i.urlIcon = :urlIcon")})
public class Icons implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ICON")
    private BigDecimal idIcon;
    @Column(name = "URL_ICON")
    private BigInteger urlIcon;

    public Icons() {
    }

    public Icons(BigDecimal idIcon) {
        this.idIcon = idIcon;
    }

    public BigDecimal getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(BigDecimal idIcon) {
        this.idIcon = idIcon;
    }

    public BigInteger getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(BigInteger urlIcon) {
        this.urlIcon = urlIcon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIcon != null ? idIcon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Icons)) {
            return false;
        }
        Icons other = (Icons) object;
        if ((this.idIcon == null && other.idIcon != null) || (this.idIcon != null && !this.idIcon.equals(other.idIcon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Icons[ idIcon=" + idIcon + " ]";
    }
    
}
