// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.ber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.ber.Ber;

privileged aspect Ber_Roo_Jpa_Entity {
    
    declare @type: Ber: @Entity;
    
    declare @type: Ber: @Table(schema = "ber", name = "ber");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigserial")
    private Long Ber.id;
    
    public Long Ber.getId() {
        return this.id;
    }
    
    public void Ber.setId(Long id) {
        this.id = id;
    }
    
}
