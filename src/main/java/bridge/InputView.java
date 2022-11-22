package bridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int size;
        try {
            size= Integer.parseInt(Console.readLine());
        }catch(Exception e){
            System.out.println("[ERROR] 올바른 값이 아닙니다.");
            throw new IllegalArgumentException();
        }
        if(size<3 || size>20){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();

        }

        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String blank= Console.readLine();
        if(blank.equals("U") || blank.equals("D")){
            return blank;
        }
        System.out.println("[ERROR] U,D 값만 입력해주세요");
        throw new IllegalArgumentException();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retry= Console.readLine();
        if(retry.equals("R") || retry.equals("Q")){
            return retry;
        }
        System.out.println("[ERROR] R,Q 값만 입력해주세요");
        throw new IllegalArgumentException();
    }
}
