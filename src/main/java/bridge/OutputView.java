package bridge;

import bridge.constant.Game;

import java.util.List;

public class OutputView {
    public void printMap(List<List<String>> result) {
        result.forEach(this::printEachFloor);
        System.out.println();
    }

    private void printEachFloor(List<String> result) {
        String str = String.join(" | ", result);
        System.out.println("[ " + str + " ]");
    }

    public void printResult() {
        System.out.println(Game.GAME_RESULT_MESSAGE);
    }

    public void printRetry() {
        System.out.println(Game.INPUT_RETRY);
    }

    public void printStart() {
        System.out.println(Game.START_GAME_MESSAGE);
    }

    public void printSuccess(boolean success) {
        if (success) {
            System.out.println(Game.GAME_SUCCESS);
            return;
        }
        System.out.println(Game.GAME_FAILED);
    }

    public void printAttempts(int attempts) {
        System.out.println(Game.TOTAL_NUMBER_OF_ATTEMPTS + attempts);
    }
}
