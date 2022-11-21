package bridge.domain;

import static bridge.utils.Constants.BRIDGE_MIN_SIZE;
import static bridge.utils.Constants.BRIDGE_MAX_SIZE;
import static bridge.utils.Constants.QUIT;
import static bridge.utils.Constants.RESTART;
import static bridge.utils.Constants.UP;
import static bridge.utils.Constants.DOWN;

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
    MOVING_INCORRECT_INPUT {
        @Override
        public String toString() {
            return HEADER + "이동할 칸은 '" + UP + "'(위 칸) 또는 '" + DOWN + "'(아래 칸)만 선택 가능합니다.";
        }
    },
    GAME_COMMAND_INCORRECT_INPUT {
        @Override
        public String toString() {
            return HEADER + "종료/재시작 여부는 '" + RESTART + "'(재시작) 또는 '" + QUIT + "'(종료)만 선택 가능합니다.";
        }
    }

}
