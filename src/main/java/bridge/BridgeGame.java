package bridge;

import static bridge.Utils.Constants.QUIT;
import static bridge.Utils.Constants.RETRY;

import bridge.Controller.BridgeController;
import bridge.Controller.ViewController;
import bridge.Domain.Bridge;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeController bridgeController;
    ViewController viewController;
    Bridge user;
    int playCount = 0;
    boolean isPlaying;


    BridgeGame() {
        bridgeController = new BridgeController();
        viewController = new ViewController();

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
        user.addMoving(viewController.getMoving());
        if (user.isMatchAboutThisMoving()) {
            viewController.printResult(user.getResult());
            if (user.isFinish()) {
                quit(true);
            }
            return;
        }
        quitOrRetry();
    }

    public void quitOrRetry() {
        String command = viewController.getCommand();
        if (command.equals(QUIT)) {
            quit(false);
        }
        if (command.equals(RETRY)) {
            retry();
        }
    }

    public void quit(boolean isSuccess) {
        isPlaying = false;
        String result = user.getResult();
        viewController.quit(result, isSuccess, playCount);
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
