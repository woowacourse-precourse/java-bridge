package bridge;

import bridge.constants.BridgeConstants;
import bridge.constants.Message;

public class UserInputException {

    public UserInputException(){
    }

    public boolean checkInputException(int num, String input){
        if (num == 1){ return checkBridgeSizeNum(input); }
        if (num == 2){ return checkMoveRoute(input); }
        if (num == 3){ return checkGameCommand(input); }
        return false;
    }
    public boolean checkBridgeSizeNum(String input) {
        checkInputIsNum(input);
        if(checkBridgeSizeRange(Integer.parseInt(input))){ return true; }
        return false;
    }
    public boolean checkMoveRoute(String input) {
        if(checkUorD(input)){ return true; }
        return false;
    }
    public boolean checkGameCommand(String input) {
        if(checkRorQ(input)){ return true; }
        return false;
    }
    // 정수 여부 확인
    public void checkInputIsNum(String input) {
        try {Integer.parseInt(input);}
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INPUT_PATTERN_ERROR_MESSAGE); }
    }
    // 입력받은 사이즈가 3 부터 20 사이의 숫자인지
    boolean checkBridgeSizeRange(int input) {
        if (input >= BridgeConstants.MIN_BRIDGE_SIZE && input <= BridgeConstants.MAX_BRIDGE_SIZE) { return true; }
        return false;
    }
    // 입력받은 문자가 U 혹은 D인지 체크
    boolean checkUorD(String input) {
        if (input.equals(BridgeConstants.UP_DIRECTION) || input.equals(BridgeConstants.DOWN_DIRECTION)) {
            return true; }
        return false;
    }
    // 입력받은 문자가 R 혹은 Q인지 체크
    boolean checkRorQ(String input) {
        if (input.equals(BridgeConstants.RESTART) || input.equals(BridgeConstants.QUIT)) {
            return true; }
        return false;
    }
}
