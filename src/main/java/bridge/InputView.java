package bridge;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        Scanner sc = new Scanner(System.in);    int size;
        try { size = sc.nextInt();  System.out.println(size); }
        catch (InputMismatchException e) {throw new IllegalArgumentException("[ERROR] 3에서 20사이의 숫자를 입력하세요.");}
        if (!(3 <= size && size <= 20)) {throw new IllegalArgumentException("[ERROR] 3에서 20사이의 숫자를 입력하세요.");}
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        Scanner sc=new Scanner(System.in);
        String move=sc.next();
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        Scanner sc=new Scanner(System.in);
        String cmd=sc.next();
        return null;
    }
}
