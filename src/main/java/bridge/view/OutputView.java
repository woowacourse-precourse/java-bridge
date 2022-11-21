package bridge.view;

import bridge.domain.game.Result;

import java.util.List;

import static bridge.common.Constants.BRIDGE_LENGTH;
import static bridge.view.Message.*;

public class OutputView {

    private OutputView() {}

    public static OutputView getInstance() {
        return OutputView.LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final OutputView instance = new OutputView();
    }

    public void printMap(List<List<String>> map) {
        for (int i = 0; i < BRIDGE_LENGTH; i++) {
            System.out.print(BRIDGE_START.getText());
            System.out.print(String.join(BRIDGE_DELIMITER.getText(), map.get(i)));
            System.out.println(BRIDGE_END.getText());
        }
    }

    public void printResultMap(List<List<String>> map) {
        System.out.println(GAME_RESULT.getText());
        printMap(map);
    }

    public void printResult(int count, boolean isSuccess) {
        System.out.println();
        System.out.println(String.format(GAME_SUCCESS.getText(), Result.of(isSuccess).getMessage()));
        System.out.println(String.format(GAME_TRY_COUNT.getText(), count));
    }

    public void printStart() {
        System.out.println(GAME_START.getText());
        System.out.println();
        System.out.println(INPUT_BRIDGE_SIZE.getText());
    }

    public void printMoving() {
        System.out.println();
        System.out.println(INPUT_MOVING.getText());
    }

    public void printRetry() {
        System.out.println();
        System.out.println(INPUT_RETRY.getText());
    }
}
