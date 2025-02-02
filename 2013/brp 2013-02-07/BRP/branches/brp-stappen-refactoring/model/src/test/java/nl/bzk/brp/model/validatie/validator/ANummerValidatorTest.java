/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.validatie.validator;

import nl.bzk.brp.model.algemeen.attribuuttype.kern.ANummer;

import org.junit.Assert;
import org.junit.Test;

/** Unit test voor de {@link ANummerValidator} class. */
public class ANummerValidatorTest {

    private final ANummerValidator validator = new ANummerValidator();

    @Test
    public void testGeldigeAnummerValidatie() {
        Assert.assertTrue(validator.isValid(null, null));
        Assert.assertTrue(validator.isValid(new ANummer(null), null));
        Assert.assertTrue(validator.isValid(new ANummer("7934628529"), null));
        //Regel 3 som niet deelbaar door 11 maar som +6 is deelbaar door 11
        Assert.assertTrue(validator.isValid(new ANummer("1082678674"), null));
        Assert.assertTrue(validator.isValid(new ANummer("2481379523"), null));
        Assert.assertTrue(validator.isValid(new ANummer("2785294396"), null));
        Assert.assertTrue(validator.isValid(new ANummer("4935964130"), null));
    }

    @Test
    public void testOnGeldigeAnummerValidatie() {
        Assert.assertFalse(validator.isValid(new ANummer("1"), null));

        //Regel 1: Eerste getal mag geen 0 zijn
        Assert.assertFalse(validator.isValid(new ANummer("734628529"), null));

        //Regel 2: Twee nummers mogen niet achter elkaar hetzelfde zijn
        Assert.assertFalse(validator.isValid(new ANummer("7734628529"), null));
        Assert.assertFalse(validator.isValid(new ANummer("7934628599"), null));

        //Regel 3: Som van alle getallen moet deelbaar door 11 of som +6 moet deelbaar zijn door 11
        Assert.assertFalse(validator.isValid(new ANummer("6734628523"), null));

        //Regel 4: Voeldoet niet, niet deelbaar door 11
        Assert.assertFalse(validator.isValid(new ANummer("4935964135"), null));
    }
}
