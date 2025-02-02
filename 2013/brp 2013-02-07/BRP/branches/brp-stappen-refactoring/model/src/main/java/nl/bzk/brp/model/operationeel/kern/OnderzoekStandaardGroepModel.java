/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.operationeel.kern;

import javax.persistence.Embeddable;

import nl.bzk.brp.model.algemeen.attribuuttype.kern.Datum;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.OnderzoekOmschrijving;
import nl.bzk.brp.model.logisch.kern.OnderzoekStandaardGroep;
import nl.bzk.brp.model.operationeel.kern.basis.AbstractOnderzoekStandaardGroepModel;


/**
 * Vorm van historie: formeel. Motivatie: 'onderzoek' is een construct om vast te leggen dat een bepaald gegeven
 * onderwerp is van onderzoek. Hierbij is het in principe alleen relevant of een gegeven NU in onderzoek is. Verder is
 * het voldoende om te weten of tijdens een bepaalde levering een gegeven wel of niet als 'in onderzoek' stond
 * geregistreerd. NB: de gegevens over het onderzoek zelf staan niet in de BRP, maar in bijvoorbeeld de zaaksystemen.
 * Omdat formele historie dus volstaat, wordt de materi�le historie onderdrukt. RvdP 17 jan 2012.
 *
 *
 *
 * Generator: nl.bzk.brp.generatoren.java.OperationeelModelGenerator.
 * Metaregister versie: 1.1.8.
 * Generator versie: 1.0-SNAPSHOT.
 * Generator gebouwd op: 2012-11-27 12:02:51.
 * Gegenereerd op: Tue Nov 27 14:55:36 CET 2012.
 */
@Embeddable
public class OnderzoekStandaardGroepModel extends AbstractOnderzoekStandaardGroepModel implements
        OnderzoekStandaardGroep
{

    /**
     * Standaard constructor (t.b.v. Hibernate/JPA).
     *
     */
    protected OnderzoekStandaardGroepModel() {
        super();
    }

    /**
     * Basis constructor die direct alle velden instantieert.
     *
     * @param datumBegin datumBegin van Standaard.
     * @param datumEinde datumEinde van Standaard.
     * @param omschrijving omschrijving van Standaard.
     */
    public OnderzoekStandaardGroepModel(final Datum datumBegin, final Datum datumEinde,
        final OnderzoekOmschrijving omschrijving)
    {
        super(datumBegin, datumEinde, omschrijving);
    }

}
