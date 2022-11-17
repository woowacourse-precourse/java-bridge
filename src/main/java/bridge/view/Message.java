package bridge.view;

public enum Message {
    GAME_START("다리 건너기 게임을 시작합니다.\n"),
    GET_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    CHOOSE_UP_OR_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    CHOOSE_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_FAIL("게임 성공 여부: 실패"),
    GAME_SUCCESS("게임 성공 여부: 성공"),
    NUMBER_OF_TRY("총 시도한 횟수: ");

    private String msg;
    Message(String msg){
        this.msg = msg;
    }
    public String toString(){
        return this.msg;
    }
}
