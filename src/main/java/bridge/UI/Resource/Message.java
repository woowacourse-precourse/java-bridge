package bridge.UI.Resource;
/**
 * 게임 진행을 위해 필요한 메시지를 저장하는 역할을 한다.
 */
public enum Message {
    Game_Start("다리 건너기 게임을 시작합니다.\n"),
    Bridge_Size_Input("다리의 길이를 입력해주세요."),
    Move_Input("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    Restart_Input("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    ResultMessage("최종 게임 결과"),
    GameResult("게임 성공 여부: "),
    Trials("총 시도한 횟수: ");
    private String message;
    Message(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
