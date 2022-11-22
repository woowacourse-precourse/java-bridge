package bridge;

public enum GameMsg {
    INIT_MSG("다리 건너기 게임을 시작합니다."),
    GET_LENGTH_MSG("다리의 길이를 입력해주세요."),
    GET_WAY_MSG("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_MSG("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT_MSG("최종 게임 결과"),
    SUCCESS_MSG("게임 성공 여부: "),
    TRY_COUNT_MSG("총 시도한 횟수: ");

    final private String msg;

    GameMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
