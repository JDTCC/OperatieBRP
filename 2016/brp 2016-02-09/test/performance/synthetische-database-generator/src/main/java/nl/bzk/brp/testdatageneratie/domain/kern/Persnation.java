/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated Jul 24, 2014 5:36:58 PM by Hibernate Tools 3.2.4.GA



/**
 * Persnation generated by hbm2java
 */
public class Persnation  implements IntegerAsPrimaryKey,java.io.Serializable {


     private int id;
     private int pers;
     private int nation;
     private Short rdnverk;
     private Short rdnverlies;

    public Persnation() {
    }

	
    public Persnation(int id, int pers, int nation) {
        this.id = id;
        this.pers = pers;
        this.nation = nation;
    }
    public Persnation(int id, int pers, int nation, Short rdnverk, Short rdnverlies) {
       this.id = id;
       this.pers = pers;
       this.nation = nation;
       this.rdnverk = rdnverk;
       this.rdnverlies = rdnverlies;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getPers() {
        return this.pers;
    }
    
    public void setPers(int pers) {
        this.pers = pers;
    }
    public int getNation() {
        return this.nation;
    }
    
    public void setNation(int nation) {
        this.nation = nation;
    }
    public Short getRdnverk() {
        return this.rdnverk;
    }
    
    public void setRdnverk(Short rdnverk) {
        this.rdnverk = rdnverk;
    }
    public Short getRdnverlies() {
        return this.rdnverlies;
    }
    
    public void setRdnverlies(Short rdnverlies) {
        this.rdnverlies = rdnverlies;
    }




}


