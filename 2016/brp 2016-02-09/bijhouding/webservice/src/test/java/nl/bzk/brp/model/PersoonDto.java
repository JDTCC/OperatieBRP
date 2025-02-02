/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * .
 */
public final class PersoonDto {
    private static final String SQL_PERSOON_BY_BSN = "select id, bsn, anr from kern.pers where bsn = ?";
    private final Integer id;
    private final String bsn;
    private final String anr;

    private PersoonDto(final Integer id, final String bsn, final String anr) {
        this.id = id;
        this.bsn = bsn;
        this.anr = anr;
    }

    /**
     * @return het id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return de bsn
     */
    public String getBsn() {
        return bsn;
    }

    /**
     * @return the anr
     */
    public String getAnr() {
        return anr;
    }

    /**
     * .
     *
     * @param simpleJdbcTemplate
     * @param bsn
     * @return
     */
    public static List<PersoonDto> persoonMetBsnBestaatInALaag(final JdbcTemplate simpleJdbcTemplate,
        final String bsn)
    {
        List<PersoonDto> personen = new ArrayList<>();

        Integer bsnInt = Integer.parseInt(bsn);
        List<Map<String, Object>> rows = simpleJdbcTemplate.queryForList(SQL_PERSOON_BY_BSN, bsnInt);
        for (Map<String, Object> row : rows) {
            String b = row.get("bsn").toString();
            String a = null;
            if (row.get("anr") != null) {
                a = row.get("anr").toString();
            }

            personen.add(new PersoonDto((Integer) row.get("id"), b, a));
        }
        return personen;
    }


}
