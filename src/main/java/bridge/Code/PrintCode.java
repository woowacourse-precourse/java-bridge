package bridge.Code;

public enum PrintCode {

    GAME_START("다리 건너기 게임을 시작합니다."),
    GET_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    GET_SPACE_TO_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GET_TRY_AGAIN("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RETURN_FINAL_RESULT("최종 게임 결과"),
    RETURN_IS_SUCCESSFUL("게임 성공 여부: "),
    RETURN_TRY_COUNT("총 시도한 횟수: ");

    private String message;

    private PrintCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}