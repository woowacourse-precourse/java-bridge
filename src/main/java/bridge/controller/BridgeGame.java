package bridge.controller;

import bridge.model.AnswerBridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.User;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGame {

    User user = new User();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        OutputView.printStart();
        int bridgeSize = InputView.getInputBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        AnswerBridge answerBridge = new AnswerBridge(bridge);

        while(true) {
            String choice = InputView.getInputChoice();
            user.addChoice(choice);
            OutputView.printMap(user.getChoices(), answerBridge.compareTo(user));

            if (!answerBridge.isCorrect(choice, user.getStep())) {
                boolean doesRetry;
                try {
                    doesRetry = retry();
                } catch (IllegalArgumentException illegalArgumentException) {
                    doesRetry = retry();
                }

                if (doesRetry) {
                    resetGame();
                    continue;
                }
                break;
            }

            if (answerBridge.isApproachEnd(user.getChoices())) {
                user.doSuccess();
                break;
            }
        }

        OutputView.printResult(user, answerBridge.compareTo(user));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String retryCommand = InputView.getInputRetryCommand();
        if (retryCommand.equals("R")) {
            return true;
        }
        return false;
    }

    private void resetGame() {
        user.resetChoices();
    }
}
