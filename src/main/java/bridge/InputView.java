package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.stream.DoubleStream;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;
    private int bridgeSize;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        bridgeSize = Integer.parseInt(Console.readLine());
        validateBridgeSize(bridgeSize);

        return bridgeSize;
    }

    public void validateBridgeSize(int checkNum){
        if (BRIDGE_SIZE_MIN > checkNum || checkNum > BRIDGE_SIZE_MAX){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String writeMoving = Console.readLine();
        if (!writeMoving.equals("U")&&!writeMoving.equals("D")){
            throw new IllegalArgumentException("[ERROR] U / D 로 입력해주세요");
        }
        return writeMoving;
    }
    
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String writeRestart = Console.readLine();
        if (!writeRestart.equals("R")&&!writeRestart.equals("Q")){
            throw new IllegalArgumentException("[ERROR] R / Q 로 입력해주세요");
        }
        return writeRestart;
    }
}
