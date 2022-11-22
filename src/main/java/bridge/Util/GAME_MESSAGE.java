package bridge.Util;

public enum GAME_MESSAGE {
    INITIALIZE("다리 건너기 게임을 시작합니다.\n" +
            "\n" +
            "다리의 길이를 입력해주세요."),
    CHOOSE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    CHOOSE_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    ENDING("최종 게임 결과"),
    ENDING_RESULT("게임 성공 여부: %s\n" +
            "총 시도한 횟수: %d"),
    SUCCESS("성공"),
    FAIL("실패");


    private String message;

    GAME_MESSAGE(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
