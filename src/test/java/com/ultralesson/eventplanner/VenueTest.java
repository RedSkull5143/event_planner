package com.ultralesson.eventplanner;

import com.ultralesson.eventplanner.exceptions.VenueException;
import com.ultralesson.eventplanner.model.Event;
import com.ultralesson.eventplanner.model.Venue;
import com.ultralesson.eventplanner.service.EventPlanner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VenueTest {
//    private Venue venue;
//    private Event event;
//    private EventPlanner ep=new EventPlanner();


    @Test(groups = {"creation","venueCreation"}, priority = 3, testName = "test venue Creation",description = "")
    public void testVenueCreation(){
        Venue venue;
        Event event;
        venue=new Venue(1,"Hotel Trident","Marine Lines, Mumbai",70);
        Assert.assertNotNull(venue,"Venue Creation Failed");
        System.out.println("3");
    }
    @Test
    public void testVenueProperties(){
        Venue venue;
        Event event;
        venue=new Venue(1,"Hotel Trident","Marine Lines, Mumbai",70);
        Assert.assertEquals(venue.getId(),1);
        Assert.assertEquals(venue.getName(),"Hotel Trident");
        Assert.assertEquals(venue.getAddress(),"Marine Lines, Mumbai");
        Assert.assertEquals(venue.getCapacity(),70);
    }
    @Test(testName = "throwExceptionForNegativeCapacity",description = "it should throw an exception when negative capacity is entered",expectedExceptions = VenueException.class)
    public void throwExceptionForNegativeCapacity(){
        Venue venue;
        Event event;
        venue=new Venue(1,"Om Shinde","Marine Lines, Mumbai",-80);
    }

    @Test(description = "Test case for assigning venue to events and verifying")
    public void testVenuetoEvent(){
        Venue venue;
        Event event;
        event=new Event(1,"Freshers","Party for new Joineers",null);
        venue=new Venue(1,"Hotel Trident","Marine Lines, Mumbai",70);
        event.setVenue(venue);
        Assert.assertEquals(event.getVenue(), venue, "Venue should be assigned correctly");
    }

    @Test(description = "Add venue to event-planner")
    public void testAddVenue(){
        EventPlanner ep=new EventPlanner();
        Venue venue;
        Event event;
        venue=new Venue(1,"Hotel Trident","Marine Lines, Mumbai",70);
        ep.addVenue(venue);
        Assert.assertTrue(ep.getVenues().contains(venue));
    }

    @Test(description = "update venue details")
    public void testUpdateVenue(){
        EventPlanner ep=new EventPlanner();
        Venue venue1=new Venue(1, "Leopold Cafe","Marine Lines",80);
        ep.addVenue(venue1);
//        System.out.println(ep.getVenues().get(0));
        venue1.setAddress("Colaba, Mumbai");
        ep.addVenue(venue1);
//        System.out.println(ep.getVenues().get(0));
        Assert.assertEquals(ep.getVenues().get(0),venue1);
    }

    @Test(description = "remove venue")
    public void testRemoveVenue(){
        EventPlanner eventPlanner=new EventPlanner();
        Venue venue=new Venue(1,"Taj", "Gateway of India",300);
        eventPlanner.addVenue(venue);
        eventPlanner.removeVenue(1);
//        Assert.assertNull(eventPlanner); // returns the instance of event planner
        Assert.assertFalse(eventPlanner.getVenues().contains(venue));
//        System.out.println(eventPlanner.getVenues());
    }

}