package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요");
        int size = Integer.parseInt(readLine());
        if(size<3||size>20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move = readLine();
        if(!move.equals("U")&&!move.equals("D")){
            throw new IllegalArgumentException("[ERROR] 입력은 U,D 중 하나 입니다.");
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String RorQ = readLine();
        if(!RorQ.equals("R")&&!RorQ.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 입력은 R,Q 중 하나 입니다.");
        }
        return RorQ;
    }
}
