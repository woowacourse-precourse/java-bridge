package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.constant.ConstValue.QUIT;
import static bridge.constant.Message.FAIL;
import static bridge.constant.Message.SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int tryCount;
    private Bridge bridge;
    private final User user = new User();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public BridgeGame() {
        outputView.printGameStart();
        this.bridge = setBridge();
        this.tryCount = 1;
    }

    private Bridge setBridge() {
        outputView.printBridgeSizeMessage();
        try {
            int bridgeSize = inputView.readBridgeSize();
            return new Bridge(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return setBridge();
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String moving = setMoving();

        moveUser(moving);
        saveIsCorrectState(checkCorrectMoving(moving));

        outputView.printMap(user);
    }

    private String setMoving() {
        outputView.printMovingMessage();
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return setMoving();
        }
    }

    private void saveIsCorrectState(boolean checkCorrectMoving) {
        user.saveState(checkCorrectMoving);
    }

    private boolean checkCorrectMoving(String moving) {
        if (bridge.getBridge(user.getUserLastIndex()).equals(moving)) {
            return true;
        }
        return false;
    }

    private void moveUser(String moving) {
        user.move(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.clear();
        tryCount += 1;
    }

    public boolean isFail() {
        if (!user.getMoveMatchState(user.getUserLastIndex())) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (user.getUserLastIndex() == bridge.getBridgeSize() - 1 && user.getMoveMatchState(user.getUserLastIndex())) {
            return true;
        }
        return false;
    }

    public boolean isQuit() {
        if (isFail()) {
            String gameCommand = setGameCommand();
            return checkGameCommand(gameCommand);
        }
        if (isSuccess()) {
            outputView.printResult(SUCCESS, user, tryCount);
            return true;
        }
        return false;
    }

    private String setGameCommand() {
        outputView.printRetryMessage();
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return setGameCommand();
        }
    }

    private boolean checkGameCommand(String gameCommand) {
        if (gameCommand.equals(QUIT)) {
            outputView.printResult(FAIL, user, tryCount);
            return true;
        }

        retry();
        return false;
    }
}
