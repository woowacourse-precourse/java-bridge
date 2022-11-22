package bridge;

import bridge.view.OutputView;

public class Function {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    public static boolean validCastingBridgeSize(String BridgeSizes) {
        try {
            Integer.parseInt(BridgeSizes);
            return true;
        } catch (NumberFormatException e) {
            OutputView.printError("다리 길이로 숫자를 입력해주세요.");
        }
        return false;
    }

    public static boolean validBridgeSize(int BridgeSize) {
        try {
            if (BridgeSize < MIN_LENGTH || BridgeSize > MAX_LENGTH) {
                throw new IllegalArgumentException("올바른 다리 길이를 입력해주세요.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
        return false;
    }

    public static boolean validMoving(String Moving) {
        try {
            if (!Moving.equals("U") && !Moving.equals("D")) {
                throw new IllegalArgumentException("이동은 U 혹은 D로 입력해주세요.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
        return false;
    }

    public static boolean validGameCommand(String GameCommand) {
        try {
            if (!GameCommand.equals("R") && !GameCommand.equals("Q")) {
                throw new IllegalArgumentException("재시도 여부는 R 또는 Q로 입력해주세요.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
        return false;
    }
}
