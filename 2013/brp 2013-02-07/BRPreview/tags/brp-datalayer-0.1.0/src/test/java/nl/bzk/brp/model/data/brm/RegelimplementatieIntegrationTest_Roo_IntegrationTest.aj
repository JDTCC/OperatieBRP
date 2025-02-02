// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.brm;

import java.util.List;
import nl.bzk.brp.model.data.brm.Regelimplementatie;
import nl.bzk.brp.model.data.brm.RegelimplementatieDataOnDemand;
import nl.bzk.brp.model.data.brm.RegelimplementatieIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect RegelimplementatieIntegrationTest_Roo_IntegrationTest {
    
    declare @type: RegelimplementatieIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: RegelimplementatieIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: RegelimplementatieIntegrationTest: @Transactional;
    
    @Autowired
    private RegelimplementatieDataOnDemand RegelimplementatieIntegrationTest.dod;
    
    @Test
    public void RegelimplementatieIntegrationTest.testCountRegelimplementaties() {
        Assert.assertNotNull("Data on demand for 'Regelimplementatie' failed to initialize correctly", dod.getRandomRegelimplementatie());
        long count = Regelimplementatie.countRegelimplementaties();
        Assert.assertTrue("Counter for 'Regelimplementatie' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void RegelimplementatieIntegrationTest.testFindRegelimplementatie() {
        Regelimplementatie obj = dod.getRandomRegelimplementatie();
        Assert.assertNotNull("Data on demand for 'Regelimplementatie' failed to initialize correctly", obj);
        Integer id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Regelimplementatie' failed to provide an identifier", id);
        obj = Regelimplementatie.findRegelimplementatie(id);
        Assert.assertNotNull("Find method for 'Regelimplementatie' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Regelimplementatie' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void RegelimplementatieIntegrationTest.testFindAllRegelimplementaties() {
        Assert.assertNotNull("Data on demand for 'Regelimplementatie' failed to initialize correctly", dod.getRandomRegelimplementatie());
        long count = Regelimplementatie.countRegelimplementaties();
        Assert.assertTrue("Too expensive to perform a find all test for 'Regelimplementatie', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Regelimplementatie> result = Regelimplementatie.findAllRegelimplementaties();
        Assert.assertNotNull("Find all method for 'Regelimplementatie' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Regelimplementatie' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void RegelimplementatieIntegrationTest.testFindRegelimplementatieEntries() {
        Assert.assertNotNull("Data on demand for 'Regelimplementatie' failed to initialize correctly", dod.getRandomRegelimplementatie());
        long count = Regelimplementatie.countRegelimplementaties();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Regelimplementatie> result = Regelimplementatie.findRegelimplementatieEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Regelimplementatie' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Regelimplementatie' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void RegelimplementatieIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Regelimplementatie' failed to initialize correctly", dod.getRandomRegelimplementatie());
        Regelimplementatie obj = dod.getNewTransientRegelimplementatie(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Regelimplementatie' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Regelimplementatie' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Regelimplementatie' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void RegelimplementatieIntegrationTest.testRemove() {
        Regelimplementatie obj = dod.getRandomRegelimplementatie();
        Assert.assertNotNull("Data on demand for 'Regelimplementatie' failed to initialize correctly", obj);
        Integer id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Regelimplementatie' failed to provide an identifier", id);
        obj = Regelimplementatie.findRegelimplementatie(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Regelimplementatie' with identifier '" + id + "'", Regelimplementatie.findRegelimplementatie(id));
    }
    
}
