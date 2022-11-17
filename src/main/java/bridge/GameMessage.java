package bridge;

public class GameMessage {

    public static final String IS_ERROR = "[ERROR] ";
    public static final String LINE_BREAK = "\n";

    public enum Guide {
        START("다리 건너기 게임을 시작합니다."),
        ENTER_LENGTH("다리의 길이를 입력해주세요."),
        CHOOSE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        ASK_RE_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        private final String contents;

        Guide(String contents) {
            this.contents = contents;
        }

        public String getContents() {
            return contents;
        }
    }

    public enum Result {
        FINAL_GAME_RESULT("최종 게임 결과"),
        SUCCESS_OR_NOT("게임 성공 여부: "),
        SUCCESS("성공"),
        FAIL("실패"),
        TOTAL_TRY("총 시도한 횟수: %d");
        private final String contents;

        Result(String contents) {
            this.contents = contents;
        }

        public String getContents() {
            return contents;
        }
    }

}
