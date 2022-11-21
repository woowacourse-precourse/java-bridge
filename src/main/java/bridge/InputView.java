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
        try{
            System.out.println("다리의 길이를 입력해주세요.");
            int bridgeSize = Integer.parseInt(Console.readLine());
            return bridgeSize;
        }catch(IllegalArgumentException e){
            System.out.print("[ERROR]");
            return readBridgeSize();
        }
    }

    public int checkBridgeSize(int size){
        if(size >= 3 && size <= 20){
            return size;
        }
        throw new IllegalArgumentException("[ERROR]: 다리의 크기가 유효하지 않습니다.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();

        return gameCommand;
    }
}
