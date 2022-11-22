package data;

public enum OutputForm {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    END_MESSAGE("게임 성공 여부: "),
    CNT_MESSAGE("총 시도한 횟수: "),
    FINISH_MESSAGE("최종 게임 결과");

    private final String message;


    OutputForm(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

    public void finishMessage(String success) {
        System.out.println(message + success);
    }

    public void cntMessage(int cnt) {
        System.out.println(message + cnt);
    }
}
