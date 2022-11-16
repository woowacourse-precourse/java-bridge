package bridge.view;

public enum OutputString {
    START("start", "다리 건너기 게임을 시작합니다."),
    RESULT("result", "게임 성공 여부 : "),
    TRY("try", "총 시도한 횟수 : "),
    SUCCESS("success", "성공"),
    FAIL("fail", "실패");

    private String status;
    private String print;

    OutputString(String status, String print) {
        this.status = status;
        this.print = print;
    }

}
