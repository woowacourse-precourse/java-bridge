package bridge;

public enum Error {
    IS_WRONG_COMMAND("게임 커맨드는 R(재시작) 또는 E(종료)만 입력 가능합니다."),

    IS_NOT_POSSIBLE_MOVING("다리는 U(위 칸) 또는 D(아래 칸)로만 이동 가능합니다."),
    IS_WRONG_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }
}
