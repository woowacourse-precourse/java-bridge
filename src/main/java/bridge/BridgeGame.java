package bridge;

import static bridge.Utils.Constant.GameCommand.QUIT;
import static bridge.Utils.Constant.GameCommand.RETRY;

import bridge.Controller.BridgeController;
import bridge.Domain.Bridge;
import bridge.Utils.Constant.GameCommand;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeController bridgeController;
    private Bridge user;
    private int playCount = 0;
    private boolean isPlaying;

    BridgeGame() {
        bridgeController = new BridgeController();

        play();
    }

    public void play() {
        isPlaying = true;
        playCount++;
        setAnswer();

        while (isPlaying) {
            move();
        }
    }

    private void setAnswer() {
        List<String> answerMovings = bridgeController.getAnswerBridge();
        user = new Bridge(answerMovings);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        user = bridgeController.addMovingToBridge(user);
        if (user.isMatchAboutLastMoving()) {
            matchAboutLastMoving();
            return;
        }
        notMatchAboutLastMoving();
    }

    private void matchAboutLastMoving() {
        bridgeController.printResultByBridge(user);
        if (user.isFinish()) {
            quit(true);
        }
    }

    private void notMatchAboutLastMoving() {
        bridgeController.printResultByBridge(user);
        quitOrRetry();
    }

    public void quitOrRetry() {
        GameCommand command = bridgeController.getCommand();
        if (command.equals(QUIT)) {
            quit(false);
        }
        if (command.equals(RETRY)) {
            retry();
        }
    }

    public void quit(boolean isSuccess) {
        isPlaying = false;
        bridgeController.printQuitMessageByBridge(user, isSuccess, playCount);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        playCount++;
        user.clear();
    }
}
