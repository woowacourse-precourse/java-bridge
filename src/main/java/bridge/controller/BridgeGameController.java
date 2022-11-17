package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.strategy.BridgeRandomNumberGenerator;
import bridge.dto.BridgeSizeDTO;
import bridge.dto.GameCommandDTO;
import bridge.dto.MovingDTO;
import bridge.dto.GameResultDTO;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    
    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
    
    public void start() {
        outputView.printGameStartMessage();
        playBridgeGame(new BridgeGame(new BridgeRandomNumberGenerator(), inputBridgeSize()));
    }
    
    private BridgeSizeDTO inputBridgeSize() {
        return inputView.readBridgeSize(outputView);
    }
    
    private void playBridgeGame(final BridgeGame bridgeGame) {
        boolean isGameFinished = false;
        
        while (!isGameFinished) {
            move(bridgeGame);
            printResultMap(new GameResultDTO(bridgeGame));
            isGameFinished = isGameFinished(bridgeGame);
        }
        printResult(new GameResultDTO(bridgeGame));
    }
    
    private void move(final BridgeGame bridgeGame) {
        bridgeGame.move(inputMoving());
    }
    
    private MovingDTO inputMoving() {
        printMovingInputMessage();
        return inputView.readMoving();
    }
    
    private void printMovingInputMessage() {
        outputView.printMovingInputMessage();
    }
    
    private void printResultMap(final GameResultDTO gameResultDTO) {
        outputView.printMap(gameResultDTO);
    }
    
    private boolean isGameFinished(final BridgeGame bridgeGame) {
        if (isMoveFailed(bridgeGame)) {
            return selectGameFinish(bridgeGame);
        }
        
        return bridgeGame.isGameFinished();
    }
    
    private boolean isMoveFailed(final BridgeGame bridgeGame) {
        return bridgeGame.isMoveFail();
    }
    
    private boolean selectGameFinish(final BridgeGame bridgeGame) {
        if (inputGameCommand().equals("Q")) {
            return true;
        }
        
        initBridgeGameForRetry(bridgeGame);
        return false;
    }
    
    private String inputGameCommand() {
        printGameCommandInputMessage();
        final GameCommandDTO gameCommandDTO = inputView.readGameCommand();
        return gameCommandDTO.getGameCommand();
    }
    
    private void printGameCommandInputMessage() {
        outputView.printGameCommandInputMessage();
    }
    
    private void initBridgeGameForRetry(final BridgeGame bridgeGame) {
        bridgeGame.retry();
    }
    
    private void printResult(final GameResultDTO gameResultDTO) {
        outputView.printResult(gameResultDTO);
    }
}
