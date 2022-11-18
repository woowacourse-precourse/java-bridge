package bridge;

public enum ErrorType {
    INVALID_FORMAT {
        @Override
        public String getErrorMsg() {
            return INVALID_FORMAT_MSG;
        }
    },
    INVALID_MOVE_INPUT {
        @Override
        public String getErrorMsg() {
            return INVALID_MOVE_INPUT_MSG;
        }
    },
    INVALID_RETRY_INPUT {
        @Override
        public String getErrorMsg() {
            return INVALID_RETRY_INPUT_MSG;
        }
    },

    INVALID_RANGE {
        @Override
        public String getErrorMsg () {
            return INVALID_RANGE_MSG;
        }
    };

    private static final String INVALID_FORMAT_MSG ="[ERROR] 입력이 숫자가 아닙니다.";
    private static final String INVALID_RANGE_MSG = "[ERROR] 다리 길이 입력의 범위는 3 ~ 20이어야 합니다.";
    private static final String INVALID_MOVE_INPUT_MSG = "[ERROR] 이동 입력은 'U'나 'D'가 들어와야 합니다.";
    private static final String INVALID_RETRY_INPUT_MSG = "[ERROR] 재시작 입력은 'R'이나 'Q'가 들어와야 합니다.";

    public abstract String getErrorMsg();
}
