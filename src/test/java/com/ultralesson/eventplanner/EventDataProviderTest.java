package com.ultralesson.eventplanner;

import com.ultralesson.eventplanner.model.Event;
import com.ultralesson.eventplanner.model.Venue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EventDataProviderTest {
    @DataProvider(name = "eventDataProvider")
    public Object[][] eventData(){
        return new Object[][]{
                {1,"Birthday Party","Saurav's 20th Birthday Party", new Venue(1, "Taj Hotel","Gateway Of India",70)},
                {2,"Freshers Party","QK Freshers Party", new Venue(1, "Cafe Leopold","Colaba, Mumbai",30)}
        };
    }

    @Test(dataProvider = "eventDataProvider")
    public void createEventTest(int id, String name, String description, Venue venue){
        Event event=new Event(id,name,description,venue);

        Assert.assertEquals(event.getId(), id);
        Assert.assertEquals(event.getName(), name);
        Assert.assertEquals(event.getVenue(), venue);
        Assert.assertEquals(event.getDescription(), description);
    }

}
