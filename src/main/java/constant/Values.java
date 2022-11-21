package constant;

import java.util.Arrays;

public class Values {
    public enum BridgeCase {
        POSITIVE(1, "U", "성공", true),
        NEGATIVE(0, "D", "실패", false);
        private int flag;
        private String value;
        private String message;
        private boolean result;

        private BridgeCase(int flag, String value, String message, boolean result) {
            this.flag = flag;
            this.value = value;
            this.message = message;
            this.result = result;
        }

        public String getValue() {
            return value;
        }

        public int getFlag() {
            return flag;
        }

        public String getMessage() {
            return message;
        }

        public boolean isResult() {
            return result;
        }

        public static BridgeCase findByResult(boolean result) {
            return Arrays.stream(BridgeCase.values())
                    .filter(bridgeCase -> bridgeCase.isResult() == result)
                    .findAny().orElse(NEGATIVE);
        }

    }

    public enum MoveCase {
        UP_UP("U", "U", "O", " ", true),
        UP_DOWN("U", "D", " ", "X", false),
        DOWN_DOWN("D", "D", " ", "O", true),
        DOWN_UP("D", "U", " ", "X", false),
        EMPTY(" ", " ", " ", " ", false);
        private String value;
        private String move;
        private String up;
        private String down;
        private boolean result;

        private MoveCase(String value, String move, String up, String down, boolean result) {
            this.value = value;
            this.move = move;
            this.up = up;
            this.down = down;
            this.result = result;
        }

        public static MoveCase findByValueAndMove(String value, String move) {
            return Arrays.stream(MoveCase.values())
                    .filter(moveCase -> moveCase.getValue().equals(value) & moveCase.getMove().equals(move))
                    .findAny().orElse(EMPTY);
        }

        public String getMove() {
            return move;
        }

        public String getValue() {
            return value;
        }

        public String getUp() {
            return up;
        }

        public String getDown() {
            return down;
        }

        public boolean isResult() {
            return result;
        }
    }

    public enum Message {
        GAME_START("다리 건너기 게임을 시작합니다."),
        INPUT_SIZE("다리의 길이를 입력해주세요."),
        SELECT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        BRIDGE_OPEN("[ "),
        BRIDGE_SUCCESS("O"),
        BRIDGE_FAIL("X"),
        BRIDGE_SPLIT(" | "),
        BRIDGE_CLOSE(" ]"),
        SELECT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
        GAME_RESULT("최종 게임 결과"),
        GAME_SUCCESS("게임 성공 여부: %s"),
        SUCCESS("성공"),
        FAIL("실패"),
        GAME_TRY("총 시도한 횟수: %d"),
        ERROR_MESSAGE("[ERROR] %s"),
        ERROR_INPUT_VALUE("입력된 값: %s "),
        ERROR_SIZE("잘못된 길이를 입력했습니다. 길이는 3 이상 20 이하의 숫자여야 합니다."),
        ERROR_MOVE("잘못된 칸을 선택했습니다. (위: U, 아래: D) 둘 중 하나를 선택해야 합니다."),
        ERROR_RETRY("잘못된 값을 입력했습니다. 게임을 다시 시도할지 여부를 입력해주세요.\n(재시도: R, 종료: Q) 둘 중 하나를 선택해야 합니다."),
        ERROR_RE_INPUT("\n다시 입력해주세요.");
        private String message;

        private Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
