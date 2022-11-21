package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.repository.BridgeRepository;
import bridge.repository.PositionRepository;
import bridge.repository.TryRepository;

import java.util.List;

public class BridgeGameService {

    private final BridgeRepository bridgeRepository = new BridgeRepository();
    private final PositionRepository positionRepository = new PositionRepository();
    private final TryRepository tryRepository = new TryRepository();
    private BridgeGame bridgeGame;

    public void makeBridge(int number) {
        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        this.bridgeGame = BridgeGame.of(number, randomGenerator);
    }

    public boolean moveAndReturnSuccess(final String move) {
        int currentPosition = positionRepository.getPosition();
        List<String> result = bridgeGame.move(currentPosition, move);
        bridgeRepository.save(result);

        return bridgeGame.isSuccess(result);
    }

    public List<String> getUpBridges() {
        return bridgeRepository.getUpBridges();
    }

    public List<String> getDownBridges() {
        return bridgeRepository.getDownBridges();
    }

    public void clearRepository() {
        bridgeRepository.clear();
    }

    public void increasePosition() {
        positionRepository.increase();
    }

    public boolean isEndPosition(final int bridgeSize) {
        return positionRepository.isEndPosition(bridgeSize);
    }

    public void initializePosition() {
        positionRepository.initialize();
    }

    public void increaseTries() {
        tryRepository.increase();
    }

    public int getTotalTries() {
        return tryRepository.getTotalTries();
    }
}
