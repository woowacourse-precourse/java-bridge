package bridge.view;

public enum BridgeConstant {

    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_TYPE_EXCEPTION("[ERROR] 숫자를 입력해주세요."),
    INPUT_NUMBER_BOUNDARY_EXCEPTION("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_MOVEMENT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_MOVEMENT_EXCEPTION("[ERROR] U 또는 D만 입력 가능합니다."),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESTART_TYPE_EXCEPTION("[ERROR] R 또는 Q만 입력 가능합니다."),
    END_GAME_RESULT("최종 게임 결과"),
    GAME_NOT_SUCCESS("게임 성공 여부: 실패"),
    GAME_SUCCESS("게임 성공 여부: 성공"),
    TOTAL_GAME_PLAYS("총 시도한 횟수: ");

    private final String value;

    BridgeConstant(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
