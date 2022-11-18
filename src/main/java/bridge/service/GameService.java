package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MatchResult;
import bridge.dto.BridgeDto;

public class GameService {
    private final BridgeGame bridgeGame;

    public GameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public static GameService createNewGame(ViewService viewService) {
        int size = viewService.getBridgeLength();
        BridgeMakingService makingService = new BridgeMakingService(new BridgeMaker(new BridgeRandomNumberGenerator()));
        Bridge bridge = makingService.makeSizeOf(size);
        return new GameService(new BridgeGame(bridge));
    }

    public MatchResult moveForward(String input) {
        return bridgeGame.move(input);
    }

    public BridgeDto getMyBridgeToPrint(MatchResult matchResult) {
        return bridgeGame.getMyBridgeToPrint(matchResult);
    }
}
