package bridge.domain.ui;

public enum ReservedMessage {
    STARTING_MESSAGE("다리 건너기 게임을 시작합니다."),
    MESSAGE_TO_GET_SIZE("다리의 길이를 입력해 주세요."),
    MESSAGE_TO_GET_SPACE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    MESSAGE_TO_GET_WHETHER_RETRY_OR_NOT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    MESSAGE_TO_PRINT_RESULT("\n최종 게임 결과"),
    WHETHER_SUCCEED_OR_NOT("게임 성공 여부: "),
    SUCCEEDED_MESSAGE("성공"),
    FAILED_MESSAGE("실패"),
    THE_NUMBER_OF_TRIAL("총 시도한 횟수: "),

    ERROR_MESSAGE("[ERROR] "),
    NOT_NUMBER_FORMAT("다리의 길이는 정수로 입력되어야 합니다."),
    SIZE_OUT_OF_BOUNDS("다리의 길이는 3 이상 20 이하여야 합니다."),
    NOT_U_OR_D("U(위 칸)와 D(아래 칸) 중 하나의 문자만 선택하여 입력해야 합니다."),
    NOT_R_OR_Q("R(재시도)와 Q(종료) 중 하나의 문자만 선택하여 입력해야 합니다.");

    private final String message;
    ReservedMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return message;
    }
}
