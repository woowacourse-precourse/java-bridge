package bridge;

import utils.Common;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;

    private List<String> answers;
    private StringJoiner upperBridge;
    private StringJoiner underBridge;

    private String success;

    private int retryCount;

    public BridgeGame(InputView inputview, OutputView outputView) {
        this.inputView = inputview;
        this.outputView = outputView;
    }

    public void init() {
        setAnswers(new BridgeRandomNumberGenerator(), inputView.readBridgeSize());
    }

    public void setAnswers(BridgeNumberGenerator bridgeNumberGenerator, int size) {
        answers = new BridgeMaker(bridgeNumberGenerator).makeBridge(size);
    }

    public void play() {
        for (String answer : answers) {
            String readMoving = inputView.readMoving();
            move(answer, readMoving);
            if (!answer.equals(readMoving)) {
                success = "실패";
                return;
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String answer, String readMoving) {
        moveUpperBridge(answer, readMoving);
        moveUnderBridge(answer, readMoving);
        outputView.printMap(Common.formatToPrintMap(upperBridge, underBridge));
    }

    public void moveUpperBridge(String answer, String readMoving) {
        if (answer.equals("D")) {
            upperBridge.add("   ");
            return;
        }
        if (answer.equals(readMoving)) {
            upperBridge.add(" O ");
            return;
        }
        upperBridge.add(" X ");
    }

    public void moveUnderBridge(String answer, String readMoving) {
        if (answer.equals("U")) {
            underBridge.add("   ");
            return;
        }
        if (answer.equals(readMoving)) {
            underBridge.add(" O ");
            return;
        }
        underBridge.add(" X ");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean retry() {
        String map = Common.formatToPrintMap(upperBridge, underBridge);
        String retryInput = finish(map);
        return checkRetry(retryInput);
    }

    private boolean checkRetry(String retryInput) {
        return !success.equals("성공") && !retryInput.equals("Q");
    }

    private String finish(String map) {
        String input = "";
        if (success.equals("실패")) {
            input = inputView.readGameCommand();
        }
        outputView.printResult(map, success, retryCount);
        return input;
    }

    public void reset() {
        upperBridge = new StringJoiner("|", "[", "]");
        underBridge = new StringJoiner("|", "[", "]");
        success = "성공";
        retryCount += 1;
    }
}
