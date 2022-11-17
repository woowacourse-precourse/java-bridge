package bridge.ui.output;

import bridge.ui.ConsolePrintable;

public enum PrintText implements ConsolePrintable {
    INIT_TEXT("다리 건너기 게임을 시작합니다.");

    private final String text;

    PrintText(String text) {
        this.text = text;
    }

    @Override
    public String toConsolePrintFormat() {
        return this.text;
    }
}
