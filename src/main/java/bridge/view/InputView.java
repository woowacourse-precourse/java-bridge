package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int bridgeLen = 0;
        System.out.println("다리의 길이를 입력해주세요.");
        try{
            bridgeLen = Integer.parseInt(readLine());
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return bridgeLen;
    }

    public static void bridgeLenRangeCheck(int bridgeLen){
        if(bridgeLen >= 21 || bridgeLen <= 2){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String move = "";
        System.out.println("이동할 칸을 선택해주세요.");
        try{
            move = readLine();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 이동할 칸이 위면 U, 아래면 D여야 합니다.");
        }
        System.out.println("move:" + move);
        return move;
    }
    public static void moveCheck(String move){
        if(!move.equals("U") && !move.equals("D")){
            throw new IllegalArgumentException("[ERROR] 이동할 칸이 위면 U, 아래면 D여야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
