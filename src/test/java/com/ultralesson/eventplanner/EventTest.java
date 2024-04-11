package com.ultralesson.eventplanner;

import com.ultralesson.eventplanner.model.Event;
import com.ultralesson.eventplanner.model.Venue;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class EventTest {
    @BeforeClass
    public void setUpClass(){
        System.out.println("Setting up Resources");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("Release Resources");
    }
    @Test(groups = {"creation","eventCreation"}, priority = 1,testName = "test event creation",description = " ",timeOut = 500)
    public void testEventCreation() throws InterruptedException {
        Thread.sleep(200);
        Venue venue=new Venue(1,"Hotel Trident","Marine Line, Mumbai",70);
        Event event=new Event(1,"Freshers","Party for new Joineers",venue);
        Assert.assertNotNull(event,"Event Creation Failed");
        System.out.println("1");
    }
    @Test
    public void testEventProperties(){
        Venue venue=new Venue(1,"Hotel Trident","Marine Line, Mumbai",70);
        Event event=new Event(1,"Freshers","Party for new Joineers",venue);
        Assert.assertEquals(event.getName(),"Freshers");
        Assert.assertEquals(event.getVenue(),venue);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullEventName() {
        Venue dummyVenue = new Venue(1, "Test Venue", "123 Test Street", 100);
        Event testEvent = new Event(1, null, "Test Event", dummyVenue);
    }

}
