package bridge.view.validation;

import bridge.domain.BridgeConst;

public class InputValidation {
    private final String BRIDGE_MESSAGE = "[ERROR] 다리 길이 입력은 3이상 20이하의 숫자를 입력할 수 있습니다.\n";
    private final String MOVE_MESSAGE = "[ERROR] 이동할 칸은 (위: U, 아래: D)만 입력해주세요.\n";
    private final String RETRY_MESSAGE = "[ERROR] 다시 시도 여부는 (재시도: R, 종료: Q)만 입력해주세요.\n";

    public void bridgeLen(String input){
        notNumberFormat(input);
        Integer len = Integer.parseInt(input);
        if(len < 3 || len > 20) throw new IllegalArgumentException(BRIDGE_MESSAGE);
    }

    private void notNumberFormat(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(BRIDGE_MESSAGE);
        }
    }

    public void moveCommand(String cmd){
        if(!(cmd.equals(BridgeConst.UP) || cmd.equals(BridgeConst.DOWN)))
            throw new IllegalArgumentException(MOVE_MESSAGE);
    }

    public void retryCommand(String cmd){
        if(!(cmd.equals("R") || cmd.equals("Q")))
            throw new IllegalArgumentException(RETRY_MESSAGE);
    }
}
