package bridge.view;

import static bridge.Constants.ATTEMPTS_NUMBER;
import static bridge.Constants.COMPLETE_OR_NOT;
import static bridge.Constants.FINAL_MESSAGE;

import bridge.domain.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final BridgeGame bridgeGame;

    public OutputView(final BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap() {
        for (String bridgeMessage : bridgeGame.makeBridgeMessage()) {
            System.out.println(bridgeMessage);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult() {
        System.out.println(FINAL_MESSAGE);
        printMap();
        System.out.println(COMPLETE_OR_NOT + bridgeGame.makeResultOfCompletionMessage());
        System.out.println(ATTEMPTS_NUMBER + bridgeGame.getRetryNumber());
    }
}
