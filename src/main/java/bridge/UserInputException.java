package bridge;

public class UserInputException {
    final static int numSizeStart = 3;
    final static int numSizeEnd = 20;
    enum Route{U, D}
    enum Restart{R, Q}

    public UserInputException(){
    }

    public boolean checkInputException(int num, String input){
        if (num == 1){ return checkBridgeSizeNum(input); }
        if (num == 2){ return checkMoveRoute(input); }
        if (num == 3){ return checkGameCommand(input); }
        return false;
    }
    public boolean checkBridgeSizeNum(String input) {
        if(checkInputIsNum(input) && checkBridgeSizeRange(Integer.parseInt(input))){ return true; }
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
    public boolean checkInputIsNum(String input) {
        try { Integer.parseInt(input); } catch (NumberFormatException e) { return false; }
        return true;
    }
    // 입력받은 사이즈가 3 부터 20 사이의 숫자인지
    boolean checkBridgeSizeRange(int input) {
        if (input >= this.numSizeStart && input <= this.numSizeEnd) { return true; }
        return false;
    }
    // 입력받은 문자가 U 혹은 D인지 체크
    boolean checkUorD(String input) {
        if (input.equals("U") || input.equals("D")) {
            return true; }
        return false;
    }
    // 입력받은 문자가 R 혹은 Q인지 체크
    boolean checkRorQ(String input) {
        if (input.equals("R") || input.equals("Q")) {
            return true; }
        return false;
    }
}
