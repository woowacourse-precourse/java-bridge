package bridge;

import bridge.view.ExceptionMessage;
import bridge.view.OutputView;

import java.util.Arrays;

public enum UpDown {
    U(1,"U"),
    D(0,"D");

    private int choice;
    private String square;

    UpDown(int choice, String square) {
        this.choice = choice;
        this.square = square;
    }

    public static String convertsquare(int choice){
        return Arrays.stream(values())
                .filter(c -> c.choice == choice)
                .map(c -> c.square).findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.isProper));
    }
}
