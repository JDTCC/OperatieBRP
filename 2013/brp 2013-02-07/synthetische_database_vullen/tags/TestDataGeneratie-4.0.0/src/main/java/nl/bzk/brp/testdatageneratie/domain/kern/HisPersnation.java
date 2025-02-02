/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 5-feb-2013 16:30:05 by Hibernate Tools 3.2.4.GA


import java.util.Date;

/**
 * HisPersnation generated by hbm2java
 */
public class HisPersnation extends HisMaterieel {


     private Integer id;
     private Rdnverliesnlnation rdnverliesnlnation;
     private Persnation persnation;
     private Rdnverknlnation rdnverknlnation;
     private Integer dataanvgel;
     private Integer dateindegel;
     private Date tsreg;
     private Date tsverval;
     private Long actieinh;
     private Long actieverval;
     private Long actieaanpgel;

    public HisPersnation() {
    }

    public HisPersnation(Rdnverliesnlnation rdnverliesnlnation, Persnation persnation, Rdnverknlnation rdnverknlnation, Integer dataanvgel, Integer dateindegel, Date tsreg, Date tsverval, Long actieinh, Long actieverval, Long actieaanpgel) {
       this.rdnverliesnlnation = rdnverliesnlnation;
       this.persnation = persnation;
       this.rdnverknlnation = rdnverknlnation;
       this.dataanvgel = dataanvgel;
       this.dateindegel = dateindegel;
       this.tsreg = tsreg;
       this.tsverval = tsverval;
       this.actieinh = actieinh;
       this.actieverval = actieverval;
       this.actieaanpgel = actieaanpgel;
    }

    public Rdnverliesnlnation getRdnverliesnlnation() {
        return this.rdnverliesnlnation;
    }

    public void setRdnverliesnlnation(Rdnverliesnlnation rdnverliesnlnation) {
        this.rdnverliesnlnation = rdnverliesnlnation;
    }
    public Persnation getPersnation() {
        return this.persnation;
    }

    public void setPersnation(Persnation persnation) {
        this.persnation = persnation;
    }
    public Rdnverknlnation getRdnverknlnation() {
        return this.rdnverknlnation;
    }

    public void setRdnverknlnation(Rdnverknlnation rdnverknlnation) {
        this.rdnverknlnation = rdnverknlnation;
    }
    public Long getActieaanpgel() {
        return this.actieaanpgel;
    }

    public void setActieaanpgel(Long actieaanpgel) {
        this.actieaanpgel = actieaanpgel;
    }




}


