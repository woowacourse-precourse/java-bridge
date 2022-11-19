package bridge.ui.input;

import bridge.ui.ConsolePrintable;

public enum PlaceHolderText implements ConsolePrintable {
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    READ_MOVE_COMMAND("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    READ_RESTART_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String text;

    PlaceHolderText(String text) {
        this.text = text;
    }


    @Override
    public String toConsolePrintFormat() {
        return this.text;
    }
}
