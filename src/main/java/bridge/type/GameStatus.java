package bridge.type;

import bridge.view.OutputView;

public enum GameStatus {

    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    public static String currentStatus(int size) {
        int passCount = OutputView.countPassSymbol();

        if (passCount == size) {
            return SUCCESS.message;
        }

        return FAIL.message;
    }
}
