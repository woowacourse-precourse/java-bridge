package bridge.model;

import static bridge.controller.InputController.getGameCommand;
import static bridge.controller.InputController.getUserSelection;
import static bridge.model.GameCommand.selectedRetry;
import static bridge.model.Status.die;
import static bridge.model.Status.findStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private Diagram diagram;
    private int attempts = 1;
    private boolean success = false;
    private GameCommand command = GameCommand.RETRY;

    public BridgeGame(Bridge bridge, Diagram diagram) {
        this.bridge = bridge;
        this.diagram = diagram;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Status move(int index) {
        Position position = getUserSelection();
        Status status = findStatus(bridge.isSamePosition(index, position));
        diagram.updateDiagrams(position, status);
        return status;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(GameCommand gameCommand) {
        if (selectedRetry(gameCommand)) {
            initialize();
            attempt();
        }
        if (!selectedRetry(gameCommand)) {
            command = GameCommand.QUIT;
        }
    }

    public void initialize() {
        attempts++;
        diagram = new Diagram();
    }

    public void attempt() {
        for (int index = 0; index < bridge.getBridgeSize(); index++) {
            Status status = move(index);
            if (bridge.survivedToTheLast(index)) {
                success = true;
            }
            if (!die(status)) {
                continue;
            }
            if (die(status)) {
                GameCommand gameCommand = getGameCommand();
                retry(gameCommand);
            }
            if (success || command == GameCommand.QUIT) {
                break;
            }
        }
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isSuccess() {
        return success;
    }
}
