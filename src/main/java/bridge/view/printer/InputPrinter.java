package bridge.view.printer;

import bridge.BridgeStep;

public class InputPrinter {
    public void printInputBridgeSizeMessage() {
        System.out.println("다리 길이를 입력해주세요.");
    }

    public void printInputUserMoveCommandMessage() {
        String upCommand = BridgeStep.UP.getCommand();
        String downCommand = BridgeStep.DOWN.getCommand();
        System.out.println(String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", upCommand, downCommand));
    }
}