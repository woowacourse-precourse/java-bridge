package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.GameRule;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private BridgeRecord record;


    public void start(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
        this.record = new BridgeRecord();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String board) throws IllegalStateException {
        return record.addBoard(bridge, board);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if(command.equals(GameRule.RETRY_COMMAND)){
            record.deleteBoard();
            record.increaseTry();
        } else if (command.equals(GameRule.QUIT_COMMAND)) {
            return true;
        }
        return false;
    }

    public boolean isFinish() {
        if(bridge.getBoards().size()==record.getBoards().size()) {
            return true;
        }
        return false;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public BridgeRecord getRecord() {
        return record;
    }


}
