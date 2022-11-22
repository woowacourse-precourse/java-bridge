package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int gameStepCount = 0;
    private int bridgeSize = 0;
    private final List<String>Bridge;

    BridgeGame(int bridgeSize, List<String> Bridge){
        this.bridgeSize = bridgeSize;
        this.Bridge = Bridge;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(InputView Input) {
        while(gameStepCount != bridgeSize){
            String movingCommand=Input.readMoving();
            System.out.println(movingCommand);
            OutputView Output = new OutputView();
            if(!Output.printMap(gameStepCount,movingCommand,Bridge)){
                return retry(Input);
            }
            gameStepCount++;
        }
        System.out.println("--------끝---------");
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(InputView Input) {
        System.out.println(Constants.RETRY_INFO);
        String command =Input.readGameCommand();
        if(command.equals("Q")){
            return false;
        }
        return true;
    }
}
