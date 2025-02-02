/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 5-feb-2013 16:30:05 by Hibernate Tools 3.2.4.GA


import java.util.Date;

/**
 * HisPerspk generated by hbm2java
 */
public class HisPerspk extends His {


     private Integer id;
     private Partij partij;
     private Pers pers;
     private Date tsreg;
     private Date tsverval;
     private Long actieinh;
     private Long actieverval;
     private boolean indpkvollediggeconv;

    public HisPerspk() {
    }


    public HisPerspk(boolean indpkvollediggeconv) {
        this.indpkvollediggeconv = indpkvollediggeconv;
    }
    public HisPerspk(Partij partij, Pers pers, Date tsreg, Date tsverval, Long actieinh, Long actieverval, boolean indpkvollediggeconv) {
       this.partij = partij;
       this.pers = pers;
       this.tsreg = tsreg;
       this.tsverval = tsverval;
       this.actieinh = actieinh;
       this.actieverval = actieverval;
       this.indpkvollediggeconv = indpkvollediggeconv;
    }

    public Partij getPartij() {
        return this.partij;
    }

    public void setPartij(Partij partij) {
        this.partij = partij;
    }
    public Pers getPers() {
        return this.pers;
    }

    public void setPers(Pers pers) {
        this.pers = pers;
    }
    public boolean isIndpkvollediggeconv() {
        return this.indpkvollediggeconv;
    }

    public void setIndpkvollediggeconv(boolean indpkvollediggeconv) {
        this.indpkvollediggeconv = indpkvollediggeconv;
    }




}


