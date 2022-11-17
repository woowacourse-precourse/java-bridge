package bridge;

public class InputController {

    InputView inputView = new InputView();

    public int getBridgeSize() {
        try {
            String size = inputView.readBridgeSize();
            new BridgeSizeValidator(size);
            return Integer.parseInt(size);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getBridgeSize();
        }
    }

    public String getMoving(){
        try{
            String moving = inputView.readMoving();
            new MovingValidator(moving);
            return moving;
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getMoving();
        }
    }

}
