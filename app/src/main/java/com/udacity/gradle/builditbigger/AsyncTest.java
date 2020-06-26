package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.content.pm.InstrumentationInfo;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
@RunWith(JUnit4ClassRunner.class)
public class AsyncTest extends TestCase {




        private CountDownLatch mSignal;
        private String joke;
        private Context mConext;
        private EndpointsAsyncTask mEndpointsAsysTask;
        private Intent mIntent;
        private String checkBackGround;
        private static final String TAG  =  EndpointsAsyncTask.class.getSimpleName();



        @Before
        public void setUp() {

            //lets get a context
           // mConext = InstrumentationInfo.getInstrumentation().getTargetContext();

           // assertNotNull(mConext);

            checkBackGround = null;

            //Reference Endpoint Task
            mEndpointsAsysTask = new EndpointsAsyncTask();
            assertNotNull(mEndpointsAsysTask);

            //Set Countdown
            mSignal = new CountDownLatch(1);
        }

        @Test
        public void PostExecute(){
            Intent mIntent = new Intent( mConext, MainActivity.class);
            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mIntent.putExtra("joke", "testing again");
            assertNotNull(mIntent);
        }

        @Test
        public void doInBackground() {

            checkBackGround = new EndpointsAsyncTask().doInBackground();
            assertNotNull(checkBackGround);
        }

        @Test
        public void endPointAsyncTask() throws InterruptedException {

            String jokeR = null;

            try {
                mSignal = new CountDownLatch(2);

                jokeR = mIntent.getStringExtra("JOKE");
                mSignal.await(8, TimeUnit.SECONDS);
                assertNotSame(mIntent.getStringExtra("JOKE"), jokeR);
                assertNotNull("Empty String Return", jokeR);

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

        @Test
        public void testPostAsyncAfterResponse(){

           EndpointsAsyncTask postEndpointsAsyncTask = new EndpointsAsyncTask() {

                @Override
                public void onPostExecute(String result) {
                    assertNotNull(result);
                    assertTrue(result.length() > 0);
                    mSignal.countDown();
                }
            };

            postEndpointsAsyncTask.execute();
            try {
                mSignal.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
