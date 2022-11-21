package bridge;


import camp.nextstep.edu.missionutils.Console;
import org.w3c.dom.ranges.RangeException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeLen(){
        String input = "";
        while(true){
            outputView.printRequestSize();
            try{
                input = Console.readLine();
                validateInputNumber(input);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = "";
        while(true){
            outputView.printRequestUpDownMessage();
            try{
                input = Console.readLine();
                validateMoveInput(input);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        validateMoveInput(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validateReStartInput(input);
        return input;
    }

    private static void validateInputNumber(String input){
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
            }
        }
        int len = Integer.parseInt(input);
        if(len < 3 || len > 20){
            throw new IllegalArgumentException("[ERROR] 숫자는 3~20 범위로 입력해야 합니다.");
        }
    }

    private static void validateMoveInput(String input){
        if(!(input.equals("U") || input.equals("D"))){
            throw new IllegalArgumentException("[ERROR] U 또는 D만 입력해야 합니다.");
        }
    }

    private static void validateReStartInput(String input){
        if(!(input.equals("R") || input.equals("Q"))){
            System.out.println("[ERROR] R 또는 Q만 입력해야 합니다.");
            throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력해야 합니다.");
        }
    }

}
