package constant;

public class Values {
    public enum BridgeCase {
        POSITIVE(1, "U"),
        NEGATIVE(0, "D");
        private int flag;
        private String value;

        private BridgeCase(int flag, String value) {
            this.flag = flag;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getFlag() {
            return flag;
        }

    }

    public enum Message {
        GAME_START("다리 건너기 게임을 시작합니다."),
        INPUT_LENGTH("다리의 길이를 입력해주세요."),
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
        GAME_TRY("총 시도한 횟수: %d");
        private String message;

        private Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
