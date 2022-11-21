package bridge;

public class Constants {
    public enum Messages {
        START("다리 건너기 게임을 시작합니다.%n"),
        BRIDGE("%n다리의 길이를 입력해주세요.%n"),
        MOVE("%n이동할 칸을 선택해주세요. (위: U, 아래: D)%n"),
        RESTART_OR_END("%n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)%n"),
        RESULT("%n%n최종 게임 결과%n"),
        SUCCESS_OR_FAIL("%n게임 성공 여부: "),
        SUCCESS("성공"),
        FAIL("실패"),
        TRIAL("%n총 시도한 횟수: ");

        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum BridgeStatus {
        UPPER("U", 1),
        DOWN("D", 0);

        private final String position;
        private final int status;

        BridgeStatus(String position, int status) {
            this.position = position;
            this.status = status;
        }

        public String getPos() {
            return position;
        }

        public int getStat() {
            return status;
        }
    }
}
