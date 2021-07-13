package ch03.src.main;

import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
// ...

public class AssertHamcrestTest {
    @Test
    @Ignore
    public void assertDoublesEqual() {
        assertThat(2.32 * 3, equalTo(6.96));
    }

    @Test
    public void assertWithTolerance() {
        assertTrue(Math.abs((2.32 * 3) - 6.96) < 0.0005);
    }

}