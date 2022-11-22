package bridge.model;

import bridge.util.Rules;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Tile {
    UP_TILE("U", Rules.TILE_UP_TILE),
    DOWN_TILE("D", Rules.TILE_DOWN_TILE);

    private final static Map<String, Tile> BY_SYMBOL = Stream.of(values())
            .collect(Collectors.toMap(Tile::getSymbol, Function.identity()));

    private final static Map<Integer, Tile> BY_RANDOM_NUMBER = Stream.of(values())
            .collect(Collectors.toMap(Tile::getRandomNumber, Function.identity()));

    private final String symbol;
    private final int randomNumber;

    Tile(String symbol, int randomNumber) {
        this.symbol = symbol;
        this.randomNumber = randomNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static Tile findBySymbol(String symbol) {
        return BY_SYMBOL.get(symbol);
    }

    public static Tile findByRandomNumber(int randomNumber) {
        return BY_RANDOM_NUMBER.get(randomNumber);
    }
}
