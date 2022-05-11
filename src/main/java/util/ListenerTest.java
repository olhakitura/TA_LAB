package util;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListenerTest implements ITestListener{

        final static Logger logger = LoggerFactory.getLogger(String.valueOf(ListenerTest.class));

        @Override
        public void onFinish(ITestContext Result) { System.out.println("The name of the testcase finished is :"+Result.getName()); }

        @Override
        public void onStart(ITestContext Result) { System.out.println("The name of the testcase started is :"+Result.getName()); }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult Result) { System.out.println("The name of the testcase failed But within Success Percentage is :"+Result.getName()); }

        @Override
        public void onTestFailure(ITestResult Result) { System.out.println("The name of the testcase failed is :"+Result.getName()); }

        @Override
        public void onTestSkipped(ITestResult Result) { System.out.println("The name of the testcase Skipped is :"+Result.getName()); }

        @Override
        public void onTestStart(ITestResult Result)
        {
            System.out.println(Result.getName()+" test case started");
        }

        @Override
        public void onTestSuccess(ITestResult Result) { System.out.println("The name of the testcase passed is :"+Result.getName()); }

    }

