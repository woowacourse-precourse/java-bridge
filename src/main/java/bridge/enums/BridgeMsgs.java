package bridge.enums;

public enum BridgeMsgs {

    INPUT_BRIDGET_LENGTH_MSG("다리의 길이를 입력해주세요."),
    INPUT_MOVEMENT_MSG("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_MSG("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    BRIDGE_LENGTH_ERR_MSG("[ERROR] 다리 길이는 3에서 20사이의 숫자만 가능합니다."),
    FIELD_INPUTVALUE_ERR_MSG("[ERROR] 이동 칸은 U 또는 D만 입력 가능합니다."),
    RETRY_INPUTVALUE_ERR_MSG("[ERROR] 재시작은 R, 종료는 Q를 입력해주세요."),

    FINAL_RESULT_MSG("최종 게임 결과"),
    FINAL_GAME_SUCCESS_MSG("게임 성공 여부: "),
    FINAL_GAME_TRY_MSG("총 시도한 횟수: ");

    private final String value;

    BridgeMsgs(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }


}
