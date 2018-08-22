package com.test.control;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWordTest {
    @Test
    public void testhello() {
        HelloWord helloWord = new HelloWord();
        String comment = helloWord.hello();
        assertEquals("success", comment);

    }
}

