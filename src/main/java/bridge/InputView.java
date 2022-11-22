package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int inputBridgeSize(){
        while(true){
            try{
                String sizeTmp = Console.readLine();
                if (checkInputSizeString(sizeTmp)) return Integer.parseInt(sizeTmp);
            }
            catch (IllegalAccessException e){
                System.out.println(e);
            }
        }
    }

    public boolean checkInputSizeString(String inputSize){
        if(isNumeric(inputSize) && checkRange(Integer.parseInt(inputSize))) {return true;}
        return false;
    }
    public boolean checkRange(int input){
        if(3 <= input && input <= 20){ return true;}
        throw new IllegalArgumentException("[ERROR] 입력값은 3이상 20이하의 숫자여야 합니다.");
    }

    public boolean isNumeric(String s){
        try{
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]입력값은 3이상 20이하의 숫자여야 합니다.");
        }
    }

    public int readBridgeSize() {
        return 0;
    }

    public boolean checkNextState(String s){
        if(checkStringSize(s) && checkMoveString(s)){
            return true;
        }
        return false;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                String moveNextState = Console.readLine();
                if (checkNextState(moveNextState)) return moveNextState;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public boolean checkStringSize(String s){
        if(s.length() == 1){
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 한 글자만 입력해야 합니다.");
    }
    public boolean checkMoveString(String s){
        if(s.charAt(0) == 'U' || s.charAt(0) == 'D'){
            return true;
        }
        throw new IllegalArgumentException("[ERROR]U,D 중 하나의 알파벳만 허용됩니다.");
    }

    public boolean checkInputCommand(String inputCommand){
        if(checkStringSize(inputCommand) && checkFinishString(inputCommand)){
            return true;
        }
        return false;
    }
    public boolean checkFinishString(String s){
        if(s.charAt(0) == 'R' || s.charAt(0) == 'Q'){
            return true;
        }
        throw new IllegalArgumentException("[ERROR]재시작여부는 R,Q로만 판단가능합니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                String userCommand = Console.readLine();
                if(checkInputCommand(userCommand)) return userCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}
