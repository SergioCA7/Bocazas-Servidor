/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author inftel10
 */
public class AlertAngular {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALERT")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="alert_sequence")
    private BigDecimal idAlert;
    @Size(max = 255)
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "VERIFICATIONS")
    private BigInteger verifications;
    @Column(name = "ALERT_TIME")
    private BigInteger alertTime;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "LATITUDE_COORDINATE")
    private BigInteger latitudeCoordinate;
    @Column(name = "LONGITUDE_COORDINATE")
    private BigInteger longitudeCoordinate;
    @JoinColumn(name = "ID_ICON", referencedColumnName = "ID_ICON")
    @Column(name = "ID_ICON")
    private  BigInteger idIcon;

    public AlertAngular() {
    }

    public AlertAngular(BigDecimal idAlert) {
        this.idAlert = idAlert;
    }

    public BigDecimal getIdAlert() {
        return idAlert;
    }

    public void setIdAlert(BigDecimal idAlert) {
        this.idAlert = idAlert;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigInteger getVerifications() {
        return verifications;
    }

    public void setVerifications(BigInteger verifications) {
        this.verifications = verifications;
    }

    public BigInteger getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(BigInteger alertTime) {
        this.alertTime = alertTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getLatitudeCoordinate() {
        return latitudeCoordinate;
    }

    public void setLatitudeCoordinate(BigInteger latitudeCoordinate) {
        this.latitudeCoordinate = latitudeCoordinate;
    }

    public BigInteger getLongitudeCoordinate() {
        return longitudeCoordinate;
    }

    public void setLongitudeCoordinate(BigInteger longitudeCoordinate) {
        this.longitudeCoordinate = longitudeCoordinate;
    }

    public BigInteger getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(BigInteger idIcon) {
        this.idIcon = idIcon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlert != null ? idAlert.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerts)) {
            return false;
        }
        AlertAngular other = (AlertAngular) object;
        if ((this.idAlert == null && other.idAlert != null) || (this.idAlert != null && !this.idAlert.equals(other.idAlert))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Alerts[ idAlert=" + idAlert + " ]";
    }
}
