package com.ultralesson.eventplanner;

import com.ultralesson.eventplanner.model.Attendee;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttendeeTest {

    private Attendee attendee;
    @BeforeMethod
    public void setUp(){
        attendee=new Attendee(1,"Om","om.shinde@gmail.com");
        System.out.println("1");
    }
    @AfterMethod
    public void emptyObject(){
        attendee=null;
        System.out.println("3");
    }
    @Test(groups = {"creation","attendeeCreation"}, priority = 2)
    public void testAttendeeCreation(){
        attendee=new Attendee(1,"Om","om.shinde@gmail.com");
        Assert.assertNotNull(attendee,"No Attendees Present");
        System.out.println("2");
    }
    @Test
    public void testValidateAttendeeProperties(){
        attendee=new Attendee(1,"Om Shinde","om@gmail.com");
        Assert.assertEquals(attendee.getId(), 1);
        Assert.assertEquals(attendee.getName(), "Om Shinde");
        Assert.assertEquals(attendee.getEmail(), "om@gmail.com");
    }
}

//The @BeforeMethod annotation is used to mark a method that needs to be executed before each test method.
//The @AfterMethod annotation signifies that the marked method should be executed after each test method.
//the best thing to go after the code