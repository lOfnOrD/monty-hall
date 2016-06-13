package lofnord.monty_hall.model.secret;


import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lofnord.monty_hall.model.Choice;
import lofnord.monty_hall.model.Randomness;

/**
 * The host holds all knowledge of the boxes.
 */
public class Host {

    private final Map<Choice, Box> boxes;

    /**
     * Production constructor.
     * Picks a box at random to contain the prize.
     */
    public Host() {
        this(new Randomness().pick());
    }

    /**
     * Testable constructor
     *
     * @param hideThePrizeHere specify which box contains the prize
     */
    Host(final Choice hideThePrizeHere) {
        this.boxes = EnumSet.allOf(Choice.class)
                            .stream()
                            .map(choice -> new Box(choice,
                                                   choice.equals(hideThePrizeHere)))
                            .collect(Collectors.toMap(Box::getChoice,
                                                      Function.identity()));
    }


    /**
     * @param firstChoice the first choice of the player
     * @return the remaining choice offered to the player
     */
    public Choice pickFirst(Choice firstChoice) {
        EnumSet<Choice> remaining = EnumSet.complementOf(EnumSet.of(firstChoice));

        Choice emptyChoice = remaining.parallelStream()
                                      .filter(choice -> !boxes.get(choice).isPrize())
                                      .findAny()
                                      .orElseThrow(() -> new IllegalStateException("No remaining empty choices"));

        Box emptyBox = boxes.get(emptyChoice);
        emptyBox.open();

        return EnumSet.complementOf(EnumSet.of(firstChoice, emptyChoice))
                      .stream()
                      .findFirst()
                      .orElseThrow(() -> new IllegalStateException("No remaining choice to offer"));
    }

    /**
     * @param secondChoice the second choice of the player
     * @return the prize, if the choice is right
     */
    public boolean pickSecond(Choice secondChoice) {
        Box closedBox = boxes.get(secondChoice);
        return closedBox.open();
    }
}
