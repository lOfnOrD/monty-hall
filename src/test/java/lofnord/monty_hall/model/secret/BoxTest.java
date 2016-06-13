package lofnord.monty_hall.model.secret;

import lofnord.monty_hall.model.Choice;
import org.junit.Test;
import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BoxTest {
    @Test
    public void open_withMoney() throws Exception {

        boolean actual = new Box(Choice.NUMBER_1, true).open();

        assertThat(actual, is(true));
    }

    @Test
    public void open_noMoney() throws Exception {

        boolean actual = new Box(Choice.NUMBER_2, false).open();

        assertThat(actual, is(false));
    }

    @Test(expected = IllegalStateException.class)
    public void open_twice() throws Exception {

        Box box = new Box(Choice.NUMBER_3, false);
        try {
            box.open();
        } catch (Exception e) {
            fail("should not throw yet");
        }

        //SUT
        box.open();
    }

    @Test
    public void getChoice_forCoverage() throws Exception {
        Choice expected = Choice.NUMBER_3;
        Box box = new Box(expected, false);

        //SUT
        Choice actual = box.getChoice();

        assertThat(actual, is(expected));
    }
}