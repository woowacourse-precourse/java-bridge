package bridge;

import org.mockito.internal.util.StringUtil;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 크기를 입력: ");
        String size = readLine();
        if(size.length() >= 3) throw new IllegalArgumentException();
        if(size.isEmpty()) throw new IllegalArgumentException();

        try{
            int temp = Integer.parseInt(size);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("U or D 입력: ");
        String direction = readLine();
        if(direction.length() != 1) throw new IllegalArgumentException();
        char dir = direction.charAt(0);
        if(dir != 'U' && dir != 'D') throw new IllegalArgumentException();

        return direction;

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("Restart? ");
        String action = readLine();
        if(action.length() != 1) throw new IllegalArgumentException();
        if(action.charAt(0) != 'R' && action.charAt(0) != 'Q') throw new IllegalArgumentException();

        return action;
    }
}
