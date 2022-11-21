package data;

public enum InputGuide {
    WELCOME("다리 건너기 게임을 시작합니다."),
    SIZE("다리의 길이를 입력해 주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: " + BridgeData.UP + ", 아래: " + BridgeData.DOWN + ")"),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + BridgeData.RESTART + ", 종료: " + BridgeData.QUIT + ")"),
    RESULT("최종 게임 결과"),
    SUCCESS("게임 성공 여부: "),
    ATTEMPT("총 시도한 횟수: ");

    private final String guider;

    private InputGuide(String guider){
        this.guider = guider;
    }

    public void printGuide(){
        System.out.print(guider);
    }

    public void printGuideWithLine(){
        System.out.println(guider);
    }
}
