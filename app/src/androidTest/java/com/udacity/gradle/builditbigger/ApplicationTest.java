package com.udacity.gradle.builditbigger;

import android.app.Application;

import android.test.ApplicationTestCase;
import android.text.TextUtils;
import android.util.Log;


import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;


/**
 * Created by manvi on 24/4/17.
 */
public class ApplicationTest extends ApplicationTestCase<Application>{

    String mResult = "";

    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void testAlbumGetTask() throws InterruptedException {

        EndpointsAsyncTask task = new EndpointsAsyncTask();
        try {
            mResult = task.execute(this.getContext()).get();
        }catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        Log.i("AppTest",mResult);
        assertNotNull("Joke Not Found", mResult);
        assertFalse(TextUtils.isEmpty(mResult));
    }
}