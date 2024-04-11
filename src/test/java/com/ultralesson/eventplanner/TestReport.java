package com.ultralesson.eventplanner;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestReport implements ITestListener {
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Starting Test : " + result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Passed : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Failed : "+ result.getName()+", Exception : "+result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }
}
