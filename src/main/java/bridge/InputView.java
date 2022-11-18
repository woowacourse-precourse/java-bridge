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
        try { return Integer.parseInt(Console.readLine());}
        catch(IllegalArgumentException e) { throw new IllegalArgumentException("숫자만 입력해주세요.");}
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String url = Console.readLine();

         if(url.length() == 1)
             if(url.equals("U") || url.equals("R"))
                 return url;

         throw new IllegalArgumentException("U 또는 R을 입력해주세요");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
