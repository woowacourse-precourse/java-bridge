package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    int countTryNumber = 1;
    List<String> upSide = new ArrayList<>();
    List<String> downSide = new ArrayList<>();
    private int bridgeNumber = 0;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        try {
            List<String> bridge = makeBridge();
            checkCorrectPath(bridge);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<String> makeBridge() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        outputView.printRequestBridgeSize();
        outputView.printBridgeSize(size);
        return bridge;
    }

    public String getMoving() {

        return inputView.readMoving();
    }

    public String getGameCommand() {
        return inputView.readGameCommand();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(List<String> bridge, String path) {
        outputView.printRequestMove();
        outputView.printUserPath(path);
        List<String> isCorrectBridge = new ArrayList<>();
        if (!bridge.get(bridgeNumber).equals(path) && path.equals("U")) {
            isCorrectBridge.add(path);
            isCorrectBridge.add("X");
        }
        if (!bridge.get(bridgeNumber).equals(path) && path.equals("D")) {
            isCorrectBridge.add(path);
            isCorrectBridge.add("X");
        }
        if (bridge.get(bridgeNumber).equals(path) && path.equals("U")) {
            isCorrectBridge.add(path);
            isCorrectBridge.add("O");
        }

        if (bridge.get(bridgeNumber).equals(path) && path.equals("D")) {
            isCorrectBridge.add(path);
            isCorrectBridge.add("O");
        }
        bridgeNumber++;
        return isCorrectBridge;
    }

    public void checkCorrectPath(List<String> bridge) {
        if (bridge.size() == upSide.size()) {
            outputView.printResult(upSide, downSide, countTryNumber);
            return;
        }

        List<String> isCorrectBridge = move(bridge, getMoving());

        if (isCorrectBridge.get(0).equals("U") && isCorrectBridge.get(1).equals("O")) {
            upSide.add("O");
            downSide.add(" ");
            outputView.printMap(upSide, downSide);
            checkCorrectPath(bridge);
        }
        if (isCorrectBridge.get(0).equals("D") && isCorrectBridge.get(1).equals("O")) {
            upSide.add(" ");
            downSide.add("O");
            outputView.printMap(upSide, downSide);
            checkCorrectPath(bridge);
        }
        if (isCorrectBridge.get(0).equals("U") && isCorrectBridge.get(1).equals("X")) {
            upSide.add("X");
            downSide.add(" ");
            outputView.printMap(upSide, downSide);
            retry(bridge, upSide, downSide);
        }
        if (isCorrectBridge.get(0).equals("U") && isCorrectBridge.get(1).equals("X")) {
            upSide.add(" ");
            downSide.add("X");
            outputView.printMap(upSide, downSide);
            retry(bridge, upSide, downSide);
        }

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge, List<String> upSide, List<String> downSide) {
        String retryOrQuit = getGameCommand();
        outputView.printRequestRetryOrQuit();
        outputView.printUserRetryOrQuit(retryOrQuit);
        if (retryOrQuit.equals("R")) {
            countTryNumber++;
            checkCorrectPath(bridge);
        }
        if (retryOrQuit.equals("Q")) {
            outputView.printResult(upSide, downSide, countTryNumber);
        }
    }
}
