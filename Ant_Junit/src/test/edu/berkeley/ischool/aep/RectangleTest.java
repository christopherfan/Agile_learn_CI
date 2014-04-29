package edu.berkeley.ischool.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RectangleTest {

@Test
public void shouldReturnAreaOfTwentyFiveForFiveByFiveRectangle () {
    Rectangle rectangle = new Rectangle(5, 5);
    assertEquals(25, rectangle.area());
}

}
