package bridge.ui.input;

import bridge.ui.ConsolePrintable;

public enum PlaceHolderText implements ConsolePrintable {
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    READ_GAME_COMMAND("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String text;

    PlaceHolderText(String text) {
        this.text = text;
    }


    @Override
    public String toConsolePrintFormat() {
        return this.text;
    }
}
