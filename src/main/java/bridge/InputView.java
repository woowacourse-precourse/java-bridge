package bridge;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = readLine();
        errorCheckReadBridgeSize(userInput);
        return Integer.parseInt(userInput);
    }

    public void errorCheckReadBridgeSize(String userInput) {
        try{
            if(!(checkIsNumber(userInput)&&checkNumberIsInBoundary(userInput))){
                throw new IllegalArgumentException("[ERROR]");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private boolean checkNumberIsInBoundary(String userInput) {
        boolean possible=true;
        int tmp = Integer.parseInt(userInput);
        if(tmp<3||tmp>20){
            possible=false;
        }
        return possible;
    }

    private boolean checkIsNumber(String userInput) {
        boolean possible=true;
        for (int i = 0; i <userInput.length() ; i++) {
            int tmp = userInput.charAt(i) - '0';
            if(tmp<0||tmp>=10){
                possible=false;
            }
        }
        return possible;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput=readLine();
        errorCheckReadMovig(userInput);
        return userInput;
    }

    public void errorCheckReadMovig(String userInput) {
        try{
            if(userInput.equals("U")||userInput.equals("D")){
                throw new IllegalArgumentException("[ERROR]");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
