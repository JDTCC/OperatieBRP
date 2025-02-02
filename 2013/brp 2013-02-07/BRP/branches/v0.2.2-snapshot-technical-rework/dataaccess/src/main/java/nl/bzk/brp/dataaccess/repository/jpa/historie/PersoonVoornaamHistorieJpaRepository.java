/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.dataaccess.repository.jpa.historie;

import nl.bzk.brp.model.groep.operationeel.AbstractPersoonVoornaamStandaardGroep;
import nl.bzk.brp.model.groep.operationeel.historisch.PersoonVoornaamStandaardHisModel;
import nl.bzk.brp.model.objecttype.operationeel.PersoonVoornaamModel;
import org.springframework.stereotype.Repository;


/**
 * Repository voor de {@link PersoonVoornaamModel} class.
 */
@Repository("persoonVoornaamHistorieRepository")
public class PersoonVoornaamHistorieJpaRepository extends
    AbstractGroepHistorieRepository<PersoonVoornaamModel, AbstractPersoonVoornaamStandaardGroep,
            PersoonVoornaamStandaardHisModel>
{

    @Override
    protected String padNaarALaagEntiteitInCLaagEntiteit() {
        return "persoonVoornaam";
    }

    @Override
    protected Class<PersoonVoornaamStandaardHisModel> getCLaagDomainClass() {
        return PersoonVoornaamStandaardHisModel.class;
    }

    @Override
    protected PersoonVoornaamStandaardHisModel maakNieuwHistorieRecord(
            final PersoonVoornaamModel objectType, final AbstractPersoonVoornaamStandaardGroep groep)
    {
        // dual gebruik, als groep is null, haal de groep uit de huidige ALaag
        if (groep == null) {
            return new PersoonVoornaamStandaardHisModel(objectType.getGegevens(), objectType);
        } else {
            return new PersoonVoornaamStandaardHisModel(groep, objectType);
        }
    }


}
