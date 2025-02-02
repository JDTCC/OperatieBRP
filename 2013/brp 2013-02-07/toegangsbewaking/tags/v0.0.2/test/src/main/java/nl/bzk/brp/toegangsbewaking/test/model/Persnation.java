/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.toegangsbewaking.test.model;

// Generated 23-sep-2011 15:40:39 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


/**
 * Persnation generated by hbm2java
 */
@Entity
@Table(name = "persnation", schema = "kern", uniqueConstraints = @UniqueConstraint(columnNames = { "pers", "nation" }))
public class Persnation implements java.io.Serializable {

    private long               id;
    private Nation             nation;
    private Pers               pers;
    private Rdnverliesnlnation rdnverliesnlnation;
    private Rdnverknlnation    rdnverknlnation;
    private Integer            dataanvgel;
    private Date               dattijdreg;
    private Set<Hispersnation> hispersnations = new HashSet<Hispersnation>(0);

    public Persnation() {
    }

    public Persnation(long id, Nation nation, Pers pers) {
        this.id = id;
        this.nation = nation;
        this.pers = pers;
    }

    public Persnation(long id, Nation nation, Pers pers, Rdnverliesnlnation rdnverliesnlnation,
            Rdnverknlnation rdnverknlnation, Integer dataanvgel, Date dattijdreg, Set<Hispersnation> hispersnations)
    {
        this.id = id;
        this.nation = nation;
        this.pers = pers;
        this.rdnverliesnlnation = rdnverliesnlnation;
        this.rdnverknlnation = rdnverknlnation;
        this.dataanvgel = dataanvgel;
        this.dattijdreg = dattijdreg;
        this.hispersnations = hispersnations;
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
    @JoinColumn(name = "nation", nullable = false)
    public Nation getNation() {
        return this.nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pers", nullable = false)
    public Pers getPers() {
        return this.pers;
    }

    public void setPers(Pers pers) {
        this.pers = pers;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rdnverlies")
    public Rdnverliesnlnation getRdnverliesnlnation() {
        return this.rdnverliesnlnation;
    }

    public void setRdnverliesnlnation(Rdnverliesnlnation rdnverliesnlnation) {
        this.rdnverliesnlnation = rdnverliesnlnation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rdnverk")
    public Rdnverknlnation getRdnverknlnation() {
        return this.rdnverknlnation;
    }

    public void setRdnverknlnation(Rdnverknlnation rdnverknlnation) {
        this.rdnverknlnation = rdnverknlnation;
    }

    @Column(name = "dataanvgel", precision = 8, scale = 0)
    public Integer getDataanvgel() {
        return this.dataanvgel;
    }

    public void setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dattijdreg", length = 29)
    public Date getDattijdreg() {
        return this.dattijdreg;
    }

    public void setDattijdreg(Date dattijdreg) {
        this.dattijdreg = dattijdreg;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persnation")
    public Set<Hispersnation> getHispersnations() {
        return this.hispersnations;
    }

    public void setHispersnations(Set<Hispersnation> hispersnations) {
        this.hispersnations = hispersnations;
    }

}
