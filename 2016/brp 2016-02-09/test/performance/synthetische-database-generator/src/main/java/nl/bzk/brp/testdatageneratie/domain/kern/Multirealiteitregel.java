/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated Jul 24, 2014 5:36:58 PM by Hibernate Tools 3.2.4.GA



/**
 * Multirealiteitregel generated by hbm2java
 */
public class Multirealiteitregel  implements java.io.Serializable {


     private int id;
     private int geldigvoor;
     private short srt;
     private Integer pers;
     private Integer multirealiteitpers;
     private Integer relatie;
     private Integer betr;

    public Multirealiteitregel() {
    }

	
    public Multirealiteitregel(int id, int geldigvoor, short srt) {
        this.id = id;
        this.geldigvoor = geldigvoor;
        this.srt = srt;
    }
    public Multirealiteitregel(int id, int geldigvoor, short srt, Integer pers, Integer multirealiteitpers, Integer relatie, Integer betr) {
       this.id = id;
       this.geldigvoor = geldigvoor;
       this.srt = srt;
       this.pers = pers;
       this.multirealiteitpers = multirealiteitpers;
       this.relatie = relatie;
       this.betr = betr;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getGeldigvoor() {
        return this.geldigvoor;
    }
    
    public void setGeldigvoor(int geldigvoor) {
        this.geldigvoor = geldigvoor;
    }
    public short getSrt() {
        return this.srt;
    }
    
    public void setSrt(short srt) {
        this.srt = srt;
    }
    public Integer getPers() {
        return this.pers;
    }
    
    public void setPers(Integer pers) {
        this.pers = pers;
    }
    public Integer getMultirealiteitpers() {
        return this.multirealiteitpers;
    }
    
    public void setMultirealiteitpers(Integer multirealiteitpers) {
        this.multirealiteitpers = multirealiteitpers;
    }
    public Integer getRelatie() {
        return this.relatie;
    }
    
    public void setRelatie(Integer relatie) {
        this.relatie = relatie;
    }
    public Integer getBetr() {
        return this.betr;
    }
    
    public void setBetr(Integer betr) {
        this.betr = betr;
    }




}


