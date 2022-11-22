package bridge.model.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Constant;
import bridge.model.dto.GameResultDto;
import bridge.model.dto.MoveResultDto;
import bridge.model.repository.BridgeRepository;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeRepository bridgeRepository = new BridgeRepository();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResultDto move(String bridgeToMove) {
        bridgeRepository.addPosition();
        String actualBridge = bridgeRepository.findBridge();
        boolean isMovableStatus = bridgeRepository.isMovableStatus();
        boolean isRightLastBridgePick = actualBridge.equals(bridgeToMove);
        return new MoveResultDto(isRightLastBridgePick, isMovableStatus);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        boolean isRestartGame = gameCommand.equals(Constant.RESTART_GAME);
        if (!isRestartGame) {
            bridgeRepository.modifyToGameFail();
        }
        bridgeRepository.initPosition();
        bridgeRepository.addRetryCount();
        return isRestartGame;
    }

    public void createBridge(int bridgeSize) {
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);
        bridgeRepository.createBridge(bridges);
    }

    public List<String> findBridgeMap() {
        return bridgeRepository.findBridgeMap();
    }

    public GameResultDto findGameResult() {
        return bridgeRepository.findGameResult();
    }
}
