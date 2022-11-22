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
        String input;

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
        input = Console.readLine();
        inputCheckCorrect(input);

        return checkLenSize(input);
    }
    private void inputCheckCorrect(String input) {
        if(!input.matches("[0-9+]")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하시오.");
        }
    }

    private int checkLenSize(String input) {
        int len;

        len = Integer.parseInt(input);
        if(len < 3 || len > 20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        return  len;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input;

        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        input = Console.readLine();
        checkInputStr(input);

        return input;
    }
    private void checkInputStr(String str) {
        if(str.length() != 1){
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
        if(!str.equals("U") && !str.equals("D")){
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input;

        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        input = Console.readLine();
        inputCheckReadGameCommand(input);

        return input;
    }
    private void inputCheckReadGameCommand(String str) {
        if(str.length() != 1){
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
        if(!str.equals("R") && !str.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
    }
}
