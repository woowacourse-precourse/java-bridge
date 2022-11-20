package bridge;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Console.*;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public void threeTotwenty(int Bridgesize){
        if (Bridgesize < 3 || Bridgesize > 20){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    public void NotInt(String Bridgesize){
        try{Integer.valueOf(Bridgesize);}
        catch(NumberFormatException NE){
            System.out.println("[ERROR] 숫자만 입력이 가능합니다.");
            throw new IllegalArgumentException();
            }
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String Bridgesize = Console.readLine();
        try{NotInt(Bridgesize);
            threeTotwenty(Integer.valueOf(Bridgesize));}
        catch(IllegalArgumentException e){
            return 0;
        }
        return Integer.valueOf(Bridgesize);
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
