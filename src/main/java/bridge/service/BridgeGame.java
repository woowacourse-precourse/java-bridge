package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Blocks;
import bridge.domain.Bridge;
import bridge.domain.CrossStatuses;
import bridge.domain.enums.BlockStatus;
import bridge.domain.enums.CrossStatus;
import bridge.repository.BridgeGameRepository;
import bridge.validator.InputValidator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public Bridge generateRandomBridge(final String inputBridgeSize) {
        int bridgeSize = InputValidator.validateBridgeSize(inputBridgeSize);
        return bridgeGameRepository.storeBridge(new Bridge(createBlocks(bridgeSize), createCrossStatuses(bridgeSize)));
    }

    private Blocks createBlocks(final int bridgeSize) {
        List<String> symbolBlocks = bridgeMaker.makeBridge(bridgeSize);
        return new Blocks(BlockStatus.convertToBlockStatues(symbolBlocks));
    }

    private CrossStatuses createCrossStatuses(final int bridgeSize) {
        List<CrossStatus> crossStatuses = CrossStatus.createInitializationStatuses(bridgeSize);
        return new CrossStatuses(crossStatuses);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(final String inputBlock) {
        InputValidator.validateBlock(inputBlock);
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
