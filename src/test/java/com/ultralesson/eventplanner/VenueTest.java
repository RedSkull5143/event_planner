package com.ultralesson.eventplanner;

import com.ultralesson.eventplanner.exceptions.VenueException;
import com.ultralesson.eventplanner.model.Venue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VenueTest {
    private Venue venue;
    @Test(groups = {"creation","venueCreation"}, priority = 3, testName = "test venue Creation",description = "")
    public void testVenueCreation(){
        venue=new Venue(1,"Hotel Trident","Marine Lines, Mumbai",70);
        Assert.assertNotNull(venue,"Venue Creation Failed");
        System.out.println("3");
    }
    @Test
    public void testVenueProperties(){
        venue=new Venue(1,"Hotel Trident","Marine Lines, Mumbai",70);
        Assert.assertEquals(venue.getId(),1);
        Assert.assertEquals(venue.getName(),"Hotel Trident");
        Assert.assertEquals(venue.getAddress(),"Marine Lines, Mumbai");
        Assert.assertEquals(venue.getCapacity(),70);
    }
    @Test(testName = "throwExceptionForNegativeCapacity",description = "it should throw an exception when negative capacity is entered",expectedExceptions = VenueException.class)
    public void throwExceptionForNegativeCapacity(){
        venue=new Venue(1,"Om Shinde","Marine Lines, Mumbai",-80);
    }
}