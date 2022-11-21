package bridge.utils;

public enum GameMessage {

    GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_MAKER("다리의 길이를 입력해주세요."),
    MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q"),
    RESULT_HEADER("최종 게임 결과"),
    RESULT_IS_SUCCESS("게임 성공 여부: %s"),
    RESULT_TOTAL_TRIAL("총 시도한 횟수: %d"),
    NEW_LINE("");

    public final String message;

    GameMessage(String message){
        this.message = message;
    }
}
