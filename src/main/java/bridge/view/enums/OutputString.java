package bridge.view.enums;

public enum OutputString {
    START("다리 건너기 게임을 시작합니다."),
    INPUT("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위 : U, 아래 : D)"),
    RESULT("게임 성공 여부: "),
    TRY("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패"),
    RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : Q)"),
    LAST("최종 게임 결과");


    private String print;

    OutputString(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
