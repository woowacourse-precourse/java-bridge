package bridge;

import bridge.Config.ErrorUi;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        int bridgeSize=0;
        if(checkInput(input)){
            bridgeSize = Integer.parseInt(input);
            checkRange(bridgeSize);
        }
        return bridgeSize;
    }

    /**
     * 입려값이 문자인지 체크
     */
    private boolean checkInput(String input){
        try {
            Integer.parseInt(input);
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(ErrorUi.ERRORINPUT.getMsg());
            readBridgeSize();
        }
        return false;
    }

    /**
     * 입려값이 범위가 3~20 인지 체크
     */
    private void checkRange(int input){
        try{
            if(input > 20 || input < 3 ){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(ErrorUi.ERRORRANGE.getMsg());
            readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        checkMove(input);
        return input;
    }

    /**
     * 입려값이 U ,D 인지 체크
     */
    private void checkMove(String input){
        try {
            if(!input.equals("U") && !input.equals("D")){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(ErrorUi.ERRORMOVE.getMsg());
            readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        checkReTry(input);
        return input;
    }

    /**
     * 입력값이 R ,Q 인지 체크
     */
    private void checkReTry(String input){
        try {
            if(!input.equals("R") && !input.equals("Q")){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(ErrorUi.ERRORRETRY.getMsg());
            readGameCommand();
        }
    }
}
