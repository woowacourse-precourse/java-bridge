package bridge;

public enum UserInterface {

    START("다리 건너기 게임을 시작합니다."),
    INSERT_SIZE("다리의 길이를 입력해주세요."),
    SELECT_ROW("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RE_TRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    RESULT("최종 게임 결과\n"),
    SUCCESSFUL("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    TRY_COUNT("총 시도한 횟수: "),

    INVALID_EXCEPTION("[ERROR] 잘못된 값이 입력되었습니다. 이동 가능한 입력은 'U', 'D', 'R', 'Q' 입니다."),
    RANGE_OUT_OF_EXCEPTION("[ERROR] 입력 가능한 다리 길이는 3~20 입니다.");


    private final String userInterface;

    UserInterface(String userInterface) {

        this.userInterface = userInterface;

    }

    public String interact() {
        return userInterface;
    }


}
