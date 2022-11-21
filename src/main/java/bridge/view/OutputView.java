package bridge.view;

import bridge.constant.AfterMovingStatusConstant;
import bridge.constant.GameProcedureStringConstant;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

     public void gameStartMessage() {
         System.out.println(GameProcedureStringConstant.GAME_START_MESSAGE.getMessage());
         System.out.println(GameProcedureStringConstant.BRIDGE_LENGTH_INPUT_MESSAGE.getMessage());
     }

     public void printChooseWhereToGoBridgeMessage() {
         System.out.println(GameProcedureStringConstant.WHERE_TO_GO_INPUT_MESSAGE.getMessage());
     }

     public void printRetryOrExitGameMessage() {

     }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(AfterMovingStatusConstant afterMovingStatusConstant) {
        
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
