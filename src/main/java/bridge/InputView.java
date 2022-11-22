package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public boolean readBridgeSizeValidation(String input) {
        if(input.matches("(.*)[^0-9](.*)")){
            return false;
        }
        if(Integer.parseInt(input)<3 || Integer.parseInt(input) > 20){
            return false;
        }
        return true;
    }

    public boolean readMovingValidation(String input){
        if(input.equals("U") || input.equals("D")){
            return true;
        }
        return false;
    }

    public boolean readGameCommandValidation(String input){
        if(input.equals("R") || input.equals("Q")){
            return true;
        }
        return false;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        if(!readBridgeSizeValidation(input)){
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
                readBridgeSize();
            }
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        if(!readMovingValidation(input)){
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] U 또는 D를 입력해 주세요.");
                readMoving();
            }
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        if(!readGameCommandValidation(input)){
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] R 또는 Q를 입력해 주세요.");
                readGameCommand();
            }
        }
        return input;
    }
}
