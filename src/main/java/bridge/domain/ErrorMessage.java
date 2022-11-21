package bridge.domain;

import static bridge.utils.Constants.BRIDGE_MIN_SIZE;
import static bridge.utils.Constants.BRIDGE_MAX_SIZE;

public enum ErrorMessage {
    HEADER {
        @Override
        public String toString() {
            return "[ERROR] ";
        }
    },
    BRIDGE_SIZE_INCORRECT_INPUT {
        @Override
        public String toString() {
            return HEADER + "다리 길이에는 숫자가 아닌 문자가 포함될 수 없습니다.";
        }
    },
    BRIDGE_INCORRECT_SIZE {
        @Override
        public String toString() {
            return HEADER + "다리 길이는 " + BRIDGE_MIN_SIZE + "부터 " + BRIDGE_MAX_SIZE + " 사이의 숫자여야 합니다.";
        }
    },

}
