/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.toegangsbewaking.test.model;

// Generated 23-sep-2011 15:40:39 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Srtdoc generated by hbm2java
 */
@Entity
@Table(name = "srtdoc", schema = "kern", uniqueConstraints = @UniqueConstraint(columnNames = "oms"))
public class Srtdoc implements java.io.Serializable {

    private int      id;
    private String   oms;
    private Set<Doc> docs = new HashSet<Doc>(0);

    public Srtdoc() {
    }

    public Srtdoc(int id, String oms) {
        this.id = id;
        this.oms = oms;
    }

    public Srtdoc(int id, String oms, Set<Doc> docs) {
        this.id = id;
        this.oms = oms;
        this.docs = docs;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "oms", unique = true, nullable = false, length = 200)
    public String getOms() {
        return this.oms;
    }

    public void setOms(String oms) {
        this.oms = oms;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "srtdoc")
    public Set<Doc> getDocs() {
        return this.docs;
    }

    public void setDocs(Set<Doc> docs) {
        this.docs = docs;
    }

}
