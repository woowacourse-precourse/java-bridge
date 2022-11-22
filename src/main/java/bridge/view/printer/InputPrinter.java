package bridge.view.printer;

import bridge.domain.type.BridgeLineType;
import bridge.domain.type.GameCommandType;

public class InputPrinter {
    public void printInputBridgeSizeMessage() {
        System.out.println("다리 길이를 입력해주세요.");
    }

    public void printInputUserMoveCommandMessage() {
        System.out.printf("이동할 칸을 선택해주세요. (위: %s, 아래: %s)%n",
                BridgeLineType.UP.getCommand(), BridgeLineType.DOWN.getCommand());
    }

    public void printInputGameCommandMessage() {
        System.out.printf("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)%n",
                GameCommandType.RESTART.getCommand(),
                GameCommandType.QUIT.getCommand());
    }
}