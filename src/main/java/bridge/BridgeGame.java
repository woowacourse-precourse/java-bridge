package bridge;

import bridge.controller.ConsoleController;
import bridge.controller.DataTransferController;


/**
 * 다리 건너기 게임을 관리하는 클래스
 * 필드를 추가 가능
 * 패키지 변경 가능
 * 메서드 이름 변경 불가
 * 인자, 반환 타입 추가, 변경 가능
 * 메서드 추가, 변경 가능
 */
public class BridgeGame {
    private final ConsoleController consoleController = new ConsoleController();
    private final DataTransferController dataTransferController = new DataTransferController();
    private int round = 0;
    private int tryCount = 1;

    public void run() {
        dataTransferController.makeBridge(consoleController.bridgeSizeConsole());
        move();
        while (round < dataTransferController.getBridgeSize()) {
            retry();
            move();
        }
        end();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        dataTransferController.updateBridgeStatus(round, consoleController.moveConsole());
        consoleController.statusConsole(dataTransferController.getBridgeStatus());
        round++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if(dataTransferController.getBridgeStatus().getSuccess()) {
            return;
        }
        if("Q".equals(consoleController.commandConsole())) {
            round = 20;
        }
        dataTransferController.resetBridgeStatus();
        round = 0;
        tryCount++;
    }

    public void end() {
        consoleController.endConsole(
                dataTransferController.getBridgeStatus(),
                tryCount
        );
    }
}