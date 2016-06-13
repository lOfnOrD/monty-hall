package lofnord.monty_hall.model;

import java.util.EnumSet;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

public class RandomnessTest {

    @Test
    public void pick_fromAll() throws Exception {
        Choice actual = new Randomness().pick();

        assertThat(actual, not(nullValue()));
    }

    @Test
    public void pick_fromOne() throws Exception {
        for (Choice expected : Choice.values()) {
            //SUT
            Choice actual = new Randomness(EnumSet.of(expected)).pick();

            assertThat(actual, is(expected));
        }
    }
}