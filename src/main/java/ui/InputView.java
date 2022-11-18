package ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private void validNotNull(String input){
        if(input == null){
            throw new IllegalArgumentException("NULL 불가.");
        }
    }
    private void validNotBlank(String input){
        if(input.length() == 0){
            throw new IllegalArgumentException("Blank 불가.");
        }
    }
    public String userInput(){
        String input = Console.readLine();
        validNotNull(input);
        validNotBlank(input);
        return input;
    }
    private void validBridgeNumber(String input){
        validNotStartWithZero(input);
        validNumber(input);
        validRange(input);
    }
    private void validNumber(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9'){
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }
    }
    private void validNotStartWithZero(String input){
        if(input.charAt(0) == '0'){
            throw new IllegalArgumentException("숫자는 0으로 시작 X");
        }
    }
    private void validRange(String input){
        if(input.length() > 2){
            throw new IllegalArgumentException("범위 초과");
        } else if(input.length() == 2){
            if(input.charAt(0) < '1' || input.charAt(0) > '2'){
                throw new IllegalArgumentException("범위 초과");
            }
        }
    }
    private int inputToInteger(String input){
        int sum = 0;
        for(int i = 0; i < input.length(); i++){
            sum *= 10;
            sum += input.charAt(i) - '0';
        }
        return sum;
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = "";
        try{
            input = userInput();
            validBridgeNumber(input);
            return inputToInteger(input);
        } catch(Exception e){
            System.out.println(e);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
