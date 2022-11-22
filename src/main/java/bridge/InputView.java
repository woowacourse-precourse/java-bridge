package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static void GameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 길이를 입력해주세요");
        String bridgeSize = Console.readLine();
        try {
            String BridgeSize = bridgeSize;
            Exception.BridgeSizeCheck(BridgeSize);
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return -1;
        }
        return Integer.valueOf(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String Moving = Console.readLine();
        try {
            Exception.WrongInsert(Moving, "U", "D");
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] U, D 이외의 값을 입력하였습니다.");
            return "EXIT";
        }
        return Moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        try {
            Exception.WrongInsert(gameCommand, "R", "Q");
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] R, Q 이외의 값을 입력하였습니다.");
            return "EXIT";
        }
        return gameCommand;
    }
}
