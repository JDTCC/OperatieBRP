/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.conversie.regels.expressie.impl.criteria;

/**
 * Kleiner dan of gelijk aan alle operator.
 */
public class KleinerGelijkAlleOperator extends StandaardOperator {

    /**
     * Constructor.
     */
    public KleinerGelijkAlleOperator() {
        super("%1$s A<= %2$s");
    }
}
