package bridge.message;

import bridge.config.UserInput;

public enum OutputMessage {
    START_GAME("다리 건너기 게임을 시작합니다."),
    ASK_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ASK_MOVE("이동할 칸을 선택해주세요. (위: "+UserInput.UP.getValue()
            +", 아래: "+UserInput.DOWN.getValue()+")"),
    ASK_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: "+UserInput.RETRY.getValue()
            +", 종료: "+UserInput.QUIT.getValue()+")"),
    FINAL_STATE("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부: %s\n총 시도한 횟수: %d\n");

    public final String value;

    OutputMessage(String value) {
        this.value = value;
    }
}
