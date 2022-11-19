package bridge.ui.output;

import bridge.ui.ConsolePrintable;

public enum PrintText implements ConsolePrintable {
    INIT_TEXT("다리 건너기 게임을 시작합니다."),
    GAME_RESULT_TEXT("최종 게임 결과"),
    GAME_CLEAR_TEXT("게임 성공 여부: 성공"),
    GAME_FAIL_TEXT("게임 성공 여부: 실패"),
    GAME_TRIAL_TEXT("총 시도한 횟수: ");

    private final String text;

    PrintText(String text) {
        this.text = text;
    }

    @Override
    public String toConsolePrintFormat() {
        return this.text;
    }
}
