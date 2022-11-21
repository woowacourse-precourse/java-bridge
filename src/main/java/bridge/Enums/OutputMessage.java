package bridge.Enums;

public enum OutputMessage {
    GAME_START_MESSAGE                ("다리 건너기 게임을 시작합니다."),
    READ_BRIDGE_SIZE_MESSAGE          ("다리 길이를 입력해주세요."),
    READ_MOVING_MESSAGE               ("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    READ_COMMAND_MESSAGE              ("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_MESSAGE               ("최종 게임 결과"),
    SUCCESS_FAIL_MESSAGE              ("게임 성공 여부: "),
    RETRY_COUNT_MESSAGE               ("총 시도한 횟수: ");

    private String message;

    OutputMessage(String message){
        this.message = message;
    }

    public void println(){
        System.out.println(this.message);
    }
}
