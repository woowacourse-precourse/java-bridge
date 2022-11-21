package bridge.view;

import static bridge.enums.IntEnum.GAME_LOSE;
import static bridge.enums.IntEnum.GAME_WIN;
import static bridge.enums.StringEnum.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(String nowStageMap) {
        System.out.println(nowStageMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int result, int total, String resultStage) {
        System.out.println(GAME_FINAL.key());
        printMap(resultStage);
        successGamePrint(result);
        challengeTotal(total);
    }

    public void successGamePrint(int result) {
        if (result == GAME_WIN.num()) {
            System.out.println(SUCCESS_GAME.key() + "성공");
        }
        if (result == GAME_LOSE.num()) {
            System.out.println(SUCCESS_GAME.key() + "실패");
        }
    }

    public void challengeTotal(int total) {
        System.out.println(CHALLENGE.key() + String.valueOf(total));
    }

    public void printGameStart() {
        System.out.println(GAME_START.key());
    }

    public void printAskMoving() {
        System.out.println(ASK_MOVING.key());
    }

    public void printAskCommand() {
        System.out.println(ASK_COMMAND.key());
    }

    public void printAskLength() {
        System.out.println(ASK_BRIDGE_LENGTH.key());
    }

}
