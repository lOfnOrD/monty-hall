package lofnord.monty_hall;

import java.util.stream.IntStream;
import lofnord.monty_hall.model.Game;
import lofnord.monty_hall.model.Strategy;

public class Main {
    private static final int NUMBER_OF_GAMES = 1000;

    public static void main(String[] args) {
        System.out.println("Playing " + NUMBER_OF_GAMES + " games per strategy...");
        for (Strategy strategy : Strategy.values()) {
            long wins = IntStream.range(0, NUMBER_OF_GAMES)
                                 .parallel()
                                 .mapToObj(operand -> new Game().play(strategy))
                                 .filter(Boolean::booleanValue)
                                 .count();
            double winPercentage = (double) wins * 100d / (double) NUMBER_OF_GAMES;
            System.out.println("Strategy " + strategy.name() + " won " + wins + " times: " + winPercentage + "%");
        }
    }
}
