package bridge.model;

import bridge.util.Rules;

import java.text.DecimalFormat;

public enum Plate {
    UP_PLATE("U", Rules.PLATE_UP_PLATE),
    DOWN_PLATE("D", Rules.PLATE_DOWN_PLATE);

    private String symbol;
    private int randomNumber;

    Plate(String symbol, int randomNumber) {
        this.symbol = symbol;
        this.randomNumber = randomNumber;
    }
}
