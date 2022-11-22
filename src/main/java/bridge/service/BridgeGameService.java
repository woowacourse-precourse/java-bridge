package bridge.service;

import bridge.config.OutputConfig;

public class BridgeGameService extends OutputConfig {

    public Boolean isNumericInput(String input) {
        Boolean isNumeric=true;
        try {
            if (!input.matches("-?\\d+")) {
                isNumeric = false;
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MEESAGE+" 입력한 길이 값이 정수가 아닙니다.");
        }
        return isNumeric;
    }
    public Boolean isValidBridgeRange(int bridgeSize) {
        Boolean isValid=true;
        try {
            if (bridgeSize < 3 || bridgeSize > 20) {
                isValid=false;
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MEESAGE+" 다리 크기가 3~20이 아닙니다.");
        }
        return isValid;
    }

    public Boolean isValidMovingInput(String move) {
        Boolean isValid=true;
        try {
            if (!move.equals("U") && !move.equals(("D"))) {
                isValid=false;
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MEESAGE+" 다리 이동엔 U 또는 D만을 입력해야합니다.");
        }
        return isValid;
    }

    public Boolean isValidCommand(String command) {
        Boolean isValid=true;
        try{
            if (!command.equals("R") && !command.equals("Q")) {
                isValid=false;
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MEESAGE+" 게임 재시작 여부엔 R 또는 Q만을 입력해야합니다.");
        }
        return isValid;
    }
}
