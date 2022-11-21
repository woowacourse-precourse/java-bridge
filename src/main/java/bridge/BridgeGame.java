package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;
    private BridgeBluePrint bluePrint;
    private BridgeMaker maker;


    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        bluePrint = makeBridgeBluePrint();
        maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView.printBridgeSizeInputStatement();
    }

    private BridgeBluePrint makeBridgeBluePrint() {
        BridgeBluePrint bluePrint = null;
        while (bluePrint == null) {
            outputView.printBridgeSizeInputStatement();
            bluePrint = makeBridgeBluePrintOrNull();
        }
        return bluePrint;
    }

    private BridgeBluePrint makeBridgeBluePrintOrNull() {
        try {
            int number = inputView.readBridgeSize();
            return new BridgeBluePrint(number);
        } catch (IllegalStateException e1) {
            outputView.printError(e1);
        } catch (IllegalArgumentException e2) {
            outputView.printError(e2);
        }
        return null;
    }

    public BridgeResult makeBridgeResult() {
        return new BridgeResult(BridgeCell.values().length);
    }

    public List<String> makeBridge() {
        return maker.makeBridge(bluePrint.getSize());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, BridgeResult result) {
        String moving = inputMoving();
        return false;
    }

    private String inputMoving() {
        String moving = null;
        while (moving == null) {
            moving = inputMovingOrNull();
        }
        return null;
    }

    private String inputMovingOrNull() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(BridgeResult result) {
        result.init();
    }

    public void endCycle(BridgeResult result) {

    }

    public void exit() {

    }
}
