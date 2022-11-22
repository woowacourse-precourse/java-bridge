package bridge;


public class MessageGenerator {

    private static final MessageGenerator instance = new MessageGenerator();
    public static final String GAME_FINISH_HEADER_MSG = "최종 게임 결과";
    public static final String GAME_FINISH_RESULT_SUCCESS_MSG = "게임 성공 여부: 성공";
    public static final String GAME_FINISH_RESULT_FAIL_MSG = "게임 성공 여부: 실패";
    public static final String GAME_FINISH_TOTAL_TRY_MSG = "총 시도한 횟수: ";

    private MessageGenerator() {
    }

    public static MessageGenerator getInstance() {
        return instance;
    }
}
