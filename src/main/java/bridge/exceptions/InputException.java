package bridge.exceptions;

public class InputException {
    public static void  bridgeSizeNotNumber(String bridgeSizeInput) {
        for (int i = 0; i < bridgeSizeInput.length(); i++)
            if (!Character.isDigit(bridgeSizeInput.charAt(i)))
                throw new IllegalArgumentException();
    }

    public static void bridgeSizeOutOfRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20)
            throw new IllegalArgumentException();
    }
}
