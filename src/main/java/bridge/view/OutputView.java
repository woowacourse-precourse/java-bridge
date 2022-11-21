package bridge.view;

import static bridge.utils.constant.Constant.FAILED;
import static bridge.utils.constant.Constant.SUCCESS;
import static bridge.utils.constant.Phrase.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printGameStart() {
        System.out.println(PHRASE_START_GAME.getPhrase());
    }
    public void printBridgeSize() {
        System.out.println(PHRASE_INPUT_BRIDGE_SIZE.getPhrase());
    }

    public void printMap(String bridges) {
        System.out.println(bridges);
    }

    public void printWhereToMove() {
        System.out.println(PHRASE_WHERE_TO_MOVE.getPhrase());
    }

    public void askRestartGame() {
        System.out.println(PHRASE_RESTART_THE_GAME.getPhrase());
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String bridges) {
        System.out.println(PHRASE_RESULT_OF_THE_GAME.getPhrase());
        printMap(bridges);
    }
    public void gameAttemptCount(String result, int attempt) {
        if(result.equals(SUCCESS.getValue())) {
            System.out.println(PHRASE_GAME_SUCCESS.getPhrase());
        }
        if(result.equals(FAILED.getValue())) {
            System.out.println(PHRASE_GAME_FAILED.getPhrase());
        }
        System.out.println(PHRASE_GAME_ATTEMPT.getPhrase() + attempt);
    }

}

