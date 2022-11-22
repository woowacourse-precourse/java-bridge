package message;

public class InputMessage {
    public static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVE_SIDE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_GAME_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String TOTAL_RESULT = "최종 게임 결과";
    public static final String IS_SUCCESS_GAME = "게임 성공 여부: ";
    public static final String TOTAL_TRY = "총 시도한 횟수: ";

    public static void print(String sentence) {
        System.out.println(sentence);
    }

    public static void gameOver(String isSucess, int totalTry) {
        System.out.println(IS_SUCCESS_GAME + isSucess);
        System.out.println(TOTAL_TRY + totalTry);
    }



}
