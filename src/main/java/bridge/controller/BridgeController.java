package bridge.controller;

import bridge.domain.BridgeCrossingStatus;
import bridge.dto.BridgeCrossingDTO;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private static final String GAME_RESTART_KEY = "R";
    private static final String GAME_QUIT_KEY = "Q";
    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public void run() {
        OutputView.printGameStart();
        createBridge(inputBridgeSize());
        moveOnTheBridge(inputBridgeMove());
    }

    private int inputBridgeSize() {
        try {
            OutputView.printInputNumber();
            return InputView.inputBridgeSize();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputBridgeSize();
        }
    }

    private void createBridge(int bridgeSize) {
        bridgeService.createBridge(bridgeSize);
    }

    private String inputBridgeMove() {
        try {
            OutputView.printInputMoving();
            return InputView.inputBridgeMove();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputBridgeMove();
        }
    }

    private void moveOnTheBridge(String bridgeMoving) {
        BridgeCrossingDTO bridgeCrossingDTO = bridgeService.moveUser(bridgeMoving);
        OutputView.printMap(bridgeCrossingDTO.getFootPrint());
        checkContinue(bridgeCrossingDTO);
    }

    private void checkContinue(BridgeCrossingDTO bridgeCrossingDTO) {
        if (bridgeCrossingDTO.getCrossStatus().equals(BridgeCrossingStatus.SUCCESS.getStatus())) {
            outputGameResult(bridgeCrossingDTO);
        }
        if (bridgeCrossingDTO.getCrossStatus().equals(BridgeCrossingStatus.PROGRESS.getStatus())) {
            moveOnTheBridge(inputBridgeMove());
        }
        if (bridgeCrossingDTO.getCrossStatus().equals(BridgeCrossingStatus.FAIL.getStatus())) {
            checkRestart(inputGameRestart(), bridgeCrossingDTO);
        }
    }

    private String inputGameRestart() {
        try {
            OutputView.printInputRestart();
            return InputView.inputGameReStart();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputGameRestart();
        }
    }

    private void checkRestart(String inputGameRestart, BridgeCrossingDTO bridgeCrossingDTO) {
        if (inputGameRestart.equals(GAME_QUIT_KEY)) {
            outputGameResult(bridgeCrossingDTO);
        }
        if (inputGameRestart.equals(GAME_RESTART_KEY)) {
            bridgeService.retryGame();
            moveOnTheBridge(inputBridgeMove());
        }
    }

    private void outputGameResult(BridgeCrossingDTO bridgeCrossingDTO) {
        OutputView.printOutputEnd();
        OutputView.printMap(bridgeCrossingDTO.getFootPrint());
        OutputView.printClearStatus(bridgeCrossingDTO.getCrossStatus());
        OutputView.printTryCount(bridgeCrossingDTO.getTryCount());
    }
}
