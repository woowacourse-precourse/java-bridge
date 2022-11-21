package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private Bridge bridge = new Bridge();

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
                String value = inputBridgeSize();
                return Integer.parseInt(value);
            } catch (IllegalArgumentException e) {
                ErrorMessage.inputBridgeNumber();
            }
        } // end while
    }

    public String inputBridgeSize() {
        Valid valid = new Valid();
        String value = Console.readLine();
        valid.validBridgeSize(value);
        return value;
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
            boolean isMove = isBridge(bridgeMove, outputView);
            if (!isMove) {
                return isGameCommand(); // 재시도 입력
            }
        }
        initGameResult(); // 게임 결과 '성공'으로 초기화
        return false;
    }

    public boolean isBridge(String bridgeMove, OutputView outputView){
        boolean isMove = isBridgeMove(bridgeMove); // 이동할 칸 입력 요구 & 이동에 성공했는지
        bridge = outputView.initOutputBridge(bridgeMove, isMove); // 출력 값 초기화
        return isMove;
    }

    public boolean isBridgeMove(String bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        String moving = readMoving(); // 이동할 칸 입력 요구
        boolean isMove = bridgeGame.move(bridge, moving); // 이동에 성공했는지
        return isMove;
    }

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
        while (true) {
            try {
                String value = inputReadGameCommand();
                return value;
            } catch (IllegalArgumentException e) {
                ErrorMessage.inputRetryError();
            }
        } // end while
    }

    public String inputReadGameCommand() {
        Valid valid = new Valid();
        String retry = Console.readLine();
        valid.validReadGameCommand(retry);
        return retry;
    }

    public void initGameResult() {
        bridge.setGame(true);
    } // 게임 결과 초기화

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        Message.inputMoveBridgeMessage();
        while (true) {
            try {
                String value = inputReadMoving();
                return value;
            } catch (IllegalArgumentException e) {
                ErrorMessage.inputMoveBridgeError();
            }
        } // end while
    }

    public String inputReadMoving() {
        Valid valid = new Valid();
        String moving = Console.readLine();
        valid.validReadMoving(moving);
        return moving;
    }

}
