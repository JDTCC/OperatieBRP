Meta:
@auteur                 fuman
@status                 Klaar
@regels                 R1676
@sleutelwoorden         voltrekkingHuwelijkInNederland, VHNL02C790T10
@usecase                UCS-BY.HG


Narrative:
Combinatie scheidingsteken en voorvoegsel bestaat niet in de stamtabel

Scenario:   Personen Libby Thatcher (Ingeschrevene-Ingezetene, Niet NL Nat) en Piet Jansen (Onbekende) gaan trouwen, Combinatie scheidingsteken en voorvoegsel bestaat niet in de stamtabel
            LT: VHNL02C790T10



Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL/VHNL02_reg_gesl_nm-Libby.xls

When voer een bijhouding uit VHNL02C790T10.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Foutief
Then is het antwoordbericht gelijk aan /testcases/bijhouding/VHNL/expected/VHNL02C790T10.xml voor expressie //brp:bhg_hgpRegistreerHuwelijkGeregistreerdPartnerschap_R

Then is in de database de persoon met bsn 690020041 niet als PARTNER betrokken bij een HUWELIJK
Then is in de database de persoon met bsn 373230217 niet als PARTNER betrokken bij een HUWELIJK

Then lees persoon met anummer 8240349473 uit database en vergelijk met expected VHNL02C790T10-persoon1.xml
