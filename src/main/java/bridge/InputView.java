package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = 0;
        String input = Console.readLine();
        try{
            bridgeSize = Integer.parseInt(input);
        }catch(NumberFormatException nfe){throwException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");}
        if(bridgeSize < 3 || bridgeSize > 20)  throwException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        if(!(input.equals("U")) && !(input.equals("D"))) throwException("이동할 칸은 U 또는 D만 입력할 수 있습니다.");
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        if(!(input.equals("R")) && !(input.equals("Q"))) throwException("재시작 여부는 R 또는 Q만 입력할 수 있습니다.");
        return input;
    }

    public void throwException(String message){
        System.out.println("[ERROR] " + message);
        throw new IllegalArgumentException("[ERROR] " + message);
    }


}
