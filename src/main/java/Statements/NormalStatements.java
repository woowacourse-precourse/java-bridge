package Statements;

public enum NormalStatements {
    GAME_START ("다리 건너기 게임을 시작합니다."),
    ASK_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    ASK_TILE_TO_MOVE_ON("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ASK_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    DECLARE_RESULT("최종 게임 결과"),
    RESULT_SUCCESS("게임 성공 여부: 성공"),
    RESULT_FAIL("게임 성공 여부: 실패"),
    SHOW_GAME_TRIALS("총 시도한 횟수: "),
    LEFT_TILE("[ "),
    RIGHT_TILE(" ]"),
    MIDDLE_TILE(" | ");

    private final String saying;
    NormalStatements(String saying){
        this.saying=saying;
    }

    public String getNormalStatement(){
        return saying;
    }
}
