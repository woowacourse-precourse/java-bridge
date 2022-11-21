package bridge.status;

public enum CommentStatus {

    ERROR("error"),
    TOTAL_TRY("총 시도한 횟수: "),
    TOTAL_RESULT("최종 게임 결과: "),
    WELCOME_COMMENT("다리 건너기 게임을 시작합니다."),
    INPUT_COMMENT("다리 길이를 입력해 주세요."),
    FAIL_COMMENT("게임 성공 여부: 실패"),
    SUCCESS_COMMENT("게임 성공 여부: 성공"),
    REPLAY_COMMENT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    CHOOSE_BLOCK("이동할 칸을 선택해주세요. (위: U, 아래: D)");


    private String text;

    CommentStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
