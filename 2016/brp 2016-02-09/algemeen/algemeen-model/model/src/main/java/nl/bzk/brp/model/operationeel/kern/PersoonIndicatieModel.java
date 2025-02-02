/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.operationeel.kern;

import javax.persistence.Entity;
import javax.persistence.Table;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortIndicatieAttribuut;
import nl.bzk.brp.model.logisch.kern.PersoonIndicatie;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


/**
 * Indicaties bij een persoon.
 */
@Entity
@Table(schema = "Kern", name = "PersIndicatie")
public class PersoonIndicatieModel extends AbstractPersoonIndicatieModel implements PersoonIndicatie,
    Comparable<PersoonIndicatieModel>
{

    private static final int HASHCODE_GETAL1 = 987;
    private static final int HASHCODE_GETAL2 = 678769;

    /**
     * Standaard constructor (t.b.v. Hibernate/JPA).
     */
    protected PersoonIndicatieModel() {
        super();
    }

    /**
     * Standaard constructor die direct alle identificerende attributen instantieert of doorgeeft.
     *
     * @param persoon persoon van Persoon \ Indicatie.
     * @param soort   soort van Persoon \ Indicatie.
     */
    public PersoonIndicatieModel(final PersoonModel persoon, final SoortIndicatieAttribuut soort) {
        super(persoon, soort);
    }

    /**
     * Copy constructor om vanuit het bericht model een instantie van het operationeel model te maken.
     *
     * @param persoonIndicatie Te kopieren object type.
     * @param persoon          Bijbehorende Persoon.
     */
    public PersoonIndicatieModel(final PersoonIndicatie persoonIndicatie, final PersoonModel persoon) {
        super(persoonIndicatie, persoon);
    }

    @Override
    public int compareTo(final PersoonIndicatieModel o) {
        return new CompareToBuilder().append(this.getSoort(), o.getSoort()).toComparison();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        final boolean isGelijk;

        if (obj == null || obj.getClass() != getClass()) {
            isGelijk = false;
        } else if (this == obj) {
            isGelijk = true;
        } else {
            final PersoonIndicatieModel indicatieModel = (PersoonIndicatieModel) obj;
            isGelijk = new EqualsBuilder().append(this.getSoort(), indicatieModel.getSoort()).isEquals();
        }
        return isGelijk;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(HASHCODE_GETAL1, HASHCODE_GETAL2).append(this.getSoort()).hashCode();
    }

}
