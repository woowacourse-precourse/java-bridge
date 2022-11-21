package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    Bridge bridge = new Bridge();

    public void inputBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        int bridgeSize = readBridgeSize(); // 다리 길이 입력
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize); // 다리 생성
        startGame(bridge); // 게임 시작
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        Message.inputBridgeSizeMessage(); // 입력 요구 문구 출력
        while (true) {
            try {
                String value = validBridgeSize();
                return Integer.parseInt(value);
            } catch (IllegalArgumentException e) {
                ErrorMessage.inputBridgeNumber();
            }
        } // end while
    }

    public String validBridgeSize() {
        String value = Console.readLine();
        if (!isBridgeSizeNumber(value)) { // 3 ~ 20이 아니면 true
            throw new IllegalArgumentException();
        }
        return value;
    }

    // 3 이상 20 이하의 숫자인지 검사
    public boolean isBridgeSizeNumber(String value) {
        final String REGEX = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^2{1}[0]{1}$";
        if (Pattern.matches(REGEX, value)) {
            return true;
        }
        return false;
    }

    public void startGame(List<String> bridgeList) {
        OutputView outputView = new OutputView();
        loopGame(bridgeList); // 게임 재시도 여부에 따라 반복
        outputView.printResult(bridge); // 최종 결과 출력
    }

    public void loopGame(List<String> bridgeList) {
        boolean loopFlag = true;
        while (loopFlag) { // 게임 재시도 여부에 따라 반복이 결정
            loopFlag = loopBridge(bridgeList); // 다리 건너기
        }
    }

    public boolean loopBridge(List<String> bridgeList) {
        OutputView outputView = new OutputView();
        for (String bridgeMove : bridgeList) {
            boolean isMove = isBridgeMove(bridgeMove); // 이동할 칸 입력 요구 & 이동에 성공했는지
            bridge = outputView.initOutputBridge(bridgeMove, isMove); // 출력 값 초기화
            if (!isMove) {
                return isGameCommand(); // 재시도 입력
            }
        }
        initGameResult(); // 게임 결과 '성공'으로 초기화
        return false;
    }

    public boolean isBridgeMove(String bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        String moving = readMoving(); // 이동할 칸 입력 요구
        boolean isMove = bridgeGame.move(bridge, moving); // 이동에 성공했는지
        return isMove;
    }

    // 재시도 검사
    public boolean isGameCommand() {
        BridgeGame bridgeGame = new BridgeGame();
        String retry = readGameCommand(); // 재시도 여부 입력
        boolean loopFlag = bridgeGame.retry(retry); // 재시도 검사
        return loopFlag;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        Message.inputSelectGameRetry();
        String retry = "";
        while (true) {
            try {
                String value = validReadGameCommand();
                return value;
            } catch (IllegalArgumentException e) {
                ErrorMessage.inputRetryError();
            }
        } // end while
    }

    public String validReadGameCommand() {
        String retry = Console.readLine();
        if (!isRetry(retry)) {
            throw new IllegalArgumentException();
        } // end if
        return retry;
    }

    public void initGameResult() {
        bridge.setGame(true);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        Message.inputMoveBridgeMessage();
        while (true) {
            try {
                String value = validReadMoving();
                return value;
            } catch (IllegalArgumentException e) {
                ErrorMessage.inputMoveBridgeError();
            }
        } // end while
    }

    public String validReadMoving() {
        String moving = Console.readLine();
        if (!isReadMoving(moving)) { // U 또는 D가 아니라면
            throw new IllegalArgumentException();
        } // end if
        return moving;
    }

    // 입력 값이 R 또는 Q 인지 검사
    public boolean isRetry(String retry) {
        if (retry.equals("R") || retry.equals("Q")) {
            return true;
        }
        return false;
    }

    // 입력 값이 U 또는 D 인지 검사
    public boolean isReadMoving(String moving) {
        if (moving.equals("U") || moving.equals("D")) {
            return true;
        }
        return false;
    }

}
