package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    static final int BRIDGE_MIN_LENGTH = 3;
    static final int BRIDGE_MAX_LENGTH = 20;

    static final int INPUT_POSITION = 0;
    static final int LENGTH_NULL = 1;


    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println("다리의 길이를 입력해주세요.");
        String userInputSize = readLine();
        int inputsize = 0;
        try {
            inputsize = Integer.parseInt(userInputSize);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수가 아닌 값 입력");
        }
        System.out.println("inputsize = " + inputsize);
        if (inputsize < BRIDGE_MIN_LENGTH || inputsize > BRIDGE_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위가 잘못되었습니다.");
        }
        return inputsize;
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException{
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String userInputMove = readLine();
        if (userInputMove.length() != LENGTH_NULL) {
            throw new IllegalArgumentException("[ERROR] U 나 D를 입력해주세요.");
        }

        char inputMove = userInputMove.charAt(INPUT_POSITION);
        if (inputMove != 'U' && inputMove != 'D') {
            throw new IllegalArgumentException("[ERROR] U 나 D를 입력해주세요.");
        }
        System.out.println(inputMove);
        return userInputMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException{
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String userRestart = readLine();
        if (userRestart.length() != LENGTH_NULL) {
            throw new IllegalArgumentException("[ERROR] R 나 Q를 입력해주세요.");
        }

        char inputRestart = userRestart.charAt(INPUT_POSITION);
        if (inputRestart != 'R' && inputRestart != 'Q') {
            throw new IllegalArgumentException("[ERROR] R 나 Q를 입력해주세요.");
        }
        System.out.println(inputRestart);
        return userRestart;
    }
}
