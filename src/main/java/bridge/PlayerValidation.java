package bridge;

public class PlayerValidation {
    public int checkNum(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            System.out.println(GameMessage.ERROR_MESSAGE + GameMessage.ERROR_CHECKNUM);
            return 0;
        }
    }

    public int checkBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(GameMessage.ERROR_MESSAGE + GameMessage.ERROR_CHECKSIZE);
        }
        return bridgeSize;
    }

    public boolean moveValidation(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException(GameMessage.ERROR_MESSAGE + GameMessage.ERROR_CHECKMOVING);
        }
        return true;
    }

    public boolean endValidation(String endGame) {
        if (!endGame.equals("R") && !endGame.equals("Q")) {
            throw new IllegalArgumentException(GameMessage.ERROR_MESSAGE + GameMessage.ERROR_CHECKEND);
        }
        return true;
    }
}
