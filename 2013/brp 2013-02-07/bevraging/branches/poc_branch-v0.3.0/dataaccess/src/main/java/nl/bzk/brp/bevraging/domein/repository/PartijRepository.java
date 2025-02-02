/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bevraging.domein.repository;

import nl.bzk.brp.bevraging.domein.Partij;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository voor de {@link Partij} class, gebaseerd op Spring's {@link JpaRepository} class.
 */
@Repository
public interface PartijRepository extends JpaRepository<Partij, Long> {

    /**
     * ID van de partij die de regering en staten-generaal voorstelt.
     */
    Long ID_PARTIJ_REGERING_EN_STATEN_GENERAAL = 1L;
    /**
     * Partij die de minister voorstelt.
     */
    Long ID_PARTIJ_MINISTER = 2L;

    /**
     * Vind een partij via het ID.
     * @param id Id van de te zoeken partij.
     * @return Partij met de betreffende Id.
     */
    Partij findById(Long id);
}
