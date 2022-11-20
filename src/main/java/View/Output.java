package View;

public enum Output {

    GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH_INPUT_REQUEST("다리의 길이를 입력해주세요."),
    WHERE_TO_GO_INPUT_REQUEST("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    CONTINUE_OR_END_REQUEST("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_TITLE("최종 게임 결과"),
    WIN_OR_LOSE("게임 성공 여부: "),
    HOW_MANY_ATTEMPTS("총 시도한 횟수: ");

    private final String output;

    Output(String output) {
        this.output = output;
    }

    String getOutput() {
        return output;
    }
}
