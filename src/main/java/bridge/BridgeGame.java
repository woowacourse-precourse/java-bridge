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
    private boolean ready;


    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        bluePrint = makeBridgeBluePrint();
        maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        ready = true;
        outputView.printBridgeSizeInputStatement();
    }

    public boolean isReady() {
        return ready;
    }

    ;

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

    public List<String> makeBridge() {
        return maker.makeBridge(bluePrint.getSize());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
