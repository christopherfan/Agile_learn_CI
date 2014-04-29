package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ReverserTest {

    @Test
    public void shouldReverseStringWithSingleChar () {
        assertEquals("e", Reverser.reverse("e"));
    }

    @Test
    public void shouldReverseString() {
        assertEquals("esreveR", Reverser.reverse("Reverse"));
    }
}
