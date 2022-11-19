package bridge.domain.game;

import bridge.BridgeNumberGenerator;
import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeTile;
import bridge.domain.player.Player;
import bridge.dto.controller.ExitDto;
import bridge.dto.controller.MoveDto;
import bridge.dto.controller.RetryDto;
import bridge.dto.input.ReadGameCommandDto;
import bridge.dto.input.ReadMovingDto;
import bridge.utils.game.GameCommand;
import bridge.utils.game.GameStatus;

public class BridgeGame {

    private final Player player;
    private final Bridge bridge;

    public BridgeGame(int size, BridgeNumberGenerator generator) {
        this.bridge = new Bridge(size, generator);
        this.player = new Player(size);
    }

    public MoveDto move(ReadMovingDto readMovingDto) {
        BridgeTile playerStep = BridgeTile.findTile(readMovingDto.getMovingCommand());
        boolean movable = player.move(bridge, playerStep);
        boolean success = player.isSuccessful(bridge);

        return new MoveDto(GameStatus.findNextGamePlay(success, movable), player);
    }

    public RetryDto retry(ReadGameCommandDto readGameCommandDto) {
        String gameCommand = readGameCommandDto.getGameCommand();
        GameStatus nextGameStatus = GameCommand.findNextGameOver(gameCommand);

        if (nextGameStatus == GameStatus.GAME_PLAY) {
            player.preparedNextPlay();
        }
        return new RetryDto(nextGameStatus);
    }

    public ExitDto exit() {
        return new ExitDto(player, bridge);
    }
}
