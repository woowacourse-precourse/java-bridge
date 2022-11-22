package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_NUM = 3;
    private static final int MAX_NUM = 20;


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeLength = Console.readLine();
        int bridgeLengthNo = Integer.valueOf(bridgeLength);
        if(bridgeLengthNo < MIN_NUM) {
            throw new IllegalArgumentException("[ERROR] 3미만의 값은 사용할수 없습니다.");
        }
        if(bridgeLengthNo > MAX_NUM){
            throw new IllegalArgumentException("[ERROR] 20이상의 값은 사용할수 없습니다.");
        }
        return bridgeLengthNo;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String movingWay = Console.readLine();
            if(!movingWay.equals("U") && !movingWay.equals("D")){
                throw new IllegalArgumentException("[ERROR] U 와 D만 입력 할수 있습니다.");
            }
        return movingWay;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String reStart = Console.readLine();
        return reStart;
    }
}
