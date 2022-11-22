package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import bridge.dto.MovingResultDto;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

/**
 * 게임 입출력, 게임 실행, 종료 등을 관리하는 클래스
 */
public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    private List<String> result;

    /**
     * 입출력 및 게임 관리를 위한 객체 생성하는 메서드
     */
    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();

        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        bridgeGame = new BridgeGame(numberGenerator);
    }

    /**
     * 입력받은 길이만큼 다리를 생성하는 메서드
     */
    public void settingBridge() {
        outputView.printStart();

        bridgeGame.settingBridge(inputView.readBridgeSize());
        bridgeGame.initGame();
    }

    /**
     * 움직임을 수행한 후 게임 종료 여부를 묻는 메서드
     */
    public void run() {
        boolean success = false;
        boolean retry = true;

        while (!success && retry) {
            success = move();
            retry = askRetry(success);
        }

        ending(success);
    }

    /**
     * 게임이 완료될 때까지 사용자에게 입력을 받아 실행하는 메서드
     *
     * @return 끝까지 도달 여부
     */
    private boolean move() {
        boolean complete = false;
        List<String> bridge = bridgeGame.getBridge();

        while (!complete) {
            String moving = inputView.readMoving();

            MovingResultDto resultDto = bridgeGame.move(moving);
            complete = resultDto.getCompleteness();
            result = resultDto.getResult();

            outputView.printMap(bridge, result);

            if (resultDto.getPosition() == bridge.size()) {
                return true;
            }
        }

        return false;
    }

    /**
     * 게임 성공 여부에 따라 게임 다시 시작 입력을 받아 실행하는 메서드
     *
     * @param success 게임 성공 여부
     * @return 다시 시작 여부
     */
    private boolean askRetry(boolean success) {

        if (!success) {
            String retryInput = inputView.readGameCommand();

            return bridgeGame.retry(retryInput);
        }

        return false;
    }

    /**
     * 게임 종료 문구를 출력하는 메서드
     *
     * @param success 게임 완료 여부
     */
    private void ending(boolean success) {
        int tryCount = bridgeGame.getTryCount();
        List<String> bridge = bridgeGame.getBridge();
        GameResult gameResult = GameResult.getGameResult(success);

        outputView.printEndingPhrase();
        outputView.printMap(bridge, result);
        outputView.printResult(gameResult, tryCount);
    }


}
