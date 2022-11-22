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

        System.out.println("다리의 길이를 입력해 주세요");
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);
        int result = Integer.parseInt(bridgeSize);
        return result;
    }

    private static void validateBridgeSize(String  bridgeSize) {
        try {
            int size = Integer.parseInt(bridgeSize);
            if(size <3|| size >20){
                throw new IllegalArgumentException("[ERROR] 다리의 길이는 3부터 20까지입니다.");
            }
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 정수로 입력해 주십시오");
        }

    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D");
        String playerMove = Console.readLine();
        validateMove(playerMove);
        return playerMove;
    }

    private static void validateMove(String playerMove) {
        if(playerMove.length()!=1){
            throw new IllegalArgumentException("[ERROR] 이동은 U, 또는 D로 입력하셔야 합니다.");
        }
        if(!(playerMove.equals("U")||playerMove.equals("D"))){
            System.out.println(playerMove);
            throw new IllegalArgumentException("[ERROR] 이동은 U, 또는 D로 입력하셔야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand= Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    private static void validateGameCommand(String gameCommand) {
        if(gameCommand.length()!=1){
            throw new IllegalArgumentException("[ERROR] 다시 시작은 R, 게임 종료는 Q를 입력하셔야 합니다.");
        }
        if(!(gameCommand.equals("Q")||gameCommand.equals("R"))){
            throw new IllegalArgumentException("[ERROR] 다시 시작은 R, 게임 종료는 Q를 입력하셔야 합니다.");
        }
    }
}
