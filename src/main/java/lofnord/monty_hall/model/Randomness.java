package lofnord.monty_hall.model;

import java.security.SecureRandom;
import java.util.EnumSet;

public class Randomness {

    private static final SecureRandom RANDOM = new SecureRandom();

    private final Choice[] choices;

    public Randomness() {
        this(EnumSet.allOf(Choice.class));
    }

    Randomness(EnumSet<Choice> choices) {
        this.choices = choices.toArray(new Choice[choices.size()]);
    }

    public Choice pick() {
        return choices[RANDOM.nextInt(choices.length)];
    }
}
