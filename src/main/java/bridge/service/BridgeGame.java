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

public class BridgeGame {
    private final BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public Bridge generateRandomBridge(final String inputBridgeSize) {
        final int bridgeSize = InputValidator.validateBridgeSize(inputBridgeSize);
        return bridgeGameRepository.storeBridge(new Bridge(createBlocks(bridgeSize), createCrossStatuses(bridgeSize)));
    }

    private Blocks createBlocks(final int bridgeSize) {
        return new Blocks(BlockStatus.convertToBlockStatues(bridgeMaker.makeBridge(bridgeSize)));
    }

    private CrossStatuses createCrossStatuses(final int bridgeSize) {
        return new CrossStatuses(CrossStatus.createInitializationStatuses(bridgeSize));
    }

    public MovingResult createMovingResult() {
        return getBridge().getMovingResult();
    }

    public void move(final String inputBlock) {
        getBridge().moveNextBlock(InputValidator.validateBlock(inputBlock));
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
