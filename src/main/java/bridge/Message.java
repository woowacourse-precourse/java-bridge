package bridge;

public enum Message {

    MSG_START("다리 건너기 게임을 시작합니다."),
    MSG_GET_LENGTH("다리의 길이를 입력해 주세요."),
    MSG_GET_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    MSG_GET_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    ERROR_INT("[ERROR] 다리 길이는 숫자여야 합니다. 다시 입력해 주세요."),
    ERROR_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. 다시 입력해 주세요."),
    ERROR_MOVE("[ERROR] 입력은 U 혹은 D여야 합니다. 다시 입력해 주세요. (위: U, 아래: D)"),
    ERROR_RETRY("[ERROR] 입력은 R 혹은 Q여야 합니다. 다시 입력해 주세요. (재시도: R, 종료: Q)");

    private String message;

    Message(String message) {this.message = message;}

    public String getMessage() {return message;}
}
