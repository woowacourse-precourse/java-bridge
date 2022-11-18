package bridge;


import static bridge.Constants.MAX_BRIDGE_SIZE;
import static bridge.Constants.MIN_BRIDGE_SIZE;

import java.util.Objects;

public class ErrorControl {
    public static boolean validateNumberOrNot(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
        }
        return false;
    }

    public static boolean validateBridgeSize(boolean pass, String input) {
        if (pass) {
            int bridgeSize = Integer.parseInt(input);
            if (bridgeSize < MIN_BRIDGE_SIZE | bridgeSize > MAX_BRIDGE_SIZE) {
                System.out.println("[ERROR] "+ MIN_BRIDGE_SIZE +"이상 "+MAX_BRIDGE_SIZE+"이하의 숫자를 입력해 주세요.");
                return false;
            }
        }
        return pass;
    }

    public static boolean validateLetter(String input, String verifier1, String verifier2) {
        if (!(Objects.equals(input, verifier1) | Objects.equals(input, verifier2))) {
            System.out.println("[ERROR] " + verifier1 + "," + verifier2 + " 중 하나를 입력해 주세요.");
            return false;
        }
        return true;
    }
}
