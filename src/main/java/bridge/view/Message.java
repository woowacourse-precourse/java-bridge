package bridge.view;

public enum Message {
    START("다리 건너기 게임을 시작합니다."),
    PUT_LENGTH("다리의 길이를 입력해 주세요."),
    PUT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    COMPLETION("게임 성공 여부: "),
    TRY_COUNT("총 시도한 횟수: ");

    final String msg;

    Message(String msg) {
        this.msg = msg;
    }
}