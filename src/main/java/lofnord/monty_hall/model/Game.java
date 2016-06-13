package lofnord.monty_hall.model;


import lofnord.monty_hall.model.secret.Host;

public class Game {

    private final Host host;

    public Game() {
        this(new Host());
    }

    /**
     * Testable constructor
     *
     * @param host the host, with knowledge of the boxes
     */
    Game(Host host) {
        this.host = host;
    }

    /**
     * Plays a single game
     *
     * @param strategy the strategy to use
     * @return true if the player wins; false otherwise
     */
    public boolean play(Strategy strategy) {
        Choice first = new Randomness().pick();

        Choice switchTo = host.pickFirst(first);

        switch (strategy) {
            case SWITCH:
                return host.pickSecond(switchTo);
            case KEEP:
            default:
                return host.pickSecond(first);
        }
    }
}
