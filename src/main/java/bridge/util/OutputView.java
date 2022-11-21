package bridge.util;

import bridge.BridgeGame;
import bridge.move.BridgeMove;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private final BridgeGame game = new BridgeGame();
    private StringBuilder resultMap=new StringBuilder();

    public void printMap(String move_result,int index,int last_index) {
        StringBuilder move_map = game.move(move_result, index);
        System.out.println(move_map+"\n");
        resultMap=move_map;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
        System.out.println(resultMap);
    }

    public void printStartGame(){
        System.out.println("다리 건너기 게임을 시작합니다. \n");
        printBridgeLength();
    }

    private void printBridgeLength(){
        System.out.println("다리의 길이를 입력해주세요");
    }

    public void printArgumentErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

    public void printMove(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public String printRetryCondition(InputView inputView){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return inputView.readGameCommand();
    }
}
