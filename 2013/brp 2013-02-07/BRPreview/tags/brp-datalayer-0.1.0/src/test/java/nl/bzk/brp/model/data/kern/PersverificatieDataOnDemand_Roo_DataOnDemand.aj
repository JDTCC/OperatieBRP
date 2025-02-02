// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import nl.bzk.brp.model.data.kern.Pers;
import nl.bzk.brp.model.data.kern.PersDataOnDemand;
import nl.bzk.brp.model.data.kern.Persverificatie;
import nl.bzk.brp.model.data.kern.PersverificatieDataOnDemand;
import nl.bzk.brp.model.data.kern.Srtverificatie;
import nl.bzk.brp.model.data.kern.SrtverificatieDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect PersverificatieDataOnDemand_Roo_DataOnDemand {
    
    declare @type: PersverificatieDataOnDemand: @Component;
    
    private Random PersverificatieDataOnDemand.rnd = new SecureRandom();
    
    private List<Persverificatie> PersverificatieDataOnDemand.data;
    
    @Autowired
    private PersDataOnDemand PersverificatieDataOnDemand.persDataOnDemand;
    
    @Autowired
    private SrtverificatieDataOnDemand PersverificatieDataOnDemand.srtverificatieDataOnDemand;
    
    public Persverificatie PersverificatieDataOnDemand.getNewTransientPersverificatie(int index) {
        Persverificatie obj = new Persverificatie();
        setDat(obj, index);
        setGeverifieerde(obj, index);
        setPersverificatiestatushis(obj, index);
        setSrt(obj, index);
        return obj;
    }
    
    public void PersverificatieDataOnDemand.setDat(Persverificatie obj, int index) {
        BigDecimal dat = BigDecimal.valueOf(index);
        obj.setDat(dat);
    }
    
    public void PersverificatieDataOnDemand.setGeverifieerde(Persverificatie obj, int index) {
        Pers geverifieerde = persDataOnDemand.getRandomPers();
        obj.setGeverifieerde(geverifieerde);
    }
    
    public void PersverificatieDataOnDemand.setPersverificatiestatushis(Persverificatie obj, int index) {
        String persverificatiestatushis = String.valueOf(index);
        if (persverificatiestatushis.length() > 1) {
            persverificatiestatushis = persverificatiestatushis.substring(0, 1);
        }
        obj.setPersverificatiestatushis(persverificatiestatushis);
    }
    
    public void PersverificatieDataOnDemand.setSrt(Persverificatie obj, int index) {
        Srtverificatie srt = srtverificatieDataOnDemand.getRandomSrtverificatie();
        obj.setSrt(srt);
    }
    
    public Persverificatie PersverificatieDataOnDemand.getSpecificPersverificatie(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Persverificatie obj = data.get(index);
        Long id = obj.getId();
        return Persverificatie.findPersverificatie(id);
    }
    
    public Persverificatie PersverificatieDataOnDemand.getRandomPersverificatie() {
        init();
        Persverificatie obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Persverificatie.findPersverificatie(id);
    }
    
    public boolean PersverificatieDataOnDemand.modifyPersverificatie(Persverificatie obj) {
        return false;
    }
    
    public void PersverificatieDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Persverificatie.findPersverificatieEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Persverificatie' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Persverificatie>();
        for (int i = 0; i < 10; i++) {
            Persverificatie obj = getNewTransientPersverificatie(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
