package bridge;

import java.util.List;

public class BridgeController {

    InputView inputView;
    OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStartStatement();
    }

    // to do: 함수 길이 줄여아 함
    public BridgeBluePrint makeBridgeBluePrint() {
        BridgeBluePrint bluePrint = null;
        while (bluePrint == null) {
            outputView.printBridgeSizeInputStatement();
            bluePrint = makeBridgeBluePrintOrNull();
        }
        return bluePrint;
    }

    private BridgeBluePrint makeBridgeBluePrintOrNull(){
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
}
