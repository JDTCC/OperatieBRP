/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.stappen.bijhouding;

import java.util.ArrayList;
import java.util.List;

import nl.bzk.brp.business.dto.BerichtContext;
import nl.bzk.brp.business.dto.BerichtVerwerkingsResultaat;
import nl.bzk.brp.business.dto.bijhouding.AbstractBijhoudingsBericht;
import nl.bzk.brp.business.stappen.AbstractBerichtVerwerkingsStap;
import nl.bzk.brp.model.algemeen.stamgegeven.ber.SoortMelding;
import nl.bzk.brp.model.bericht.ber.AdministratieveHandelingGedeblokkeerdeMeldingBericht;
import nl.bzk.brp.model.validatie.Melding;
import nl.bzk.brp.model.validatie.MeldingCode;
import nl.bzk.brp.model.validatie.SoortOverruleMelding;
import org.apache.commons.collections.CollectionUtils;

/**
 * In deze stap wordt getest of er nog meldingen overblijven die overruled zouden zijn (de gebruiken's intentie),
 * maar niet is gebeurd.
 * Dit kan verschillende oorzaken hebben:
 * - 1) de verwachtte foutmelding is niet gebeurd (de informatie is correct ipv. fout)
 * - 2) de verwachtte foutmelding is niet gebeurd (verkeerde MeldingsCode of verzendendId)
 * - 3) de applicatie is nooit zover gekomen dat deze validatie wordt uitgevoerd.
 * <p/>
 * In alle gevallen tonen we deze meldingen en de verwerking wordt of niet uitgevoerd of terug gedraaid.
 * <p/>
 * Om ervoor te zorgen dat deze melding getoond, wordt, is deze stap de 'laatste' voor het uitvoeren stap en daardoor
 * op de terugweg de eerste na de uitvoerstap.
 * Alle nabewerking validaties kunnen in een aparte stap na de uitvoerstap
 */
public class BijhoudingOverruleMeldingenValidatieStap extends AbstractBerichtVerwerkingsStap<AbstractBijhoudingsBericht,
    BerichtVerwerkingsResultaat>
{
    // private static final Logger LOGGER = LoggerFactory.getLogger(BijhoudingOverruleMeldingenValidatieStap.class);

    @Override
    public boolean voerVerwerkingsStapUitVoorBericht(final AbstractBijhoudingsBericht bericht,
        final BerichtContext context, final BerichtVerwerkingsResultaat resultaat)
    {
        // test of er nog overrule meldingen blijven staan die diet zijn geraakt, als dit een fout geeft, wordt
        // de UItvoerstap niet uitgevoerd.
        meldOverigeNietGedetecteerdeMeldingen(bericht, resultaat, true);
        return DOORGAAN_MET_VERWERKING;
    }

    @Override
    public void naVerwerkingsStapVoorBericht(final AbstractBijhoudingsBericht bericht,
        final BerichtContext context, final BerichtVerwerkingsResultaat resultaat)
    {
        // houdt rekening mee, dat er overrule meldingen zijn die alsnog in de naverwerking overruled kan worden.
        meldOverigeNietGedetecteerdeMeldingen(bericht, resultaat, false);
    }

    /**
     * Er mogen geen andere overrulebare fouten overblijven. (maw. alle fouten zijn nu overruled).
     * Er zijn 2 modes (op de heegaande en op de terug gaande. Op de heengaande skip alle overrule meldingen van type
     * NABEWERKING_VALIDATIE_MELDING, deze komen later tijdens de valie na de voeruit stap en deze check wordt
     * op de tergweg uitgevoerd.
     *
     * @param bericht .
     * @param skipNaVerwerkingType sla over alle overrule meldingen van het type NABEWERKING_VALIDATIE_MELDING.
     * @param resultaat .
     */
    private void meldOverigeNietGedetecteerdeMeldingen(final AbstractBijhoudingsBericht bericht,
        final BerichtVerwerkingsResultaat resultaat, final boolean skipNaVerwerkingType)
    {
        // test of nog in de lijst meldingen staan die we niet gevonden hebben.
        if (CollectionUtils.isNotEmpty(bericht.getAdministratieveHandeling().getGedeblokkeerdeMeldingen())) {
            List<String> codes = new ArrayList<String>();

            for (AdministratieveHandelingGedeblokkeerdeMeldingBericht m :
                bericht.getAdministratieveHandeling().getGedeblokkeerdeMeldingen())
            {
                // check of deze niet in de lijst vsn naverwerking lijst voorkomt.
                if ((m.getGedeblokkeerdeMelding().getSoort()
                    == SoortOverruleMelding.NABEWERKING_VALIDATIE_MELDING) && skipNaVerwerkingType)
                {
                    continue;
                } else {
                    // oeps, probeert te overrulen wat er niet was. foei !!
                    codes.add(m.getGedeblokkeerdeMelding().getRegel().getCode());
                }
            }
            if (CollectionUtils.isNotEmpty(codes)) {
                // pak de eerste verzendend id als id
                resultaat.voegMeldingToe(new Melding(SoortMelding.FOUT, MeldingCode.ALG0001,
                    "Er zijn overrulebare meldingen opgegeven die niet van toepassing zijn: " + codes + ".",
                    bericht.getAdministratieveHandeling().getGedeblokkeerdeMeldingen().get(0)
                           .getGedeblokkeerdeMelding(), "regelCode"));

            }
        }
    }

}
