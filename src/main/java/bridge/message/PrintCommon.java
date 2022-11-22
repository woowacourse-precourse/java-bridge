package bridge.message;

public enum PrintCommon {

    START("다리 건너기 게임을 시작합니다."),
    INPUT_SIZE("\n다리의 길이를 입력해주세요."),
    INPUT_MOVING("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("\n게임 성공 여부: "),
    RESULT_NUMBER("총 시도한 횟수: ");

    private final String message;

    PrintCommon(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }

    @Override
    public String toString () {
        return this.message;
    }
}
