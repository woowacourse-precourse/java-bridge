package bridge;

public enum StringEnum {
    Q("Q"),
    R("R"),
    UP("U"),
    DOWN("D"),
    O(" O "),
    X(" X "),
    BLANK("   "),
    SQUAREBRACKET_RIGTH( "]"),
    SQUAREBRACKET_LEFT( "["),
    MIDDLE("|"),
    GAME_RESULT("게임 성공 여부: "),
    GAME_RESULT_SUCCESS("성공"),
    GAME_RESULT_FAIL("실패"),
    GAME_RESUTL_ATTEMPTS("총 시도한 횟수: "),
    GAME_RESULT_FINAL("최종 게임 결과"),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_RETRYORQUITE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    INPUT_MOVIECHOICE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ERROR("[ERROR]");

    private String str;
    StringEnum(){}
    StringEnum(String s) {
        this.str = s;
    }
    public void gameResult(boolean isSuccess){
        if(isSuccess) {
            System.out.printf(GAME_RESULT_SUCCESS.getStr());
        }
        System.out.println(GAME_RESULT_FAIL.getStr());
    }
    public void printGameResult(String printUp, String printDown){
        System.out.println(printUp+SQUAREBRACKET_RIGTH.getStr());
        System.out.println(printDown+SQUAREBRACKET_RIGTH.getStr());
    }

    public String getStr() {
        return str;
    }
}
