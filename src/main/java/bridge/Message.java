package bridge;

public enum Message {

    GAME_START("다리 건너기 게임을 시작합니다."),
    LENGTH_INPUT("다리의 길이를 입력해주세요."),
    MOVE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS("게임 성공 여부: "),
    GAME_TRIAL("총 시도한 횟수: "),


    ERROR_LENGTH("[ERROR] 다리 길이는 3에서 20 사이의 숫자여야 합니다."),
    ERROR_MOVE("[ERROR] 이동할 칸은 U(위) 또는 D(아래)여야 합니다."),
    ERROR_RETRY("[ERROR] 게임 재시작/종료 여부는 R(재시도) 또는 Q(종료)여야 합니다.");

    private final String message;

    Message(String s) {
        this.message = s;
    }

    public void print() {
        System.out.println(message);
    }

    public String getMessage() {
        return this.message;
    }
}
