package bridge;

import static constant.Values.Message.*;

import constant.Values.BridgeCase;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println(GAME_START.getMessage());
    }

    public void printInputSize() {
        System.out.println("\n" + INPUT_SIZE.getMessage());
    }

    public void printSelectMove() {
        System.out.println("\n" + SELECT_MOVE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    public void printSelectRetry() {
        System.out.println("\n" + SELECT_RETRY.getMessage());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        printMap();
    }

    public void printGameSuccess(BridgeCase bridgeCase) {
        System.out.println("\n" + String.format(GAME_SUCCESS.getMessage(), bridgeCase.getMessage()));
    }

    public void printGameTry(int tryCount) {
        System.out.println("\n" + String.format(GAME_TRY.getMessage(), tryCount));
    }

    public void printErrorMessage(IllegalArgumentException illegalArgumentException) {
        System.out.println("\n" + String.format(ERROR_MESSAGE.getMessage(), illegalArgumentException.getMessage()));
    }

}
