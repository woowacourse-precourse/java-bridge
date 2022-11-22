package bridge;

public class ExceptionCase {
    public int validateBridgeSizeIsInteger(String bridgeSizeString) {
        try {
            return Integer.parseInt(bridgeSizeString);
        }
        catch (NumberFormatException error){
            System.out.println("[ERROR] 숫자는 정수형으로 하나만 입력하시야 합니다.\n");
            return new InputView().readBridgeSize();
        }
    }

    public int validateBridgeSizeInRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            System.out.println("[ERROR] 다리 길이는 3-20 범위만 입력이 가능합니다.\n");
            return new InputView().readBridgeSize();
        }
        return bridgeSize;
    }

    public String validateMoves(String moves) {
        if (!moves.equals("U") && !moves.equals("D")) {
            System.out.println("[ERROR] 움직임은 \"U\" 와 \"D\" 한 글자만 입력이 가능합니다.\n");
            return new InputView().readMoving();
        }
        return moves;
    }


}
