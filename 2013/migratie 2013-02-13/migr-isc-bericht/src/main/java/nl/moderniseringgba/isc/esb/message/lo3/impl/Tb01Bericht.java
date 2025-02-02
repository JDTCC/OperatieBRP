/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.moderniseringgba.isc.esb.message.lo3.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import nl.moderniseringgba.isc.esb.message.BerichtInhoudException;
import nl.moderniseringgba.isc.esb.message.lo3.AbstractLo3Bericht;
import nl.moderniseringgba.isc.esb.message.lo3.Lo3Bericht;
import nl.moderniseringgba.isc.esb.message.lo3.Lo3Header;
import nl.moderniseringgba.isc.esb.message.lo3.Lo3HeaderVeld;
import nl.moderniseringgba.isc.esb.message.lo3.format.Lo3CategorieWaardeFormatter;
import nl.moderniseringgba.isc.esb.message.lo3.format.Lo3Format;
import nl.moderniseringgba.isc.esb.message.lo3.parser.Lo3PersoonslijstParser;
import nl.moderniseringgba.migratie.conversie.model.lo3.Lo3Categorie;
import nl.moderniseringgba.migratie.conversie.model.lo3.Lo3CategorieEnum;
import nl.moderniseringgba.migratie.conversie.model.lo3.Lo3ElementEnum;
import nl.moderniseringgba.migratie.conversie.model.lo3.Lo3Persoonslijst;
import nl.moderniseringgba.migratie.conversie.model.lo3.Lo3Stapel;
import nl.moderniseringgba.migratie.conversie.model.lo3.categorie.Lo3OuderInhoud;
import nl.moderniseringgba.migratie.conversie.model.lo3.categorie.Lo3PersoonInhoud;
import nl.moderniseringgba.migratie.conversie.model.lo3.syntax.Lo3CategorieWaarde;
import nl.moderniseringgba.migratie.conversie.serialize.PersoonslijstDecoder;
import nl.moderniseringgba.migratie.conversie.serialize.PersoonslijstEncoder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Tb01.
 */
public final class Tb01Bericht extends AbstractLo3Bericht implements Lo3Bericht, Serializable {
    private static final long serialVersionUID = 1L;

    private static final Lo3Header HEADER = new Lo3Header(Lo3HeaderVeld.RANDOM_KEY, Lo3HeaderVeld.BERICHTNUMMER,
            Lo3HeaderVeld.HERHALING, Lo3HeaderVeld.GEZOCHTE_PERSOON, Lo3HeaderVeld.AKTENUMMER);

    private static final Lo3PersoonslijstParser PL_PARSER = new Lo3PersoonslijstParser();
    private transient Lo3Persoonslijst lo3Persoonslijst;

    /**
     * Constructor.
     */
    public Tb01Bericht() {
        super(HEADER);

        setHeader(Lo3HeaderVeld.RANDOM_KEY, null);
        setHeader(Lo3HeaderVeld.BERICHTNUMMER, getBerichtType());
        setHeader(Lo3HeaderVeld.HERHALING, null);
        setHeader(Lo3HeaderVeld.GEZOCHTE_PERSOON, null);
        setHeader(Lo3HeaderVeld.AKTENUMMER, null);
    }

    @Override
    public String getStartCyclus() {
        return "uc307";
    }

    @Override
    public String getBerichtType() {
        return "Tb01";
    }

    /* ************************************************************************************************************* */

    @Override
    protected void parseInhoud(final List<Lo3CategorieWaarde> categorieen) throws BerichtInhoudException {
        try {
            lo3Persoonslijst = PL_PARSER.parse(categorieen);
            // CHECKSTYLE:OFF - Catch all, anders final klapt de ESB final er lelijk uit
        } catch (final Exception e) {
            // CHECSTYLE:ON
            throw new BerichtInhoudException("Fout bij parsen lo3 persoonslijst", e);
        }
    }

    @Override
    protected List<Lo3CategorieWaarde> formatInhoud() {
        if (lo3Persoonslijst == null) {
            throw new IllegalStateException("Lo3Persoonslijst mag niet leeg zijn.");
        }

        // // format CAT 1, groep 02, 03, 04 + element 8120
        // // indien aanwezig, CAT 51, groep 02 + element 8120
        // // CAT 2, groep 02, groep 03, groep 04, groep 62
        // // CAT 3, groep 02, groep 03, groep 04, groep 62
        //
        // @formatter:off
        final Lo3CategorieWaardeFormatter formatter = new Lo3CategorieWaardeFormatter();
        final Lo3Stapel<Lo3PersoonInhoud> persoonStapel = lo3Persoonslijst.getPersoonStapel();
        final Lo3Categorie<Lo3PersoonInhoud> persoonActueleCategorie = persoonStapel.getMeestRecenteElement();
        final Lo3PersoonInhoud persoonInhoud = persoonActueleCategorie.getInhoud();
        formatter.categorie(Lo3CategorieEnum.CATEGORIE_01);
        formatter.element(Lo3ElementEnum.ELEMENT_0210,Lo3Format.format(persoonInhoud.getVoornamen()));
        formatter.element(Lo3ElementEnum.ELEMENT_0220,Lo3Format.format(persoonInhoud.getAdellijkeTitelPredikaatCode()));
        formatter.element(Lo3ElementEnum.ELEMENT_0230,Lo3Format.format(persoonInhoud.getVoorvoegselGeslachtsnaam()));
        formatter.element(Lo3ElementEnum.ELEMENT_0240,Lo3Format.format(persoonInhoud.getGeslachtsnaam()));
        formatter.element(Lo3ElementEnum.ELEMENT_0310,Lo3Format.format(persoonInhoud.getGeboortedatum()));
        formatter.element(Lo3ElementEnum.ELEMENT_0320,Lo3Format.format(persoonInhoud.getGeboorteGemeenteCode()));
        formatter.element(Lo3ElementEnum.ELEMENT_0330,Lo3Format.format(persoonInhoud.getGeboorteLandCode()));
        formatter.element(Lo3ElementEnum.ELEMENT_0410,Lo3Format.format(persoonInhoud.getGeslachtsaanduiding()));
        formatter.element(Lo3ElementEnum.ELEMENT_8120,Lo3Format.format(getHeader(Lo3HeaderVeld.AKTENUMMER)));
        
        //
        // Indien aanwezig
        //
        final Lo3Categorie<Lo3PersoonInhoud> persoonHistorieCategorie = persoonStapel.getVorigElement(persoonActueleCategorie);
        if(persoonHistorieCategorie != null) {
            final Lo3PersoonInhoud persoonHistorieInhoud = persoonHistorieCategorie.getInhoud();
            if(persoonHistorieInhoud != null) {
                formatter.categorie(Lo3CategorieEnum.CATEGORIE_51);
                formatter.element(Lo3ElementEnum.ELEMENT_0210, Lo3Format.format(persoonHistorieInhoud.getVoornamen()));
                formatter.element(Lo3ElementEnum.ELEMENT_0220, Lo3Format.format(persoonHistorieInhoud.getAdellijkeTitelPredikaatCode()));
                formatter.element(Lo3ElementEnum.ELEMENT_0230, Lo3Format.format(persoonHistorieInhoud.getVoorvoegselGeslachtsnaam()));
                formatter.element(Lo3ElementEnum.ELEMENT_0240, Lo3Format.format(persoonHistorieInhoud.getGeslachtsnaam()));
                formatter.element(Lo3ElementEnum.ELEMENT_8120, Lo3Format.format(this.getHeader(Lo3HeaderVeld.AKTENUMMER)));
           }            
        }

        // Ouder 1
        final List<Lo3Stapel<Lo3OuderInhoud>> ouder1Stapels = lo3Persoonslijst.getOuder1Stapels();
        final Lo3Stapel<Lo3OuderInhoud> ouder1Stapel = ouder1Stapels.get(0);
        final Lo3OuderInhoud ouder1Inhoud = ouder1Stapel.getMeestRecenteElement().getInhoud();
        formatter.categorie(Lo3CategorieEnum.CATEGORIE_02);
        formatter.element(Lo3ElementEnum.ELEMENT_0210, Lo3Format.format(ouder1Inhoud.getVoornamen()));
        formatter.element(Lo3ElementEnum.ELEMENT_0220, Lo3Format.format(ouder1Inhoud.getAdellijkeTitelPredikaatCode()));
        formatter.element(Lo3ElementEnum.ELEMENT_0230, Lo3Format.format(ouder1Inhoud.getVoorvoegselGeslachtsnaam()));
        formatter.element(Lo3ElementEnum.ELEMENT_0240, Lo3Format.format(ouder1Inhoud.getGeslachtsnaam()));
        formatter.element(Lo3ElementEnum.ELEMENT_0310, Lo3Format.format(ouder1Inhoud.getGeboortedatum()));
        formatter.element(Lo3ElementEnum.ELEMENT_0320, Lo3Format.format(ouder1Inhoud.getGeboorteGemeenteCode()));
        formatter.element(Lo3ElementEnum.ELEMENT_0330, Lo3Format.format(ouder1Inhoud.getGeboorteLandCode()));
        formatter.element(Lo3ElementEnum.ELEMENT_0410, Lo3Format.format(ouder1Inhoud.getGeslachtsaanduiding()));
        formatter.element(Lo3ElementEnum.ELEMENT_6210, Lo3Format.format(ouder1Inhoud.getFamilierechtelijkeBetrekking()));
        
        // Indien aanwezig, Ouder 2
        final List<Lo3Stapel<Lo3OuderInhoud>> ouder2Stapels = lo3Persoonslijst.getOuder2Stapels();
        if(ouder2Stapels != null && !ouder2Stapels.isEmpty()) {
            final Lo3Stapel<Lo3OuderInhoud> ouder2Stapel = ouder2Stapels.get(0);
            final Lo3OuderInhoud ouder2Inhoud = ouder2Stapel.getMeestRecenteElement().getInhoud();
            formatter.categorie(Lo3CategorieEnum.CATEGORIE_03);
            formatter.element(Lo3ElementEnum.ELEMENT_0210, Lo3Format.format(ouder2Inhoud.getVoornamen()));
            formatter.element(Lo3ElementEnum.ELEMENT_0220, Lo3Format.format(ouder2Inhoud.getAdellijkeTitelPredikaatCode()));
            formatter.element(Lo3ElementEnum.ELEMENT_0230, Lo3Format.format(ouder2Inhoud.getVoorvoegselGeslachtsnaam()));
            formatter.element(Lo3ElementEnum.ELEMENT_0240, Lo3Format.format(ouder2Inhoud.getGeslachtsnaam()));
            formatter.element(Lo3ElementEnum.ELEMENT_0310, Lo3Format.format(ouder2Inhoud.getGeboortedatum()));
            formatter.element(Lo3ElementEnum.ELEMENT_0320, Lo3Format.format(ouder2Inhoud.getGeboorteGemeenteCode()));
            formatter.element(Lo3ElementEnum.ELEMENT_0330, Lo3Format.format(ouder2Inhoud.getGeboorteLandCode()));
            formatter.element(Lo3ElementEnum.ELEMENT_0410, Lo3Format.format(ouder2Inhoud.getGeslachtsaanduiding()));
            formatter.element(Lo3ElementEnum.ELEMENT_6210, Lo3Format.format(ouder2Inhoud.getFamilierechtelijkeBetrekking()));
        }
        // @formatter:off
        return formatter.getList();
    }

    /* ************************************************************************************************************* */

    public Lo3Persoonslijst getLo3Persoonslijst() {
        return lo3Persoonslijst;
    }

    public void setLo3Persoonslijst(final Lo3Persoonslijst lo3Persoonslijst) {
        this.lo3Persoonslijst = lo3Persoonslijst;
    }

    /* ********************************************************************************************************** */

    private void readObject(final ObjectInputStream is) throws ClassNotFoundException, IOException {
        // always perform the default de-serialization first
        is.defaultReadObject();

        lo3Persoonslijst = PersoonslijstDecoder.decodeLo3Persoonslijst(is);
    }

    private void writeObject(final ObjectOutputStream os) throws IOException {
        // perform the default serialization for all non-transient, non-static fields
        os.defaultWriteObject();

        PersoonslijstEncoder.encodePersoonslijst(lo3Persoonslijst, os);
    }

    /* ************************************************************************************************************* */

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tb01Bericht)) {
            return false;
        }

        // PL van bericht wordt expliciet niet meegenomen in de vergelijking, omdat een Tb01Bericht vanuit GBA een onvolledige PL bevat
        // en een Tb01Bericht vanuit BRP meer informatie bevat dan dat er via de Lo3 String richting GBA gaat
        // op dit moment is de implementatie dus niet symmetrisch vwb de lo3Persoonslijst
        return new EqualsBuilder().appendSuper(super.equals(other)).isEquals();
    }

    @Override
    public int hashCode() {
        // zie commentaar bij equals...
        return new HashCodeBuilder().appendSuper(super.hashCode()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString())
                .append("lo3Persoonslijst", lo3Persoonslijst).toString();
    }
}
