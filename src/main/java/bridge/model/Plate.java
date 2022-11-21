package bridge.model;

import bridge.util.Rules;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Plate {
    UP_PLATE("U", Rules.PLATE_UP_PLATE),
    DOWN_PLATE("D", Rules.PLATE_DOWN_PLATE);

    private final static Map<String, Plate> BY_SYMBOL = Stream.of(values())
            .collect(Collectors.toMap(Plate::getSymbol, Function.identity()));

    private final static Map<Integer, Plate> BY_RANDOM_NUMBER = Stream.of(values())
            .collect(Collectors.toMap(Plate::getRandomNumber, Function.identity()));

    private final String symbol;
    private final int randomNumber;

    Plate(String symbol, int randomNumber) {
        this.symbol = symbol;
        this.randomNumber = randomNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static Plate findBySymbol(String symbol) {
        return BY_SYMBOL.get(symbol);
    }

    public static Plate findByRandomNumber(int randomNumber) {
        return BY_RANDOM_NUMBER.get(randomNumber);
    }
}
