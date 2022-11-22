package bridge.view;

import bridge.controller.BridgeSetting;
import bridge.controller.BridgeStatus;

public enum InputViewType {
    BRIDGE_SIZE("다리 길이를 입력해주세요.",
            "[ERROR] 다리는 숫자여야 합니다.") {
        public void validate(String input) throws IllegalArgumentException{
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    },
    MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)",
            "[ERROR] 이동 입력은 U또는 D여야 합니다.") {
        public void validate(String input) throws IllegalArgumentException{
            for (BridgeStatus bridgeStatus : BridgeStatus.values()) {
                if (input.equals(bridgeStatus.getMoving())) {
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    },
    GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
            "[ERROR] 재시작 입력은 Q또는 R 이어야 합니다.") {
        public void validate(String input) throws IllegalArgumentException{
            if (input.equals(BridgeSetting.QUIT_COMMAND) || input.equals(BridgeSetting.RETRY_COMMAND)) {
                return;
            }
            throw new IllegalArgumentException();
        }
    };

    public abstract void validate(String input);
    private final String message;
    private final String errorMessage;

    InputViewType(String message, String errorMessage) {
        this.message = message;
        this.errorMessage = errorMessage;
    }

    public void printMessage() {
        System.out.println(this.message);
    }

    public void printErrorMessage() {
        System.out.println(this.errorMessage);
    }
}
