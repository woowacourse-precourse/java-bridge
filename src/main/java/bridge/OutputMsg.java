package bridge;

public enum OutputMsg {
    START_MSG("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH_MSG("다리의 길이를 입력해주세요."),
    CHOOSE_UPDOWN_MSG("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    CHOOSE_RETRY_QUIT_MSG("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    ISSUCCESS_MSG("게임 성공 여부: "),
    SUM_OF_RETRY_COUNT("총 시도한 횟수: "),
    RESULT_MSG("최종 게임 결과");

    private final String msg;
    OutputMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
}
