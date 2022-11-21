package bridge;

import bridge.controller.ConsoleController;
import bridge.controller.DataAccessController;


/**
 * 다리 건너기 게임을 관리하는 클래스
 * 필드를 추가 가능
 * 패키지 변경 가능
 * 메서드 이름 변경 불가
 * 인자, 반환 타입 추가, 변경 가능
 * 메서드 추가, 변경 가능
 */
public class BridgeGame {
    private final static ConsoleController CONSOLE = new ConsoleController();
    private final static DataAccessController DAO = new DataAccessController();
    private int round = 0;
    private int tryCount = 1;


    public void start() {
        DAO.makeBridge(CONSOLE.bridgeSizeConsole());
        move();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        DAO.updateBridgeStatus(round, CONSOLE.moveConsole());
        CONSOLE.statusConsole(DAO.getBridgeStatus());
        check();
    }

    public void check() {
        if(DAO.getBridgeStatus().getSuccess()) {
            round+=1;
            if(DAO.getBridgeSize() == round) {
                end();
                return;
            }
            move();
            return;
        }
        retry();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if("Q".equals(CONSOLE.commandConsole())) {
            end();
            return;
        }
        DAO.previousBridgeStatus();
        tryCount++;
        move();
    }

    public void end() {
        CONSOLE.endConsole(
                DAO.getBridgeStatus(),
                tryCount
        );
    }
}