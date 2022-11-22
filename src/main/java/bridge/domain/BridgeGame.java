package bridge.domain;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.validator.PlayerInputValidator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private GameResult gameResult;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void initGameResult() {
        gameResult = new GameResult();
    }

    public GameResult move(String bridgeShape, String input) {
        inputShapeValidate(input);
        if (input.equals(bridgeShape)) {
            gameResult = setSuccessResult(bridgeShape);
            return gameResult;
        }
        gameResult = setFailResult(bridgeShape);
        return gameResult;
    }

    public GameResult setSuccessResult(String bridgeShape) {
        if (bridgeShape.equals("U")) {
            gameResult.setUpBridgeResult("O");
            gameResult.setDownBridgeResult(" ");
            gameResult.setBridgeGameResult(true);
            return gameResult;
        }
        gameResult.setUpBridgeResult(" ");
        gameResult.setDownBridgeResult("O");
        gameResult.setBridgeGameResult(true);
        return gameResult;
    }

    public GameResult setFailResult(String bridgeShape) {
        if (bridgeShape.equals("U")) {
            gameResult.setUpBridgeResult(" ");
            gameResult.setDownBridgeResult("X");
            gameResult.setBridgeGameResult(false);
            return gameResult;
        }
        gameResult.setUpBridgeResult("X");
        gameResult.setDownBridgeResult(" ");
        gameResult.setBridgeGameResult(false);
        return gameResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        inputRetryValidate(input);
        if (input.equals("R")) {
            return true;
        }
        return false;
    }

    public void inputShapeValidate(String input) {
        PlayerInputValidator.moveBridgeInputValidator(input);
    }

    public void inputRetryValidate(String input) {
        PlayerInputValidator.restartOrEndInputValidator(input);
    }
}
