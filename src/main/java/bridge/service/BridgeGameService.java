package bridge.service;

public class BridgeGameService {

    public void isValidBridgeRange(int bridgeSize) {
        if (bridgeSize <= 3 || bridgeSize >= 20) {
            System.out.println("[ERROR] 다리 크기가 3~20이 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    public void isValidMovingInput(String move) {
        if (move.equals("U") || move.equals(("D"))) {
            System.out.println("[ERROR] 다리 이동엔 U 또는 D만을 입력해야합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void isValidCommand(String command) {
        if (command.equals("R") || command.equals("Q")) {
            System.out.println("[ERROR] 게임 재시작 여부엔 R 또는 Q만을 입력해야합니다.");
        }
    }
}
