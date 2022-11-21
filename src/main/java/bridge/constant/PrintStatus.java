package bridge.constant;

public enum PrintStatus {
    GameStart("다리 건너기 게임을 시작합니다."),
    InputBridgeLength("다리의 길이를 입력해주세요."),
    BringMove("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ReTryStart("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    ResGame("최종 게임 결과"),
    GameSuccessOrNot("게임 성공 여부: "),
    TotalGame("총 시도한 횟수: ");

    private final String des;
    private final String failed = "실패";
    private final String success = "성공";

    PrintStatus(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }
}
