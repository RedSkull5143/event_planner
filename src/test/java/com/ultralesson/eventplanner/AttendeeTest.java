package com.ultralesson.eventplanner;

import com.ultralesson.eventplanner.model.Attendee;
import com.ultralesson.eventplanner.model.Event;
import com.ultralesson.eventplanner.model.Venue;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttendeeTest {

    private Attendee attendee;

    @BeforeMethod
    public void setUp() {
        attendee = new Attendee(1, "Om", "om.shinde@gmail.com");
    }

    @AfterMethod
    public void tearDown() {
        attendee = null;
    }

    @Test(groups = {"creation", "attendeeCreation"}, priority = 1)
    public void testAttendeeCreation() {
        Assert.assertNotNull(attendee, "Attendee object should not be null.");
    }

    @Test(groups = {"validation", "attendeeValidation"})
    public void testValidateAttendeeProperties() {
        Assert.assertEquals(attendee.getId(), 1, "Attendee ID should match.");
        Assert.assertEquals(attendee.getName(), "Om", "Attendee name should match.");
        Assert.assertEquals(attendee.getEmail(), "om.shinde@gmail.com", "Attendee email should match.");
    }

    @Test(groups = {"management", "addAttendee"})
    public void testAddAttendeeToEvent() {
        Event event = new Event(1, "Test Event", "Description", new Venue(1, "Venue", "Address", 100));
        Attendee newAttendee = new Attendee(2, "New Attendee", "new.attendee@example.com");
        event.addAttendee(newAttendee);
        Assert.assertTrue(event.getAttendees().contains(newAttendee), "Attendee should be added to the event.");
    }

    @Test(groups = {"management", "addAttendee"}, expectedExceptions = IllegalArgumentException.class)
    public void testAddInvalidAttendeeToEvent() {
        Event event = new Event(1, "Test Event", "Description", new Venue(1, "Venue", "Address", 100));
        Attendee invalidAttendee = new Attendee(3, null, ""); // Invalid attendee details
        event.addAttendee(invalidAttendee);
    }

    @Test(groups = {"management", "removeAttendee"})
    public void testRemoveAttendeeFromEvent() {
        Event event = new Event(1, "Test Event", "Description", new Venue(1, "Venue", "Address", 100));
        Attendee attendeeToRemove = new Attendee(2, "Jane Doe", "jane.doe@example.com");
        event.addAttendee(attendeeToRemove);
        event.removeAttendee(attendeeToRemove);
        Assert.assertFalse(event.getAttendees().contains(attendeeToRemove), "Attendee should be removed from the event.");
    }

    @Test(groups = {"management", "addAttendee"})
    public void testAddAttendeeToFullCapacityEvent() {
        Event event = new Event(1, "Full Capacity Event", "Description", new Venue(1, "Venue", "Address", 1));
        Attendee newAttendee = new Attendee(2, "New Attendee", "new.attendee@example.com");
        event.addAttendee(newAttendee);
        Assert.assertTrue(event.getAttendees().contains(newAttendee), "Attendee should be added to the event even if it's at full capacity.");
    }

    @Test(groups = {"management", "addAttendee"})
    public void testAddAttendeeToNullEvent() {
        Event event = null;
        Attendee newAttendee = new Attendee(1, "Om Shinde", "om.shinde@gmail.com");
        try {
            event.addAttendee(newAttendee);
            Assert.fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            Assert.assertNull(event, "Event should remain null.");
        }
    }

    @Test(groups = {"management", "removeAttendee"})
    public void testRemoveNonExistingAttendeeFromEvent() {
        Event event = new Event(1, "Test Event", "Description", new Venue(1, "Venue", "Address", 100));
        Attendee nonExistingAttendee = new Attendee(999, "Non Existing Attendee", "nonexisting@example.com");
        event.removeAttendee(nonExistingAttendee);
        Assert.assertFalse(event.getAttendees().contains(nonExistingAttendee), "Removing non-existing attendee should not affect the attendee list.");
    }

    @Test(groups = {"management", "addAttendee"})
    public void testAddAttendeeToEventSuccess() {
        Event event = new Event(1, "Conference", "Tech Conference", new Venue(1, "Conference Hall", "City Center", 100));
        Attendee newAttendee = new Attendee(10, "Alice Bryant", "alice.bryant@example.com");
        event.addAttendee(newAttendee);
        Assert.assertTrue(event.getAttendees().contains(newAttendee), "The attendee should be added to the event attendee list.");
    }

    @Test(groups = {"management", "addAttendee"}, expectedExceptions = IllegalArgumentException.class)
    public void testAddAttendeeWithInvalidDetailsToEvent() {
        Event event = new Event(2, "Workshop", "Coding Workshop", new Venue(2, "Workshop Space", "Tech Park", 50));
        Attendee invalidAttendee = new Attendee(11, null, "invalid@example.com"); // Invalid attendee details
        event.addAttendee(invalidAttendee);
    }

}
