package lofnord.monty_hall.model.secret;

import lofnord.monty_hall.model.Choice;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

public class HostTest {

    @Test
    public void pickFirst_playerPicksPrizeBox() throws Exception {
        Choice prizeBox = Choice.NUMBER_2;
        Host host = new Host(prizeBox);

        //SUT
        Choice actual = host.pickFirst(prizeBox);

        assertThat(actual, not(nullValue()));
        assertThat(actual, not(prizeBox));
    }

    @Test
    public void pickFirst_playerPicksLoserBox() throws Exception {
        Choice prizeBox = Choice.NUMBER_3;
        Host host = new Host(prizeBox);

        //SUT
        Choice actual = host.pickFirst(Choice.NUMBER_1);

        assertThat(actual, is(prizeBox));
    }

    @Test
    public void pickSecond_playerPicksPrizeBox_stays() throws Exception {
        Choice prizeBox = Choice.NUMBER_1;
        Host host = new Host(prizeBox);
        host.pickFirst(prizeBox);

        //SUT
        boolean actual = host.pickSecond(prizeBox);

        assertThat(actual, is(true));
    }

    @Test
    public void pickSecond_playerPicksPrizeBox_switches() throws Exception {
        Choice prizeBox = Choice.NUMBER_3;
        Host host = new Host(prizeBox);
        Choice offered = host.pickFirst(prizeBox);

        //SUT
        boolean actual = host.pickSecond(offered);

        assertThat(actual, is(false));
    }

    @Test
    public void pickSecond_playerPicksLoserBox_stays() throws Exception {
        Choice prizeBox = Choice.NUMBER_2;
        Choice loserBox = Choice.NUMBER_1;
        Host host = new Host(prizeBox);
        host.pickFirst(loserBox);

        //SUT
        boolean actual = host.pickSecond(loserBox);

        assertThat(actual, is(false));
    }

    @Test
    public void pickSecond_playerPicksLoserBox_switches() throws Exception {
        Choice prizeBox = Choice.NUMBER_1;
        Host host = new Host(prizeBox);
        host.pickFirst(Choice.NUMBER_2);

        //SUT
        boolean actual = host.pickSecond(prizeBox);

        assertThat(actual, is(true));
    }
}