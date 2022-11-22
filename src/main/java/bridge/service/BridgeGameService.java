package bridge.service;

public class BridgeGameService {

    public void isNumericInput(String input) {
        try {
            if (!input.matches("-?\\d+")) {
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 입력한 길이 값이 정수가 아닙니다.");
        }
    }
    public void isValidBridgeRange(int bridgeSize) {
        try {
            if (bridgeSize <= 3 || bridgeSize >= 20) {
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 크기가 3~20이 아닙니다.");
        }
    }

    public void isValidMovingInput(String move) {
        try {
            if (move.equals("U") || move.equals(("D"))) {
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 이동엔 U 또는 D만을 입력해야합니다.");
        }
    }

    public void isValidCommand(String command) {
        try{
            if (command.equals("R") || command.equals("Q")) {
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 게임 재시작 여부엔 R 또는 Q만을 입력해야합니다.");
        }
    }
}
