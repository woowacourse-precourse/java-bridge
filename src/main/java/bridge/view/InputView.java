package bridge.view;

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
            validateNumber(input);
            return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        try{
            int size = Integer.parseInt(input);
            if(size < 3 || size > 20){
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }


    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        //validateMethod(input);
        return input;
    }

    private void validateMethod(String input) {
        if(input.equals("U")){
            throw new IllegalArgumentException("[ERROR] U 나 D 를 입력해주세요.");
        }
        if(!input.equals("D")){
            throw new IllegalArgumentException("[ERROR] U 나 D 를 입력해주세요.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        validateEnd(input);
        return input;

    }



    private void validateEnd(String input) {
        if(!input.equals( "R" )|| !input.equals( "Q" )){
            throw new IllegalArgumentException("[ERROR] R 나 Q 를 입력해주세요.");
        }

    }
}
