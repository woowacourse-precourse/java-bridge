package bridge.model;

public enum GameMessage {

    START_GAME("다리 건너기 게임을 시작합니다."),
    GET_SIZE("다리의 길이를 입력해주세요."),
    GET_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RESULT("최종 게임 결과"),
    GET_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    IS_SUCCESS("게임 성공 여부: "),
    TOTAL_TRY("총 시도한 횟수: ");

    private final String output;

    GameMessage(String output){
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
