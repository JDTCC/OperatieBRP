/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.pocmotor.model.gedeeld.usr.enums;

/**
 * Soort regel
  */
public enum SoortRegel {

   /** Dummy value. Echte values beginnen in de database bij 1 ipv 0 */
   DUMMY(null, null),
   SYSTEEMREGEL("Systeemregel", "Regels die moeten gelden voor een goede technische werking van het stelsel, doordat ze verweven zijn met de structuur van het systeem."),
   BEDRIJFSREGEL("Bedrijfsregel", "Regels die moeten gelden voor een goede inhoudelijke werking van het stelsel.");


   private final String naam;

   private final String omschrijving;



   private SoortRegel(final String naam, final String omschrijving) {
      this.naam = naam;
      this.omschrijving = omschrijving;
   }


   public String getNaam() {
      return naam;
   }

   public String getOmschrijving() {
      return omschrijving;
   }



}
