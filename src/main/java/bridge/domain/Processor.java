package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import bridge.util.Commands;
import bridge.util.Directions;
import java.util.List;

public class Processor {
    private final OutputView output;
    private final InputView input;

    Processor() {
        this.output = new OutputView();
        this.input = new InputView(output);
    }

    /**
     * 게임 시작을 알리는 문구를 출력하고<br/>
     * 게임에 사용될 정답 Bridge를 반환한다.
     *
     * @return {@link #getBridge()}
     */
    List<String> startGame() {
        output.printStartMessage();
        return getBridge();
    }

    /**
     * 게임에 사용될 정답 Bridge를 만드는 메서드입니다.
     * @return {@link BridgeGame#bridge}
     */
    private List<String> getBridge() {
        int bridgeSize;
        BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        do {
            bridgeSize = input.readBridgeSize();
        } while (bridgeSize == -1);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자에게 이동 방향을 입력받는 메서드입니다.<br/>
     * <p>
     * * 올바른 값을 입력할 때까지 반복됩니다.
     * @return "U" 혹은 "D" 문자열
     * @see BridgeGame#startRound()
     * @see InputView#readMoving()
     */
    String askMoving() {
        String moving;
        do {
            moving = input.readMoving();
        } while (moving.equals("error"));
        return moving;
    }

    /**
     * 사용자에게 이동 방향을 입력받는 메서드입니다.<br/>
     * <p>
     * * 올바른 값을 입력할 때까지 반복됩니다.
     * @return "R" 혹은 "Q" 문자열
     * @see BridgeGame#retry()
     * @see InputView#readContinue()
     */
    String askContinue() {
        String choice;
        do {
            choice = input.readContinue();
        } while (choice.equals("error"));
        return choice;
    }

    /**
     * 라운드 결과를 출력하는 메서드입니다.
     *
     * @param upsideBridge {@link BridgeGame#playerBoard}의 위 다리 형태 문자열 {@link PlayerBoard#getBridgeStatus(String)}
     * @param downsideBridge {@link BridgeGame#playerBoard}의 아래 다리 형태 문자열 {@link PlayerBoard#getBridgeStatus(String)}
     * @see BridgeGame#startRound()
     */
    void getRoundResult(String upsideBridge, String downsideBridge) {
        output.printMap(upsideBridge, downsideBridge);
    }

    /**
     * 게임 최종 결과를 출력하는 메서드입니다.
     * @param isComplete {@link BridgeGame#isComplete}
     * @param attempts {@link BridgeGame#attempts}
     * @param playerBoard {@link BridgeGame#playerBoard}
     * @see BridgeGame#run()
     * @see OutputView#printResult(boolean, int)
     */
    void getGameResult(boolean isComplete, int attempts, PlayerBoard playerBoard) {
        output.printMessage(Commands.FINAL_RESULT_MESSAGE.message());
        String upsideBridge = playerBoard.getBridgeStatus(Directions.UP.getValue());
        String downsideBridge = playerBoard.getBridgeStatus(Directions.DOWN.getValue());
        output.printMap(upsideBridge, downsideBridge);
        output.printResult(isComplete, attempts);
    }
}