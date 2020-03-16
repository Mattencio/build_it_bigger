package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;

@RunWith(AndroidJUnit4.class)
public class GetJokeGceTest {

    @Test
    public void getJokeFromGce() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new EndpointsAsyncTask().execute(joke -> {
            assertNotNull(joke);
            assertThat(joke, not(isEmptyString()));
            countDownLatch.countDown();
        });
        countDownLatch.await();
    }
}
