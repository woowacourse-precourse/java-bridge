package bridge.util.message;

public enum GameMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    CHOICE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_FINAL_RESULT("최종 게임 결과"),
    TOTAL_TRY_COUNT("총 시도한 횟수: "),
    SUCCESS_OR_FAIL("게임 성공 여부: ");

    private String message;

    GameMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
