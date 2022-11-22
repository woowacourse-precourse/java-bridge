package bridge.view;

import bridge.data.Game;
import bridge.data.Moving;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 시 필요한 메세지를 출력한다.
     */
    public void printStartMessage() {
        System.out.println(Game.GAME_START_MESSAGE.getMessage());
        System.out.println(Game.BRIDGE_LENGTH_INPUT_MESSAGE.getMessage());
    }

    /**
     * 인자로 주어지는 메세지를 출력한다.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage() {
        System.out.println();
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> map) {
        List<String> upLine = map.get(Moving.UP.ordinal());
        List<String> downLine = map.get(Moving.DOWN.ordinal());
        printOneLineMap(upLine);
        printOneLineMap(downLine);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> map, boolean success, int tryCount) {
        System.out.println(Game.FINAL_GAME_RESULT.getMessage());
        printMap(map);
        printSuccess(success);
        System.out.println(Game.TOTAL_TRY.getMessage() + tryCount);
    }

    private void printOneLineMap(List<String> line) {
        System.out.print("[");
        for (int i = 0; i < line.size(); i++) {
            System.out.print(line.get(i));
            if (i == line.size() - 1) {
                break;
            }
            System.out.print("|");
        }
        System.out.println("]");
    }

    private void printSuccess(boolean success) {
        System.out.print(Game.GAME_SUCCESS_OR_FAIL.getMessage());
        if (success) {
            System.out.println(Game.SUCCESS.getMessage());
            return;
        }
        System.out.println(Game.FAIL.getMessage());
    }
}
