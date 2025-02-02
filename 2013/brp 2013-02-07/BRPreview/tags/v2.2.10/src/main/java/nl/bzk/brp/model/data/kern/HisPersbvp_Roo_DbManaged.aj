// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import nl.bzk.brp.model.data.kern.Actie;
import nl.bzk.brp.model.data.kern.Bvp;
import nl.bzk.brp.model.data.kern.HisPersbvp;
import nl.bzk.brp.model.data.kern.Pers;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect HisPersbvp_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "actieverval", referencedColumnName = "id")
    private Actie HisPersbvp.actieverval;
    
    @ManyToOne
    @JoinColumn(name = "actieinh", referencedColumnName = "id")
    private Actie HisPersbvp.actieinh;
    
    @ManyToOne
    @JoinColumn(name = "bvp", referencedColumnName = "id")
    private Bvp HisPersbvp.bvp;
    
    @ManyToOne
    @JoinColumn(name = "pers", referencedColumnName = "id")
    private Pers HisPersbvp.pers;
    
    @Column(name = "tsreg", columnDefinition = "timestamp", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisPersbvp.tsreg;
    
    @Column(name = "tsverval", columnDefinition = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisPersbvp.tsverval;
    
    public Actie HisPersbvp.getActieverval() {
        return actieverval;
    }
    
    public void HisPersbvp.setActieverval(Actie actieverval) {
        this.actieverval = actieverval;
    }
    
    public Actie HisPersbvp.getActieinh() {
        return actieinh;
    }
    
    public void HisPersbvp.setActieinh(Actie actieinh) {
        this.actieinh = actieinh;
    }
    
    public Bvp HisPersbvp.getBvp() {
        return bvp;
    }
    
    public void HisPersbvp.setBvp(Bvp bvp) {
        this.bvp = bvp;
    }
    
    public Pers HisPersbvp.getPers() {
        return pers;
    }
    
    public void HisPersbvp.setPers(Pers pers) {
        this.pers = pers;
    }
    
    public Date HisPersbvp.getTsreg() {
        return tsreg;
    }
    
    public void HisPersbvp.setTsreg(Date tsreg) {
        this.tsreg = tsreg;
    }
    
    public Date HisPersbvp.getTsverval() {
        return tsverval;
    }
    
    public void HisPersbvp.setTsverval(Date tsverval) {
        this.tsverval = tsverval;
    }
    
}
