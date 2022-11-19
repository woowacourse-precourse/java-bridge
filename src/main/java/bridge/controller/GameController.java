package bridge.controller;

import bridge.domain.game.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.controller.ExitDto;
import bridge.dto.controller.MoveDto;
import bridge.dto.controller.RetryDto;
import bridge.dto.input.ReadBridgeSizeDto;
import bridge.dto.input.ReadGameCommandDto;
import bridge.dto.input.ReadMovingDto;
import bridge.dto.output.PrintExceptionDto;
import bridge.dto.output.PrintMapDto;
import bridge.dto.output.PrintResultDto;
import bridge.exception.domain.WrongGeneratorException;
import bridge.utils.game.GameStatus;
import bridge.view.GuideView;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Map<GameStatus, Supplier<GameStatus>> gameStatusMappings = new EnumMap<>(GameStatus.class);
    private BridgeGame bridgeGame;

    public GameController() {
        initGameStatusMappings();
    }

    private void initGameStatusMappings() {
        gameStatusMappings.put(GameStatus.APPLICATION_START, this::applicationStart);
        gameStatusMappings.put(GameStatus.MAKE_BRIDGE, this::makeBridge);
        gameStatusMappings.put(GameStatus.GAME_PLAY, this::gamePlay);
        gameStatusMappings.put(GameStatus.GAME_OVER, this::gameOver);
        gameStatusMappings.put(GameStatus.GAME_EXIT, this::gameExit);
    }

    public GameStatus process(GameStatus gameStatus) {
        try {
            return gameStatusMappings.get(gameStatus).get();
        } catch (IllegalArgumentException e) {
            outputView.printException(new PrintExceptionDto(e));
            return gameStatus;
        } catch (WrongGeneratorException e) {
            outputView.printException(new PrintExceptionDto(e));
            return GameStatus.APPLICATION_EXIT;
        }
    }

    private GameStatus applicationStart() {
        GuideView.printGameStart();
        return GameStatus.MAKE_BRIDGE;
    }

    private GameStatus makeBridge() {
        ReadBridgeSizeDto readBridgeSizeDto = inputView.readBridgeSize();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        bridgeGame = new BridgeGame(readBridgeSizeDto.getSize(), generator);

        return GameStatus.GAME_PLAY;
    }

    private GameStatus gamePlay() {
        ReadMovingDto readMovingDto = inputView.readMoving();
        MoveDto moveDto = bridgeGame.move(readMovingDto);

        outputView.printMap(new PrintMapDto(moveDto.getPlayer()));
        return moveDto.getNextGameStatus();
    }

    private GameStatus gameOver() {
        ReadGameCommandDto readGameCommandDto = inputView.readGameCommand();
        RetryDto retryDto = bridgeGame.retry(readGameCommandDto);

        return retryDto.getNextGameStatus();
    }

    private GameStatus gameExit() {
        ExitDto exitDto = bridgeGame.exit();

        GuideView.printGameResult();
        outputView.printResult(new PrintResultDto(exitDto));
        return GameStatus.APPLICATION_EXIT;
    }
}
