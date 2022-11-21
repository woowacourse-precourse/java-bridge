package bridge.controller;

import bridge.model.validation.BridgeSize;
import bridge.model.validation.Command;
import bridge.model.validation.Move;
import bridge.view.InputView;

public class InputController {
    private final InputView inputView = new InputView();

    public int getBridgeSize() {
        try {
            return BridgeSize.checkRange(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }

    public Move getMove(){
        try{
            return Move.of(inputView.readMoving());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getMove();
        }
    }

    public Command getCommand(){
        try{
            return Command.of(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCommand();
        }
    }
}
