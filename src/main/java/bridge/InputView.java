package bridge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public int readBridgeSize(String size) {
        emptyCheck(size);
        numberRegex(size);
        return Integer.parseInt(size);
    }
    public String readMoving(String direction) {
        emptyCheck(direction);
        keyWordCheck(direction,"U","D");
        return direction;
    }
    public String readGameCommand(String command) {
        emptyCheck(command);
        keyWordCheck(command,"Q","R");
        return command;
    }
    private void emptyCheck(String input){ //빈 값 확인
        if(input.equals("")) throw new IllegalArgumentException("[ERROR] 공백을 입력했습니다.");
    }
    private void numberRegex(String size){
        Pattern pattern=Pattern.compile("^[0-9]+$");;
        Matcher matcher=pattern.matcher(size);
        if(!matcher.matches())  throw new IllegalArgumentException("[ERROR] 입력 값이 숫자가 아닙니다.");
    }
    private void keyWordCheck(String command,String checkKeyWordA, String checkKeyWordB){
        if(!command.equals(checkKeyWordA) && !command.equals(checkKeyWordB)) throw new IllegalArgumentException("[ERROR] 잘못된 입력을 했습니다.");
    }
}
/*
  사용자로부터 입력을 받는 역할을 한다.
  readBridgeSize -> 길이를 입력받는다.
  readMoving -> 이동할 칸
  readGame -> 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
*/