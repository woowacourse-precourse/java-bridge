package bridge;

public class UpDownBridge {
    public static StringBuffer upBridge = new StringBuffer();
    public static StringBuffer downBridge = new StringBuffer();

    public static void makeUpDownBridge(String inputDirection, String moveResult) {
        addUpBridge(inputDirection, moveResult);
        addDownBridge(inputDirection, moveResult);
    }

    public static void addUpBridge(String inputDirection, String moveResult) {
        if(inputDirection.equals(Message.UP.getMessage())) {
            upBridge.append(moveResult + Message.CENTER_BAR.getMessage());
            downBridge.append(Message.BLANK.getMessage() + Message.CENTER_BAR.getMessage());
        }
    }

    public static void addDownBridge(String inputDirection, String moveResult) {
        if(inputDirection.equals(Message.Down.getMessage())) {
            upBridge.append(Message.BLANK.getMessage() + Message.CENTER_BAR.getMessage());
            downBridge.append(moveResult + Message.CENTER_BAR.getMessage());
        }
    }
}
