package bridge.domain;

public enum GameTurn {
    MOVE, RESULT_CHECK, QUIT;

    public static GameTurn nextTurn(GameTurn gameTurn) {
        if (gameTurn == GameTurn.MOVE) {
            return GameTurn.RESULT_CHECK;
        }
        if (gameTurn == GameTurn.RESULT_CHECK) {
            return GameTurn.MOVE;
        }
        throw new IllegalArgumentException("변환할 수 없는 GameTurn 값이 입력되었습니다.");
    }
}
