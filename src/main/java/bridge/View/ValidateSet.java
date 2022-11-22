package bridge.View;

public class ValidateSet extends InputValidate {

    public void Bridge(String size) {
        IsCorrectFormatBridgeSize(size);
        IsOverRangeBridgeSize(size);
        IsNoneInputBridgeSize(size);
    }

    public void Computer(int input) {
        IsZeroOrOneComputerBridge(input);
    }

    public void User(String input) {
        IsNoneInputUserBridge(input);
        IsUorDByUserBridge(input);
    }

    public void reGame(String input) {
        throw new IllegalArgumentException(input);
    }
}
