// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.model.data.kern.Actie;
import nl.bzk.brp.model.data.kern.HisPersbijhgem;
import nl.bzk.brp.model.data.kern.Partij;
import nl.bzk.brp.model.data.kern.Pers;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect HisPersbijhgem_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "actieinh", referencedColumnName = "id")
    private Actie HisPersbijhgem.actieinh;
    
    @ManyToOne
    @JoinColumn(name = "actieverval", referencedColumnName = "id")
    private Actie HisPersbijhgem.actieverval;
    
    @ManyToOne
    @JoinColumn(name = "actieaanpgel", referencedColumnName = "id")
    private Actie HisPersbijhgem.actieaanpgel;
    
    @ManyToOne
    @JoinColumn(name = "bijhgem", referencedColumnName = "id", nullable = false)
    private Partij HisPersbijhgem.bijhgem;
    
    @ManyToOne
    @JoinColumn(name = "pers", referencedColumnName = "id")
    private Pers HisPersbijhgem.pers;
    
    @Column(name = "dataanvgel", columnDefinition = "int4", unique = true)
    private Integer HisPersbijhgem.dataanvgel;
    
    @Column(name = "dateindegel", columnDefinition = "int4")
    private Integer HisPersbijhgem.dateindegel;
    
    @Column(name = "tsreg", columnDefinition = "timestamp", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisPersbijhgem.tsreg;
    
    @Column(name = "tsverval", columnDefinition = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisPersbijhgem.tsverval;
    
    @Column(name = "datinschringem", columnDefinition = "int4")
    @NotNull
    private Integer HisPersbijhgem.datinschringem;
    
    @Column(name = "indonverwdocaanw", columnDefinition = "bool")
    @NotNull
    private boolean HisPersbijhgem.indonverwdocaanw;
    
    public Actie HisPersbijhgem.getActieinh() {
        return actieinh;
    }
    
    public void HisPersbijhgem.setActieinh(Actie actieinh) {
        this.actieinh = actieinh;
    }
    
    public Actie HisPersbijhgem.getActieverval() {
        return actieverval;
    }
    
    public void HisPersbijhgem.setActieverval(Actie actieverval) {
        this.actieverval = actieverval;
    }
    
    public Actie HisPersbijhgem.getActieaanpgel() {
        return actieaanpgel;
    }
    
    public void HisPersbijhgem.setActieaanpgel(Actie actieaanpgel) {
        this.actieaanpgel = actieaanpgel;
    }
    
    public Partij HisPersbijhgem.getBijhgem() {
        return bijhgem;
    }
    
    public void HisPersbijhgem.setBijhgem(Partij bijhgem) {
        this.bijhgem = bijhgem;
    }
    
    public Pers HisPersbijhgem.getPers() {
        return pers;
    }
    
    public void HisPersbijhgem.setPers(Pers pers) {
        this.pers = pers;
    }
    
    public Integer HisPersbijhgem.getDataanvgel() {
        return dataanvgel;
    }
    
    public void HisPersbijhgem.setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }
    
    public Integer HisPersbijhgem.getDateindegel() {
        return dateindegel;
    }
    
    public void HisPersbijhgem.setDateindegel(Integer dateindegel) {
        this.dateindegel = dateindegel;
    }
    
    public Date HisPersbijhgem.getTsreg() {
        return tsreg;
    }
    
    public void HisPersbijhgem.setTsreg(Date tsreg) {
        this.tsreg = tsreg;
    }
    
    public Date HisPersbijhgem.getTsverval() {
        return tsverval;
    }
    
    public void HisPersbijhgem.setTsverval(Date tsverval) {
        this.tsverval = tsverval;
    }
    
    public Integer HisPersbijhgem.getDatinschringem() {
        return datinschringem;
    }
    
    public void HisPersbijhgem.setDatinschringem(Integer datinschringem) {
        this.datinschringem = datinschringem;
    }
    
    public boolean HisPersbijhgem.isIndonverwdocaanw() {
        return indonverwdocaanw;
    }
    
    public void HisPersbijhgem.setIndonverwdocaanw(boolean indonverwdocaanw) {
        this.indonverwdocaanw = indonverwdocaanw;
    }
    
}
