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
        System.out.println("다리의 길이를 입력해주세요.");
        String size = Console.readLine();
        int bridgeSize = Integer.parseInt(size);
        checkBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        checkMoving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        checkGameCommand(gameCommand);
        return gameCommand;
    }

    private void checkBridgeSize(int bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void checkMoving(String moving){
        if(moving.equals("U") || moving.equals("D")){
            return;
        }
        throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해주세요.");
    }

    private void checkGameCommand(String command) {
        if(command.equals("R") || command.equals("Q")){
            return;
        }
        throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요.");
    }
}
