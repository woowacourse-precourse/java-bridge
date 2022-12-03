package bridge.utils.constants;

public enum OutputMessage{
    END_GAME_MESSAGE("최종 게임 결과"),
    GAME_RESULT_MESSAGE("게임 성공 여부: "),
    TOTAL_ATTEMPT_MESSAGE("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    OutputMessage(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}