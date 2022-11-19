package bridge.util;

public class Constants {

    public enum OutputViewConstants {
        BRIDGE_START("["),
        BRIDGE_END("]"),
        UP("U"),
        DOWN("D"),
        ZERO_AND_STICK(" O |"),
        STICK("   |"),
        ZERO(" O "),
        EMPTY("   "),
        X(" X "),

        START_BRIDGE_GAME("다리 건너기 게임을 시작합니다."),
        INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
        INPUT_SELECT_MOVE_BLOCK("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        WHETHER_GAME_CLEAR("게임 성공 여부: "),
        RETRY_COUNT("총 시도한 횟수: "),
        SUCCESS("성공"),
        FAIL("실패"),
        GAME_RESULT("최종 게임 결과");

        private final String message;

        OutputViewConstants(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum InputViewConstants {
        RESTART_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
        RESTART("R"),
        QUIT("Q");

        private final String message;

        InputViewConstants(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
