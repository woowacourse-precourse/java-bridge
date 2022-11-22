package bridge.domain;

import bridge.domain.enumeration.BridgeStatus;
import bridge.dto.BridgeDto;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RESTART_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    private final BridgeDto bridgeDto;
    private int tryNumber = 0;
    private boolean isFail = false;

    public BridgeGame(List<String> bridge) {
        bridgeDto = new BridgeDto(bridge);
        this.tryNumber++;
    }

    public boolean isFail() {
        return isFail;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        checkValidMove(input);
        if (bridgeDto.getBridge().get(bridgeDto.getCurrentStage()).equals(input)) {
            bridgeDto.increaseCurrentStage();
            return true;
        }
        isFail = true;
        return false;
    }

    private void checkValidMove(String input) {
        if (!input.equals(BridgeStatus.UP.getName()) && !input.equals(BridgeStatus.DOWN.getName())) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력 형식이 아닙니다.");
        }
    }

    public boolean isGameEnd() {
        return bridgeDto.getBridge().size() == bridgeDto.getCurrentStage();
    }

    public int getTryNumber() {
        return tryNumber;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String restartCommand) {
        checkValidCommand(restartCommand);
        if (restartCommand.equals(RESTART_COMMAND)) {
            bridgeDto.restart();
            isFail = false;
            tryNumber++;
            return true;
        }
        return false;
    }

    private void checkValidCommand(String restartCommand) {
        if (!restartCommand.equals(RESTART_COMMAND) && !restartCommand.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력 형식이 아닙니다.");
        }
    }

    @Override
    public String toString() {
        BridgeStringGenerator bridgeStringGenerator = new BridgeStringGenerator(bridgeDto, isFail);
        return bridgeStringGenerator.toString();
    }
}
