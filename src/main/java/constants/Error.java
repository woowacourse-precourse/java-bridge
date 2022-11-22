package constants;

public enum Error {
    INPUT_RANGE_OUT("다리 길이는 3 부터 20 사이의 숫자여야 합니다."),
    INPUT_MOVING("이동할 칸은 U(위 칸), D(아래 칸) 중 하나의 문자여야 합니다."),
    INPUT_GAME_COMMAND("재시작/종료 여부는 R(재시작), Q(종료) 중 하나의 문자여야 합니다.");

    private final String msg;
    private final String start_msg = "[ERROR]";

    Error(String msg) {
        this.msg = start_msg + msg;
    }

    public String getMsg() {
        return msg;
    }
}