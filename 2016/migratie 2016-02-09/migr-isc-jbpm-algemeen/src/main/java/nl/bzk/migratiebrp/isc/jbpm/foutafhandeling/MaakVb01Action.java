/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.isc.jbpm.foutafhandeling;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.inject.Inject;
import nl.bzk.migratiebrp.bericht.model.lo3.Lo3Bericht;
import nl.bzk.migratiebrp.bericht.model.lo3.impl.Vb01Bericht;
import nl.bzk.migratiebrp.isc.jbpm.common.berichten.BerichtenDao;
import nl.bzk.migratiebrp.isc.jbpm.common.spring.SpringAction;
import org.springframework.stereotype.Component;

/**
 * Maak het Vb01 bericht.
 */
@Component("foutafhandelingMaakVb01Action")
public final class MaakVb01Action implements SpringAction {

    @Inject
    private BerichtenDao berichtenDao;

    @Override
    public Map<String, Object> execute(final Map<String, Object> parameters) {
        final Lo3Bericht bericht = (Lo3Bericht) berichtenDao.leesBericht((Long) parameters.get(FoutafhandelingConstants.BERICHT_PF));
        if (bericht == null) {
            throw new IllegalStateException("Geen LO3 bericht om Vb01 aan te relateren.");
        }

        // Zet de headerinformatie.
        final String foutParameter = (String) parameters.get(FoutafhandelingConstants.FOUT);
        final String foutmelding = (String) parameters.get(FoutafhandelingConstants.FOUTMELDING);

        String fout = null;
        final ResourceBundle resourceBundle = ResourceBundle.getBundle("nl.bzk.migratiebrp.isc.jbpm.common.jsf.Messages");
        try {
            if (foutParameter != null) {
                fout = resourceBundle.getString(foutParameter);
            }
        } catch (final MissingResourceException exception) {
            fout = foutParameter;
        }

        final String samengesteldeFoutmelding;
        if (foutmelding != null) {
            samengesteldeFoutmelding = fout + FoutafhandelingConstants.FOUTMELDING_SCHEIDINGSTEKEN + foutmelding;
        } else {
            samengesteldeFoutmelding = fout;
        }

        final String foutBericht =
                "Afzender        : migratievoorziening\n"
                        + "Betreft bericht : Pf03\n"
                        + "Betreft eref    : "
                        + bericht.getMessageId()
                        + "\n"
                        + "Toelichting     : Hieronder volgt een toelichting op bovenstaand bericht\n"
                        + samengesteldeFoutmelding;

        final Vb01Bericht vb01Bericht = new Vb01Bericht(foutBericht);

        // Zet de bron/doel-gemeente, omdat deze uit het pf03-bericht komen zijn deze gelijk aan die in het pf03.
        vb01Bericht.setBronGemeente(bericht.getBronGemeente());
        vb01Bericht.setDoelGemeente(bericht.getDoelGemeente());

        final Map<String, Object> result = new HashMap<>();
        result.put(FoutafhandelingConstants.BERICHT_VB01, berichtenDao.bewaarBericht(vb01Bericht));

        return result;
    }
}
