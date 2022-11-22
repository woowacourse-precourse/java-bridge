package bridge.util;

import bridge.view.ExceptionMessage;

import java.util.Arrays;

public enum BridgeSquare {
    U(1,"U"),
    D(0,"D");

    private int choice;
    private String square;

    BridgeSquare(int choice, String square) {
        this.choice = choice;
        this.square = square;
    }

    public static String convertSquare(int choice){
        return Arrays.stream(values())
                .filter(c -> c.choice == choice)
                .map(c -> c.square).findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.isProperMsg()));
    }
}
