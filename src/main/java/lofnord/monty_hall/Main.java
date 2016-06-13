package lofnord.monty_hall;

import java.util.stream.IntStream;
import lofnord.monty_hall.model.Game;
import lofnord.monty_hall.model.Strategy;

public class Main {
    private static final int NUMBER_OF_GAMES = 1000;

    public static void main(String[] args) {
        playAllStrategies(NUMBER_OF_GAMES);
    }

    static void playAllStrategies(int numberOfGames) {
        System.out.println("Playing " + numberOfGames + " games per strategy...");
        for (Strategy strategy : Strategy.values()) {
            long wins = IntStream.range(0, numberOfGames)
                                 .parallel()
                                 .mapToObj(operand -> new Game().play(strategy))
                                 .filter(Boolean::booleanValue)
                                 .count();
            double winPercentage = (double) wins * 100d / (double) numberOfGames;
            System.out.println("Strategy " + strategy.name() + " won " + wins + " times: " + winPercentage + "%");
        }
    }
}
