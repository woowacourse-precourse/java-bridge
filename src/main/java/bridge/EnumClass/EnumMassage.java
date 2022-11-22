package bridge.EnumClass;

public enum EnumMassage {
    Error_length("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    Unvalidate("[ERROR] 입력값 형식에 올바르지 않습니다."),
    Start("다리 건너기 게임을 시작합니다.\n" + "\n" + "다리의 길이를 입력해주세요."),
    Select_Moving("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    Select_Retry("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    Finish("최종 게임 결과"),
    Result("게임 성공 여부: %s\n" + "총 시도한 횟수: %d");

    private String message;

    EnumMassage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
