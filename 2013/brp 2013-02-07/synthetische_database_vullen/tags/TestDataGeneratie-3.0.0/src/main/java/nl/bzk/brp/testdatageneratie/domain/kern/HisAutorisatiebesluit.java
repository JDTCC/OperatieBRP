/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 21-dec-2012 11:50:17 by Hibernate Tools 3.2.4.GA



/**
 * HisAutorisatiebesluit generated by hbm2java
 */
public class HisAutorisatiebesluit extends His{

     private Autorisatiebesluit autorisatiebesluit;
     private boolean indingetrokken;
     private int datbesluit;
     private int datingang;
     private Integer dateinde;

    public HisAutorisatiebesluit() {
    }

    public HisAutorisatiebesluit(boolean indingetrokken, int datbesluit, int datingang) {
        this.indingetrokken = indingetrokken;
        this.datbesluit = datbesluit;
        this.datingang = datingang;
    }

    public Autorisatiebesluit getAutorisatiebesluit() {
        return this.autorisatiebesluit;
    }

    public void setAutorisatiebesluit(Autorisatiebesluit autorisatiebesluit) {
        this.autorisatiebesluit = autorisatiebesluit;
    }

    public boolean isIndingetrokken() {
        return this.indingetrokken;
    }

    public void setIndingetrokken(boolean indingetrokken) {
        this.indingetrokken = indingetrokken;
    }
    public int getDatbesluit() {
        return this.datbesluit;
    }

    public void setDatbesluit(int datbesluit) {
        this.datbesluit = datbesluit;
    }
    public int getDatingang() {
        return this.datingang;
    }

    public void setDatingang(int datingang) {
        this.datingang = datingang;
    }
    public Integer getDateinde() {
        return this.dateinde;
    }

    public void setDateinde(Integer dateinde) {
        this.dateinde = dateinde;
    }




}


