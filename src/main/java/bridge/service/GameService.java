package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;
import bridge.dto.BridgeDto;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final BridgeGame bridgeGame;
    private final List<BridgeDto> cache = new ArrayList<>();

    public GameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public static GameService createNewGame(ViewService viewService) {
        viewService.printStartMessage();
        int size = viewService.askBridgeLength();
        BridgeMakingService makingService = new BridgeMakingService(new BridgeMaker(new BridgeRandomNumberGenerator()));
        Bridge bridge = makingService.makeSizeOf(size);
        return new GameService(new BridgeGame(bridge));
    }

    public MatchResult moveForward(String input) {
        return bridgeGame.move(input);
    }

    public BridgeDto getMyBridgeToPrint(MatchResult matchResult) {
        BridgeDto dto = bridgeGame.getMyBridgeToPrint(matchResult);
        cache.add(dto);
        return dto;
    }

    private void setReGame() {
        cache.clear();
        bridgeGame.retry();
    }

    public GameResult setReGameOrQuit(String input) {
        if (input.equals(Command.RETRY.getAbbreviation())) {
            setReGame();
            return GameResult.REGAME;
        }
        return GameResult.FAILURE;
    }

    public BridgeDto getRecentBridge() {
        return cache.get(cache.size() - 1);
    }
}
