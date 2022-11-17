package bridge.message;

public enum PrintInput {

    START("다리 건너기 게임을 시작합니다.\n"),
    INPUT_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("게임 성공 여부: "),
    RESULT_NUMBER("총 시도한 횟수: ");

    private final String message;

    PrintInput (String message) {
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
