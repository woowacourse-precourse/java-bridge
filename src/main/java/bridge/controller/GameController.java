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
import bridge.dto.output.PrintResultDto;
import bridge.exception.domain.WrongGeneratorException;
import bridge.exception.view.NotFoundViewException;
import bridge.utils.game.GameStatus;
import bridge.utils.message.ExceptionMessageUtils;
import bridge.view.GuideView;
import bridge.view.IOViewResolver;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameController {

    private final IOViewResolver ioViewResolver;
    private final Map<GameStatus, Supplier<GameStatus>> gameStatusMappings;
    private BridgeGame bridgeGame;

    public GameController(IOViewResolver ioViewResolver) {
        this.ioViewResolver = ioViewResolver;
        gameStatusMappings = new EnumMap<>(GameStatus.class);

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
            return processException(e.getMessage(), gameStatus);
        } catch (WrongGeneratorException | NotFoundViewException e) {
            return processException(e.getMessage(), GameStatus.APPLICATION_EXIT);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return processException(ExceptionMessageUtils.WRONG_CONFIGURATION.getMessage(),
                    GameStatus.APPLICATION_EXIT);
        }
    }

    private GameStatus processException(String message, final GameStatus gameStatus) {
        ioViewResolver.outputViewResolve(new PrintExceptionDto(message));
        return gameStatus;
    }

    private GameStatus applicationStart() {
        GuideView.printGameStart();
        return GameStatus.MAKE_BRIDGE;
    }

    private GameStatus makeBridge() {
        ReadBridgeSizeDto inputDto = ioViewResolver.inputViewResolve(ReadBridgeSizeDto.class);
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        bridgeGame = new BridgeGame(inputDto.getSize(), generator);

        return GameStatus.GAME_PLAY;
    }

    private GameStatus gamePlay() {
        ReadMovingDto dto = ioViewResolver.inputViewResolve(ReadMovingDto.class);
        MoveDto moveDto = bridgeGame.move(dto);

        ioViewResolver.outputViewResolve(moveDto.getPrintMapDto());
        return moveDto.getNextGameStatus();
    }

    private GameStatus gameOver() {
        ReadGameCommandDto inputDto = ioViewResolver.inputViewResolve(ReadGameCommandDto.class);
        RetryDto retryDto = bridgeGame.retry(inputDto);

        return retryDto.getNextGameStatus();
    }

    private GameStatus gameExit() {
        ExitDto exitDto = bridgeGame.exit();

        GuideView.printGameResult();
        ioViewResolver.outputViewResolve(new PrintResultDto(exitDto));
        return GameStatus.APPLICATION_EXIT;
    }
}
