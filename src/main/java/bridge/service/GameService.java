package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;
import bridge.dto.BridgeDto;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final BridgeGame bridgeGame;
    private final List<BridgeDto> cache;

    public GameService(final BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.cache = new ArrayList<>();
    }

    public static GameService createNewGame(final ViewService viewService) {
        viewService.printStartMessage();
        int size = viewService.askBridgeLength();

        BridgeMakingService makingService = new BridgeMakingService(new BridgeMaker(new BridgeRandomNumberGenerator()));
        Bridge bridge = makingService.makeSizeOf(size);

        return new GameService(new BridgeGame(bridge));
    }

    public MatchResult moveForward(final String input) {
        MatchResult move = bridgeGame.move(input);
        setBridgeDto(input);
        return move;
    }

    private void setReGame() {
        cache.clear();
        bridgeGame.retry();
    }

    public GameResult setReGameOrQuit(final String input) {
        if (input.equals(Command.RETRY.getAbbreviation())) {
            setReGame();
            return GameResult.REGAME;
        }
        return GameResult.FAILURE;
    }

    public BridgeDto getRecentBridge() {
        if (cache.isEmpty()) {
            return new BridgeDto();
        }
        return cache.get(cache.size() - 1);
    }

    private void setBridgeDto(final String input) {
        BridgeDto recentDto = getRecentBridge();

        BridgeState state = bridgeGame.matchRecentInput();
        Command command = Command.getByAbbreviation(input);

        recentDto.setBridge(command, state);
        cache.add(recentDto);
    }
}
