// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.model.data.brm.HisRegelimplementatiesituat;
import nl.bzk.brp.model.data.brm.Regelimplementatiesituatie;
import nl.bzk.brp.model.data.kern.HisPersopschorting;
import nl.bzk.brp.model.data.kern.Pers;
import nl.bzk.brp.model.data.kern.Rdnopschorting;

privileged aspect Rdnopschorting_Roo_DbManaged {
    
    @OneToMany(mappedBy = "rdnopschorting")
    private Set<HisRegelimplementatiesituat> Rdnopschorting.hisRegelimplementatiesituats;
    
    @OneToMany(mappedBy = "rdnopschorting")
    private Set<Regelimplementatiesituatie> Rdnopschorting.regelimplementatiesituaties;
    
    @OneToMany(mappedBy = "rdnopschortingbijhouding")
    private Set<HisPersopschorting> Rdnopschorting.hisPersopschortings;
    
    @OneToMany(mappedBy = "rdnopschortingbijhouding")
    private Set<Pers> Rdnopschorting.perss;
    
    @Column(name = "code", columnDefinition = "varchar", length = 1, unique = true)
    @NotNull
    private String Rdnopschorting.code;
    
    @Column(name = "naam", columnDefinition = "varchar", length = 40, unique = true)
    @NotNull
    private String Rdnopschorting.naam;
    
    public Set<HisRegelimplementatiesituat> Rdnopschorting.getHisRegelimplementatiesituats() {
        return hisRegelimplementatiesituats;
    }
    
    public void Rdnopschorting.setHisRegelimplementatiesituats(Set<HisRegelimplementatiesituat> hisRegelimplementatiesituats) {
        this.hisRegelimplementatiesituats = hisRegelimplementatiesituats;
    }
    
    public Set<Regelimplementatiesituatie> Rdnopschorting.getRegelimplementatiesituaties() {
        return regelimplementatiesituaties;
    }
    
    public void Rdnopschorting.setRegelimplementatiesituaties(Set<Regelimplementatiesituatie> regelimplementatiesituaties) {
        this.regelimplementatiesituaties = regelimplementatiesituaties;
    }
    
    public Set<HisPersopschorting> Rdnopschorting.getHisPersopschortings() {
        return hisPersopschortings;
    }
    
    public void Rdnopschorting.setHisPersopschortings(Set<HisPersopschorting> hisPersopschortings) {
        this.hisPersopschortings = hisPersopschortings;
    }
    
    public Set<Pers> Rdnopschorting.getPerss() {
        return perss;
    }
    
    public void Rdnopschorting.setPerss(Set<Pers> perss) {
        this.perss = perss;
    }
    
    public String Rdnopschorting.getCode() {
        return code;
    }
    
    public void Rdnopschorting.setCode(String code) {
        this.code = code;
    }
    
    public String Rdnopschorting.getNaam() {
        return naam;
    }
    
    public void Rdnopschorting.setNaam(String naam) {
        this.naam = naam;
    }
    
}
