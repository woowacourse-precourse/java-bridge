package bridge.service;

import bridge.model.Bridge;
import bridge.BridgeMaker;
import bridge.enums.BridgeMark;
import bridge.BridgeNumberGenerator;
import bridge.enums.GameStatus;
import bridge.model.Player;
import bridge.dto.GameResultDto;

import static bridge.dto.GameResultDto.GameRecordDto;

public class BridgeGame {

    private Bridge bridge;
    private final Player player;

    public BridgeGame() {
        this.player = new Player();
    }

    public void createBridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public GameResultDto move(int round, String moveMark) {
        BridgeMark movingMark = BridgeMark.of(moveMark);
        player.record(movingMark);
        GameStatus gameStatus = bridge.cross(round, movingMark);

        GameRecordDto gameRecord = player.toResponseDto();
        return createGameResultDto(gameStatus, gameRecord);
    }

    private GameResultDto createGameResultDto(GameStatus gameStatus, GameRecordDto gameRecord) {
        return new GameResultDto(gameStatus, gameRecord);
    }

    public void retry() {
        player.clearRecord();
        player.increaseAttempt();
    }
}
