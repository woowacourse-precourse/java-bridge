package bridge;

import bridge.exception.CheckBridgeLengthException;

import java.util.ArrayList;
import java.util.List;

import static bridge.ErrorCheck.isRestart;
import static bridge.ErrorCheck.isUpDown;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    private static final String IS_ERROR = "e";
    private static final String BRIDGE_ERROR = "E";
    private static final int ERROR = 99;
    public static List<String> bridgeDraw = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printInputMovement();
        String inputMove = inputView.readMoving();
        //System.out.println(inputMove);
        int checkUpDown = isUpDown(inputMove);
        if (checkUpDown == ERROR)
            return BRIDGE_ERROR;
        //System.out.println("입력완료");
        return inputMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.printRetry();
        String inputRetry = inputView.readGameCommand();
        int checkRetryQuit = isRestart(inputRetry);
        if (checkRetryQuit == ERROR)
            return ERROR;
        if (inputRetry.equals(RETRY)) {
            int runReturn = run();
            if (runReturn == ONE)
                return ONE;
            if (runReturn == ERROR)
                return ERROR;
        }
        if (inputRetry.equals(QUIT))
            return TWO;
        return ZERO;
    }

    public int run() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeNumberGenerator() {
            @Override
            public int generate() {
                return bridgeRandomNumberGenerator.generate();
            }
        };
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        outputView.printStart();
        outputView.printInputBridgeLength();
        bridgeDraw.clear();
        int bridgeSize = inputView.readBridgeSize();
        if (bridgeSize == ERROR)
            return ERROR;
        if (bridgeSize != ZERO) {
            bridgeDraw.addAll(bridgeMaker.makeBridge(bridgeSize));
            if (bridgeDraw.contains(BRIDGE_ERROR))
                return ERROR;
            if (bridgeDraw.contains(IS_ERROR)) {
                return ONE;
            }
            return ZERO;
        }
        return ERROR;
    }

    public void callFinalPrint() {
        bridgeDraw.remove(IS_ERROR);
        OutputView outputView = new OutputView();
        outputView.printMap(bridgeDraw);
    }
}
