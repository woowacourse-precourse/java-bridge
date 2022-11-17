package bridge.Controller;

import bridge.Model.BridgeDTO;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameManager {
    private BridgeDTO bridgeDTO;
    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();

    public void runGame() {
        try {
            makeBridgeGame();
            movePoint();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void makeBridgeGame() {
        outputView.printStartGame();
        outputView.printMakeBridgeSize();
        this.bridgeDTO = inputView.makeBridgeData();
    }

    public void movePoint() {
        for (int i=0;i<bridgeDTO.getSize();i++) {
            outputView.printMovePoint();
            moveProcessing(inputView.readMoving());
        }
    }

    public void moveProcessing(String wordUpDown) {
        
    }
}
