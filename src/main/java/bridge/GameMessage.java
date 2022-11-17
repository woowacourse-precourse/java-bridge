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

}
