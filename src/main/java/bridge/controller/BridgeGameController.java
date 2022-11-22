package bridge.controller;

import static bridge.type.GameStateType.*;

import bridge.data.dto.requestDto.FailMenuRequestDto;
import bridge.data.dto.requestDto.FinalResultRequestDto;
import bridge.data.dto.requestDto.GameInitRequestDto;
import bridge.data.dto.requestDto.InGameCommandRequestDto;
import bridge.data.dto.responseDto.FailMenuResponseDto;
import bridge.data.dto.responseDto.FinalResultResponseDto;
import bridge.data.dto.responseDto.GameInitResponseDto;
import bridge.data.dto.responseDto.InGameCommandResponseDto;
import bridge.service.BridgeGameService;
import bridge.service.BridgeGameServiceImpl;
import bridge.type.GameStateType;
import bridge.utils.Logger;
import bridge.view.InputView;
import bridge.view.InputViewImpl;
import bridge.view.OutputView;
import bridge.view.OutputViewImpl;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class BridgeGameController {

    private static final String INIT_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final BridgeGameService gameService;
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<GameStateType, Runnable> gameStateMap;
    private GameStateType state;
    private String sessionId;

    private BridgeGameController() {
        this.gameService = new BridgeGameServiceImpl();
        this.inputView = new InputViewImpl();
        this.outputView = new OutputViewImpl();
        this.gameStateMap = mapGameStateType();
        this.state = STATE_INIT;
    }

    private Map<GameStateType, Runnable> mapGameStateType() {
        Map<GameStateType, Runnable> runnableMap = new EnumMap<>(GameStateType.class);
        runnableMap.put(STATE_INIT, this::init);
        runnableMap.put(STATE_PLAY, this::play);
        runnableMap.put(STATE_FAIL, this::fail);
        runnableMap.put(STATE_RESULT, this::result);
        return Collections.unmodifiableMap(runnableMap);
    }

    private void init() {
        GameInitRequestDto requestDto = new GameInitRequestDto(inputView.readBridgeSize());
        GameInitResponseDto responseDto = gameService.initGame(requestDto);
        sessionId = responseDto.getSessionId();
        state = state.getNextState();
    }

    private void play() {
        InGameCommandRequestDto requestDto = new InGameCommandRequestDto(inputView.readInGameCommand(), sessionId);
        InGameCommandResponseDto responseDto = gameService.playGame(requestDto);
        changePlayState(responseDto);
        outputView.printMap(responseDto);
    }

    private void changePlayState(InGameCommandResponseDto responseDto) {
        if (responseDto.isPlayerDead()) {
            state = STATE_FAIL;
            return;
        }
        if (responseDto.isGameCleared()) {
            state = STATE_RESULT;
        }
    }

    private void fail() {
        FailMenuRequestDto requestDto = new FailMenuRequestDto(inputView.readFailMenuCommand(), sessionId);
        FailMenuResponseDto responseDto = gameService.askRetry(requestDto);
        changeFailState(responseDto);
    }

    private void changeFailState(FailMenuResponseDto responseDto) {
        if (responseDto.isRetry()) {
            state = STATE_PLAY;
            return;
        }
        if (responseDto.isQuit()) {
            state = STATE_RESULT;
        }
    }

    private void result() {
        FinalResultRequestDto requestDto = new FinalResultRequestDto(sessionId);
        FinalResultResponseDto responseDto = gameService.getResult(requestDto);
        outputView.printResult(responseDto);
        state = state.getNextState();
    }

    /**
     * 게임을 실행합니다.
     * 개발자의 실수로 일어날 오류를 잡아내 로깅하고, 어플리케이션을 종료합니다.
     */
    public static void run() {
        BridgeGameController gameController = new BridgeGameController();
        try {
            gameController.manipulate();
        } catch (RuntimeException exception) {
            Logger.error(exception.getMessage());
        }
    }

    /**
     * 게임이 끝날 때까지 조작합니다.
     * 사용자의 입력 실수를 잡아내고, 해당 단계를 재실행합니다.
     */
    public void manipulate() {
        outputView.printMessage(INIT_MESSAGE);
        while (state != STATE_DONE) {
            try {
                gameStateMap.get(state).run();
            } catch (IllegalArgumentException userMistake) {
                outputView.printMessage(userMistake.getMessage());
            }
        }
    }
}
