package bridge.view.printer;

import bridge.domain.BridgeLine;
import bridge.domain.GameCommand;

public class InputPrinter {
    public void printInputBridgeSizeMessage() {
        System.out.println("다리 길이를 입력해주세요.");
    }

    public void printInputUserMoveCommandMessage() {
        System.out.println(
                String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
                        BridgeLine.UP.getCommand(), BridgeLine.DOWN.getCommand())
        );
    }

    public void printInputGameCommandMessage() {
        System.out.println(
                String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
                        GameCommand.RESTART.getCommand(),
                        GameCommand.QUIT.getCommand())
        );
    }
}