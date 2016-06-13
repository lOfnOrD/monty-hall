package lofnord.monty_hall.model;

import lofnord.monty_hall.model.secret.Host;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    @Test
    public void play_rigged_win() throws Exception {
        Host host = mockHost(true);

        //SUT
        boolean actual = new Game(host).play(Strategy.KEEP);

        assertThat(actual, is(true));
    }

    @Test
    public void play_rigged_loss() throws Exception {
        Host host = mockHost(false);

        //SUT
        boolean actual = new Game(host).play(Strategy.SWITCH);

        assertThat(actual, is(false));
    }

    private Host mockHost(boolean win) {
        Host host = mock(Host.class);
        when(host.pickSecond(any())).thenReturn(win);
        return host;
    }
}