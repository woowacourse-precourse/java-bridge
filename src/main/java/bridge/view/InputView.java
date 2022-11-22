package bridge.view;

import bridge.controller.BridgeController;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_SQUARE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_STOP_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final BridgeController controller;

    public InputView(BridgeController controller){
        this.controller = controller;
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize() throws IllegalArgumentException{
        System.out.println(INPUT_BRIDGE_SIZE);
        int bridgeSize = 0;
        try{
            bridgeSize = Integer.valueOf(Console.readLine());
            System.out.println();
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if(!sizeRangeValidate(bridgeSize)) throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해주세요.");

        controller.inputBridgeSize(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public void readMoving() throws IllegalArgumentException{
        System.out.println(INPUT_MOVE_SQUARE);
        String moveSquare = Console.readLine();
        if(!movingValidate(moveSquare)) throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해주세요.");

        controller.movePlayer(moveSquare);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() throws IllegalArgumentException{
        System.out.println(INPUT_STOP_RETRY);
        String gameCommand = Console.readLine();
        if(!gameCommandValidate(gameCommand)) throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요.");

        return controller.reOrStopGame(gameCommand);
    }

    public static boolean sizeRangeValidate(int size){
        if(size >= 3 && size <= 20) return true;
        return false;
    }

    public static boolean movingValidate(String moveSquare){
        if(moveSquare.equals("D") || moveSquare.equals("U")) return true;
        return false;
    }

    public static boolean gameCommandValidate(String stopOrRetry){
        if(stopOrRetry.equals("R") || stopOrRetry.equals("Q")) return true;
        return false;
    }
}
