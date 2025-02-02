/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.mutatielevering.stappen.lo3;

import java.util.ArrayList;
import java.util.List;

import nl.bzk.brp.business.stappen.AbstractStap;
import nl.bzk.brp.levering.business.stappen.populatie.LeveringautorisatieStappenOnderwerp;
import nl.bzk.brp.levering.business.stappen.populatie.LeveringautorisatieVerwerkingResultaat;
import nl.bzk.brp.levering.lo3.bericht.Bericht;
import nl.bzk.brp.levering.mutatielevering.Lo3LeveringsautorisatieVerwerkingContext;
import nl.bzk.brp.model.levering.SynchronisatieBericht;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * Test voor {@link nl.bzk.brp.levering.mutatielevering.stappen.lo3.ConverteerNaarLo3Stap}
 */
@RunWith(MockitoJUnitRunner.class)
public class ConverteerNaarLo3StapTest {

    @InjectMocks
    private ConverteerNaarLo3Stap subject;

    @Mock
    private Lo3LeveringsautorisatieVerwerkingContext context;
    @Mock
    private LeveringautorisatieStappenOnderwerp      onderwerp;
    @Mock
    private LeveringautorisatieVerwerkingResultaat   resultaat;

    @Mock
    private Bericht bericht1;
    @Mock
    private Bericht bericht2;

    @Before
    public final void setup() {
        final List<SynchronisatieBericht> leveringBerichten = new ArrayList<>();
        leveringBerichten.add(bericht1);
        leveringBerichten.add(bericht2);
        Mockito.when(context.getLeveringBerichten()).thenReturn(leveringBerichten);
    }

    @Test
    public final void test() {
        final boolean result = subject.voerStapUit(onderwerp, context, resultaat);
        Assert.assertEquals(AbstractStap.DOORGAAN, result);

        Mockito.verify(bericht1).converteerNaarLo3(null);
        Mockito.verify(bericht2).converteerNaarLo3(null);
    }

    @Test(expected = IllegalStateException.class)
    public final void testException() {
        Mockito.doThrow(IllegalStateException.class).when(bericht1).converteerNaarLo3(null);

        subject.voerStapUit(onderwerp, context, resultaat);
    }

}
