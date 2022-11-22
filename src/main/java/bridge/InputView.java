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
        String bridgeSize=Console.readLine();
        checkDigit(bridgeSize);
        int size=Integer.parseInt(bridgeSize);
        checkRange(size);
        return size;
    }

    public void checkDigit(String bridgeSize) {
        final String REGEX="[0-9]+";
        if(!bridgeSize.matches(REGEX)){
            throw new IllegalArgumentException("[ERROR] 다리 길이에 숫자만 입력하세요.");
        }
    }

    public void checkRange(int size){
        if(!(3<=size&&size<=20)){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving=Console.readLine();
        checkMoving(moving);
        return moving;
    }

    public void checkMoving(String moving){
        if(!moving.equals("U")&&!moving.equals("D")){
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U나 D만 입력하세요.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand=Console.readLine();
        checkGameCommand(gameCommand);
        return gameCommand;
    }

    public void checkGameCommand(String gameCommand) {
        if(!gameCommand.equals("R")&&!gameCommand.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 다시 시도할지 여부는 R이나 Q만 입력하세요.");
        }
    }
}
