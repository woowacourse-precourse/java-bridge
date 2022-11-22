package bridge;
import java.util.InputMismatchException;
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
        int size;
        try {size= Integer.parseInt(Console.readLine());}
        catch (InputMismatchException e) {throw new IllegalArgumentException("[ERROR] 3에서 20사이의 숫자를 입력하세요.");}
        if (!(3 <= size && size <= 20)) {throw new IllegalArgumentException("[ERROR] 3에서 20사이의 숫자를 입력하세요.");}
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move;
        try{
            move=Console.readLine();
        }catch(InputMismatchException e){throw new IllegalArgumentException("[ERROR] U 또는 D중 하나의 문자를 입력하세요.");}
        if (!(move=="U"||move=="D")) {throw new IllegalArgumentException("[ERROR] U 또는 D중 하나의 문자를 입력하세요.");}
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String cmd=Console.readLine();
        return null;
    }
}
