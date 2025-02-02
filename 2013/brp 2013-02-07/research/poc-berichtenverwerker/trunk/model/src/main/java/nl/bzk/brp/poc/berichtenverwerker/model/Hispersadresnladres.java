/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.poc.berichtenverwerker.model;

// Generated 10-aug-2011 15:03:15 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


/**
 * Hispersadresnladres generated by hbm2java
 */
@Entity
@Table(name = "hispersadresnladres", schema = "kern",
       uniqueConstraints = @UniqueConstraint(columnNames = { "persadres", "dataanvgel", "dattijdverval" }))
public class Hispersadresnladres implements java.io.Serializable {

    private long       id;
    private Actie      actieByActieeinde;
    private Gem        gem;
    private Plaats     plaats;
    private Persadres  persadres;
    private Actie      actieByActiebegin;
    private BigDecimal dataanvgel;
    private BigDecimal dateindegel;
    private Date       dattijdreg;
    private Date       dattijdverval;
    private String     adresseerbaarobject;
    private String     identcodenraand;
    private String     nor;
    private String     afgekortenor;
    private String     gemdeel;
    private BigDecimal huisnr;
    private String     huisletter;
    private String     huisnrtoevoeging;
    private String     postcode;
    private String     loctovadres;
    private String     locoms;
    private Integer    actiebeingeld;

    public Hispersadresnladres() {
    }

    public Hispersadresnladres(long id, Gem gem) {
        this.id = id;
        this.gem = gem;
    }

    public Hispersadresnladres(long id, Actie actieByActieeinde, Gem gem, Plaats plaats, Persadres persadres,
            Actie actieByActiebegin, BigDecimal dataanvgel, BigDecimal dateindegel, Date dattijdreg,
            Date dattijdverval, String adresseerbaarobject, String identcodenraand, String nor, String afgekortenor,
            String gemdeel, BigDecimal huisnr, String huisletter, String huisnrtoevoeging, String postcode,
            String loctovadres, String locoms, Integer actiebeingeld) {
        this.id = id;
        this.actieByActieeinde = actieByActieeinde;
        this.gem = gem;
        this.plaats = plaats;
        this.persadres = persadres;
        this.actieByActiebegin = actieByActiebegin;
        this.dataanvgel = dataanvgel;
        this.dateindegel = dateindegel;
        this.dattijdreg = dattijdreg;
        this.dattijdverval = dattijdverval;
        this.adresseerbaarobject = adresseerbaarobject;
        this.identcodenraand = identcodenraand;
        this.nor = nor;
        this.afgekortenor = afgekortenor;
        this.gemdeel = gemdeel;
        this.huisnr = huisnr;
        this.huisletter = huisletter;
        this.huisnrtoevoeging = huisnrtoevoeging;
        this.postcode = postcode;
        this.loctovadres = loctovadres;
        this.locoms = locoms;
        this.actiebeingeld = actiebeingeld;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actieeinde")
    public Actie getActieByActieeinde() {
        return this.actieByActieeinde;
    }

    public void setActieByActieeinde(Actie actieByActieeinde) {
        this.actieByActieeinde = actieByActieeinde;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gem", nullable = false)
    public Gem getGem() {
        return this.gem;
    }

    public void setGem(Gem gem) {
        this.gem = gem;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wpl")
    public Plaats getPlaats() {
        return this.plaats;
    }

    public void setPlaats(Plaats plaats) {
        this.plaats = plaats;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persadres")
    public Persadres getPersadres() {
        return this.persadres;
    }

    public void setPersadres(Persadres persadres) {
        this.persadres = persadres;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actiebegin")
    public Actie getActieByActiebegin() {
        return this.actieByActiebegin;
    }

    public void setActieByActiebegin(Actie actieByActiebegin) {
        this.actieByActiebegin = actieByActiebegin;
    }

    @Column(name = "dataanvgel", precision = 8)
    public BigDecimal getDataanvgel() {
        return this.dataanvgel;
    }

    public void setDataanvgel(BigDecimal dataanvgel) {
        this.dataanvgel = dataanvgel;
    }

    @Column(name = "dateindegel", precision = 8)
    public BigDecimal getDateindegel() {
        return this.dateindegel;
    }

    public void setDateindegel(BigDecimal dateindegel) {
        this.dateindegel = dateindegel;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dattijdreg", length = 29)
    public Date getDattijdreg() {
        return this.dattijdreg;
    }

    public void setDattijdreg(Date dattijdreg) {
        this.dattijdreg = dattijdreg;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dattijdverval", length = 29)
    public Date getDattijdverval() {
        return this.dattijdverval;
    }

    public void setDattijdverval(Date dattijdverval) {
        this.dattijdverval = dattijdverval;
    }

    @Column(name = "adresseerbaarobject", length = 16)
    public String getAdresseerbaarobject() {
        return this.adresseerbaarobject;
    }

    public void setAdresseerbaarobject(String adresseerbaarobject) {
        this.adresseerbaarobject = adresseerbaarobject;
    }

    @Column(name = "identcodenraand", length = 16)
    public String getIdentcodenraand() {
        return this.identcodenraand;
    }

    public void setIdentcodenraand(String identcodenraand) {
        this.identcodenraand = identcodenraand;
    }

    @Column(name = "nor", length = 80)
    public String getNor() {
        return this.nor;
    }

    public void setNor(String nor) {
        this.nor = nor;
    }

    @Column(name = "afgekortenor", length = 24)
    public String getAfgekortenor() {
        return this.afgekortenor;
    }

    public void setAfgekortenor(String afgekortenor) {
        this.afgekortenor = afgekortenor;
    }

    @Column(name = "gemdeel", length = 24)
    public String getGemdeel() {
        return this.gemdeel;
    }

    public void setGemdeel(String gemdeel) {
        this.gemdeel = gemdeel;
    }

    @Column(name = "huisnr", precision = 5)
    public BigDecimal getHuisnr() {
        return this.huisnr;
    }

    public void setHuisnr(BigDecimal huisnr) {
        this.huisnr = huisnr;
    }

    @Column(name = "huisletter", length = 1)
    public String getHuisletter() {
        return this.huisletter;
    }

    public void setHuisletter(String huisletter) {
        this.huisletter = huisletter;
    }

    @Column(name = "huisnrtoevoeging", length = 4)
    public String getHuisnrtoevoeging() {
        return this.huisnrtoevoeging;
    }

    public void setHuisnrtoevoeging(String huisnrtoevoeging) {
        this.huisnrtoevoeging = huisnrtoevoeging;
    }

    @Column(name = "postcode", length = 6)
    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(name = "loctovadres", length = 2)
    public String getLoctovadres() {
        return this.loctovadres;
    }

    public void setLoctovadres(String loctovadres) {
        this.loctovadres = loctovadres;
    }

    @Column(name = "locoms", length = 80)
    public String getLocoms() {
        return this.locoms;
    }

    public void setLocoms(String locoms) {
        this.locoms = locoms;
    }

    @Column(name = "actiebeingeld")
    public Integer getActiebeingeld() {
        return this.actiebeingeld;
    }

    public void setActiebeingeld(Integer actiebeingeld) {
        this.actiebeingeld = actiebeingeld;
    }

}
