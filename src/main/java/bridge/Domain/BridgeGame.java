package bridge.Domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Constants.FrontMan;
import bridge.Database.BridgeData;
import bridge.UI.InputView;
import bridge.UI.OutputView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static bridge.Constants.StandardTools.FAILED;
import static bridge.Constants.StandardTools.retry;
import static bridge.Constants.StandardTools.SUCCEED;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final BridgeData bridgeData = new BridgeData();
    public final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    public final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    public final InputView inputView = new InputView();

    public final OutputView outputView = new OutputView();
    private boolean isGameSucceed = FAILED;
    private boolean isGameFinished;
    private retry retryOrQuit = retry.QUIT;

    public BridgeGame() {
        System.out.println(FrontMan.BRIDGE_GAME_IS_BEGINNING + "\n");
        isGameFinished = false;
    }

    public void gameStart() {
        bridgeData.setBridge(bridgeMaker.makeBridge(inputView.readBridgeLength()));
        bridgeData.initializeTotalAttempt();
    }

    public void move() {
        List<String> bridgeDesignByUser = new ArrayList<>();
        isGameFinished = false;
        while (!isGameFinished) {
            retryOrQuit = retry.QUIT;
            String nextStep = inputView.readMoving();
            bridgeDesignByUser.add(nextStep);
            bridgeData.updateBridgeDesignByUser(bridgeDesignByUser);
            validateNextStep(nextStep, bridgeDesignByUser.size() - 1);
            printGameStatus();
        }
    }

    private void printGameStatus() {
        if (isGameSucceed) { // 성공
            outputView.printResult(bridgeData, SUCCEED);
        }
        if (isGameFinished && isGameSucceed == FAILED && retryOrQuit == retry.QUIT) { // 포기
            outputView.printResult(bridgeData, FAILED);
        }
        if (!isGameFinished && retryOrQuit != retry.RETRY && isGameSucceed != SUCCEED) { // 진행중
            outputView.printMap(bridgeData);
        }
    }

    private void validateNextStep(String nextStep, int indexOfBridgeEnd) {
        if (!Objects.equals(bridgeData.getBridge().get(indexOfBridgeEnd), nextStep)) {
            isGameSucceed = FAILED;
            isGameFinished = true;
            bridgeData.getBridgeDesignByUser().set(indexOfBridgeEnd, "X");
            retry();
        }
        validateGameSuccessfullyFinished();
    }

    public void validateGameSuccessfullyFinished() {
        if (Objects.equals(bridgeData.getBridge(), bridgeData.getBridgeDesignByUser())) {
            isGameSucceed = SUCCEED;
            isGameFinished = true;
        }
    }

    public void retry() {
        String gameCommand = inputView.readGameCommand();
        if (Objects.equals(gameCommand, "R")) {
            initializeBridgeDesignByUser();
            bridgeData.increaseAttempts();
            retryOrQuit = retry.RETRY;
        }
        if (Objects.equals(gameCommand, "Q")) {
            retryOrQuit = retry.QUIT;
        }
    }

    public void initializeBridgeDesignByUser() {
        bridgeData.updateBridgeDesignByUser(Collections.emptyList());
    }

    public boolean getIsGameSucceed() {
        return this.isGameSucceed;
    }

    public boolean getIsGameFinished() {
        return this.isGameFinished;
    }

    public retry getRetryOrQuit() {
        return this.retryOrQuit;
    }
}
