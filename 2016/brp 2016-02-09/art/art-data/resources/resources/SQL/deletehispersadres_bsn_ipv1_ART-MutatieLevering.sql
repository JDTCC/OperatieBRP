delete from 
  kern.his_persadres 
where  
  persadres in ( select id from kern.persadres where pers in (select id from kern.pers where bsn = ${DataSource Values#|objectid.burgerservicenummer_ipv1|}))