package exception;

import bridge.OutputView;

public class CustomException {

    private OutputView outputView = new OutputView();

    public boolean checkBridgeSize(int bridgeSize) {
        if (bridgeSize >= 3 && bridgeSize <= 20) return true;
        outputView.printExceptionMessage(ExceptionMessage.INVALID_BRIDGE_SIZE);
        return false;
    }

    public boolean checkMove(String input) {
        if (input.equals("U") || input.equals("D")) return true;
        return false;
    }

    public boolean checkGameCommand(String input) {
        if (input.equals("R") || input.equals("Q")) return true;
        return false;
    }
}
