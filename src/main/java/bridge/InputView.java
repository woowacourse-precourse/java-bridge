package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private int size;
    private String input;

    public enum BridgeSizeRange {
        MIN(3),
        MAX(20);

        private final int size;

        BridgeSizeRange(int size) {
            this.size = size;
        }

        public int getRange() {
            return size;
        }
    }

    private enum Exception {
        HEADER("[ERROR] "),
        BRIDGE_LENGTH("다리 길이는 3 이상, 20 이하의 숫자만 가능합니다."),
        MOVE_PICK("위로 이동하려면 U, 아래로 이동하려면 D를 입력해주세요."),
        RESTART_END_PICK("재시작하려면 R, 그만두려면 Q를 입력해주세요.");

        private final String expt;

        Exception(String expt) {
            this.expt = expt;
        }

        public String getExpt() {
            return expt;
        }
    }

    public enum FailChoice {
        RESTART("R"),
        QUIT("Q");

        private final String keyword;

        FailChoice(String keyword) {
            this.keyword = keyword;
        }

        public String getKeyword() {
            return keyword;
        }
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
