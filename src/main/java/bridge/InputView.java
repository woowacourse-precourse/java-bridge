package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = readInput();
        String onlyNumber = input.replaceAll("[^0-9]", "");
        if (input.length() != onlyNumber.length()) {
            throw new IllegalArgumentException();
        }
        int size = Integer.parseInt(input);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = readInput();
        if(!(input.equals("D")||input.equals("U"))){
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = readInput();
        if(!(input.equals("Q")||input.equals("R"))){
            throw new IllegalArgumentException();
        }
        return input;
    }
    private String readInput(){
        String input;
        try {
            input = readLine();
        }catch(NoSuchElementException e){
            throw new IllegalArgumentException();
        }
        return input;
    }

}
