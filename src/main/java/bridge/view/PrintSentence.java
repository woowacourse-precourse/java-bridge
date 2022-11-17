package bridge.view;

public enum PrintSentence {
    START("다리 건너기 게임을 시작합니다.\n"),
    LENGHT_REQUEST("다리의 길이를 입력해주세요."),
    MOVE_REQUEST("\n이동할 칸을 선택하세요. (위: U, 아래: D)"),
    CORRECT("O"),
    INCORRECT("X"),
    RESTART_REQUEST("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R,종료: Q)"),
    LEFT_WALL("[ "),
    RIGHT_WALL(" ]"),
    MIDDLE_WALL(" | "),
    WIN("\n게임 성공 여부: 성공"),
    LOSE("\n게임 성공 여부 : 실패"),
    RESULT("총 시도한 횟수: ");

    private String sentence;

    PrintSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

}
