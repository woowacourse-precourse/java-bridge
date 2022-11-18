package bridge.UI.Input;

public class InputWhileException {

    public int startWhileReadBridgeSize() {
        CombineInput combineInput = new CombineInput();
        int userInput;
        while (true) {
            try { userInput = combineInput.startReadBridgeSize(); }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return userInput;
        }
    }

    public String startWhileReadMoving() {
        CombineInput combineInput = new CombineInput();
        String userInput;
        while (true) {
            try { userInput = combineInput.startReadMoving(); }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return userInput;
        }
    }

    public String startWhileReadGameCommand() {
        CombineInput combineInput = new CombineInput();
        String userInput;
        while (true) {
            try { userInput = combineInput.startReadGameCommand(); }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return userInput;
        }
    }

}
