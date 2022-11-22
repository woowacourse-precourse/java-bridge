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
        String str = Console.readLine();
        int num = isNumber(str);
        if (num<3 || num>20) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return num;
    }

    public static int isNumber(String str){
            try{
                return Integer.parseInt(str);
            } catch (IllegalArgumentException e){
                throw new IllegalArgumentException("[ERROR]");
            }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String str = Console.readLine();
        validInput(str);
        return str;
    }

    public static void validInput(String str) {
        if (str.length()>1){
            throw new IllegalArgumentException("[ERROR]");
        }
        if (!str.equals("U") && !str.equals("D")) {
            throw new IllegalArgumentException("[ERROR]");
        }
    };

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true){
            try {
                String str = Console.readLine();
                validReInput(str);
                return str;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void validReInput(String str){
        if (str.length()>1){
            throw new IllegalArgumentException("[ERROR]");
        }
        if (!str.equals("R") && !str.equals("Q")){
            throw new IllegalArgumentException("[ERROR]");
        }
    };
}
