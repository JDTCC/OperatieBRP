/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.expressietaal.parser.syntaxtree.functies;

import java.util.List;

import nl.bzk.brp.expressietaal.parser.syntaxtree.AbstractFunctieExpressie;
import nl.bzk.brp.expressietaal.parser.syntaxtree.Context;
import nl.bzk.brp.expressietaal.parser.syntaxtree.Expressie;
import nl.bzk.brp.expressietaal.parser.syntaxtree.ExpressieType;
import nl.bzk.brp.expressietaal.symbols.Keywords;


/**
 * Representeert de functie GEDEFINIEERD(A). De functie geeft TRUE terug als het attribuut A een waarde heeft, anders
 * FALSE.
 */
public class FunctieGEDEFINIEERD extends AbstractFunctieExpressie {
    /**
     * Constructor. Creeer functie-expressie voor functie GEDEFINIEERD().
     *
     * @param argumenten Argumenten van de aanroep.
     */
    public FunctieGEDEFINIEERD(final List<Expressie> argumenten) {
        super(Keywords.GEDEFINIEERD, argumenten, ExpressieType.BOOLEAN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final Expressie create(final List<Expressie> argumentenAanroep) {
        return new FunctieGEDEFINIEERD(argumentenAanroep);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final Expressie calculate(final List<Expressie> gereduceerdeArgumenten, final Context context) {
        return null;
    }
}
