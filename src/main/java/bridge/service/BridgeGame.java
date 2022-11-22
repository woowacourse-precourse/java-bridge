package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Blocks;
import bridge.domain.Bridge;
import bridge.domain.CrossStatuses;
import bridge.domain.MovingResult;
import bridge.domain.enums.BlockStatus;
import bridge.domain.enums.CrossStatus;
import bridge.repository.BridgeGameRepository;
import bridge.validator.InputValidator;
import java.util.List;

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

    public MovingResult createMovingResult() {
        return getBridge().getMovingResult();
    }

    public void move(final String inputBlock) {
        InputValidator.validateBlock(inputBlock);
        getBridge().moveNextBlock(inputBlock);
    }

    private Bridge getBridge() {
        return bridgeGameRepository.findBridge();
    }

    public void retry() {
        bridgeGameRepository.increaseGameCount();
        bridgeGameRepository.findBridge()
                .clearCrossStatues();
    }

    public int getGameCount() {
        return bridgeGameRepository.findGameCount();
    }
}
