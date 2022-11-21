package bridge.view;

public enum Message {

    START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_BRIDGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_REPORT("최종 게임 결과"),
    ;

    private String text;

    Message(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return this.text;
    }
}
