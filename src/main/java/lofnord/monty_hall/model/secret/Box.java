package lofnord.monty_hall.model.secret;

import lofnord.monty_hall.model.Choice;

/**
 * Holds the state of the box.
 */
class Box {
    private final Choice choice;
    private final boolean prize;
    private boolean open;

    Box(Choice choice, boolean prize) {
        this.choice = choice;
        this.prize = prize;
    }

    /**
     * Opens the box and reveals the content
     *
     * @return true if the box has the prize;
     *          false otherwise
     *
     * @throws IllegalStateException if the box is already opened
     */
    boolean open() {
        if(this.open) {
            throw new IllegalStateException("Box is already open");
        }
        this.open = true;
        return prize;
    }

    Choice getChoice() {
        return choice;
    }

    /**
     * Sneak peak used by the {@link Host}
     */
    boolean isPrize() {
        return prize;
    }
}
