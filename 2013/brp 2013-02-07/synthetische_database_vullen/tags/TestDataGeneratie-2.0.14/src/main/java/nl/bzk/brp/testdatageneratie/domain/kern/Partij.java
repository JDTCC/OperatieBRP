/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 21-dec-2012 11:50:17 by Hibernate Tools 3.2.4.GA


import nl.bzk.brp.testdatageneratie.dataaccess.Cacheable;

/**
 * Partij generated by hbm2java
 */
public class Partij  implements Cacheable<Short> {


     private Short id;
     private Sector sector;
     private Srtpartij srtpartij;
     private Partij partijByVoortzettendegem;
     private Partij partijByOnderdeelvan;
     private String naam;
     private Short code;
     private Integer dateinde;
     private Integer dataanv;
     private String partijstatushis = StatusHis.A.name();
     private String gemstatushis = StatusHis.A.name();

    public Partij() {
    }


    public Partij(String naam, String partijstatushis, String gemstatushis) {
        this.naam = naam;
        this.partijstatushis = partijstatushis;
        this.gemstatushis = gemstatushis;
    }
    public Partij(Sector sector, Srtpartij srtpartij, Partij partijByVoortzettendegem, Partij partijByOnderdeelvan, String naam, Short code, Integer dateinde, Integer dataanv, String partijstatushis, String gemstatushis) {
       this.sector = sector;
       this.srtpartij = srtpartij;
       this.partijByVoortzettendegem = partijByVoortzettendegem;
       this.partijByOnderdeelvan = partijByOnderdeelvan;
       this.naam = naam;
       this.code = code;
       this.dateinde = dateinde;
       this.dataanv = dataanv;
       this.partijstatushis = partijstatushis;
       this.gemstatushis = gemstatushis;
    }

    public Short getId() {
        return this.id;
    }

    public void setId(Short id) {
        this.id = id;
    }
    public Sector getSector() {
        return this.sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    public Srtpartij getSrtpartij() {
        return this.srtpartij;
    }

    public void setSrtpartij(Srtpartij srtpartij) {
        this.srtpartij = srtpartij;
    }
    public Partij getPartijByVoortzettendegem() {
        return this.partijByVoortzettendegem;
    }

    public void setPartijByVoortzettendegem(Partij partijByVoortzettendegem) {
        this.partijByVoortzettendegem = partijByVoortzettendegem;
    }
    public Partij getPartijByOnderdeelvan() {
        return this.partijByOnderdeelvan;
    }

    public void setPartijByOnderdeelvan(Partij partijByOnderdeelvan) {
        this.partijByOnderdeelvan = partijByOnderdeelvan;
    }
    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
    public Short getCode() {
        return this.code;
    }

    public void setCode(Short code) {
        this.code = code;
    }
    public Integer getDateinde() {
        return this.dateinde;
    }

    public void setDateinde(Integer dateinde) {
        this.dateinde = dateinde;
    }
    public Integer getDataanv() {
        return this.dataanv;
    }

    public void setDataanv(Integer dataanv) {
        this.dataanv = dataanv;
    }
    public String getPartijstatushis() {
        return this.partijstatushis;
    }

    public void setPartijstatushis(String partijstatushis) {
        this.partijstatushis = partijstatushis;
    }
    public String getGemstatushis() {
        return this.gemstatushis;
    }

    public void setGemstatushis(String gemstatushis) {
        this.gemstatushis = gemstatushis;
    }


    @Override
    public Short getKey() {
        return code;
    }

}


