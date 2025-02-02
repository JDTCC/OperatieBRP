/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.operationeel.kern.basis;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import nl.bzk.brp.model.algemeen.stamgegeven.kern.RedenOpschorting;
import nl.bzk.brp.model.logisch.kern.PersoonOpschortingGroep;
import nl.bzk.brp.model.logisch.kern.basis.PersoonOpschortingGroepBasis;


/**
 * 1. Vorm van historie: een reden opschorting wordt normaliter met terugwerkende kracht vastgelegd. Conform
 * bijhoudingsverantwoordelijkheid heeft de materi�le tijdslijn (dus) betekenis. In tegenstelling tot
 * bijhoudingsverantwoordelijkheid is de business case voor het expliciet vastleggen van de datum ingang van een reden
 * opschorting wat minder hard: wellicht zou de BRP ook toe kunnen met alleen de formele tijdslijn. Echter, er zijn
 * allerlei regels rondom datum ingang van opschorting, zoals rondom overlijden, �n dit gegeven wordt al van oudsher
 * vastgelegd in LO 3.x. Om die reden is het gegeven gehandhaaft.
 *
 *
 *
 * Generator: nl.bzk.brp.generatoren.java.OperationeelModelGenerator.
 * Metaregister versie: 1.6.0.
 * Generator versie: 1.0-SNAPSHOT.
 * Generator gebouwd op: 2013-01-21 13:38:20.
 * Gegenereerd op: Mon Jan 21 13:42:15 CET 2013.
 */
@MappedSuperclass
public abstract class AbstractPersoonOpschortingGroepModel implements PersoonOpschortingGroepBasis {

    @Enumerated
    @Column(name = "RdnOpschortingBijhouding")
    @JsonProperty
    private RedenOpschorting redenOpschortingBijhouding;

    /**
     * Standaard constructor (t.b.v. Hibernate/JPA).
     *
     */
    protected AbstractPersoonOpschortingGroepModel() {
    }

    /**
     * Basis constructor die direct alle velden instantieert.
     *
     * @param redenOpschortingBijhouding redenOpschortingBijhouding van Opschorting.
     */
    public AbstractPersoonOpschortingGroepModel(final RedenOpschorting redenOpschortingBijhouding) {
        this.redenOpschortingBijhouding = redenOpschortingBijhouding;

    }

    /**
     * Copy constructor om vanuit het bericht model een instantie van het operationeel model te maken.
     *
     * @param persoonOpschortingGroep te kopieren groep.
     */
    public AbstractPersoonOpschortingGroepModel(final PersoonOpschortingGroep persoonOpschortingGroep) {
        this.redenOpschortingBijhouding = persoonOpschortingGroep.getRedenOpschortingBijhouding();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RedenOpschorting getRedenOpschortingBijhouding() {
        return redenOpschortingBijhouding;
    }

}
