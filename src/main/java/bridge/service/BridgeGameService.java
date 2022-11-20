package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.repository.BridgeRepository;

import java.util.List;

public class BridgeGameService {

    private final BridgeRepository bridgeRepository = new BridgeRepository();
    private BridgeGame bridgeGame;

    public void makeBridge(int number) {
        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        this.bridgeGame = BridgeGame.of(number, randomGenerator);
    }

    public boolean moveAndReturnSuccess(final int currentPosition, final String move) {
        List<String> result = bridgeGame.move(currentPosition, move);
        bridgeRepository.save(result);

        return bridgeGame.isSuccess(result);
    }
}
