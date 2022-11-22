package bridge.domain;

public enum Command {
    RESTART("R"), QUIT("Q");

    private final String signal;

    Command(String signal) {
        this.signal = signal;
    }

    /**
     * 문자열 형태의 명령을 받아 Enum class 로 반환하는 메서드
     * @param command 재시작 명령
     * @return Enum class
     */
    public static Command of(String command) {
        if (command.equals(RESTART.signal)) {
            return RESTART;
        }
        return QUIT;
    }
}
