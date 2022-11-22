package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    //현재 위치와 주어진 다리 일치 여부(O,X 출력을 위해)
    private boolean isMatch(List<String> bridge, List<Integer> position){
        if(bridge.get(position.get(1) - 1).equals("U") && position.get(0).equals(UpOrDown.UP.getValue())){
            return true;
        }
        return bridge.get(position.get(1) - 1).equals("D") && position.get(0).equals(UpOrDown.DOWN.getValue());
    }

    //현재 위치의 O,X,빈칸을 출력하는 함수(윗줄과 아랫줄로 나뉘어 있다)
    private void printUpPosition(List<String> bridge, BridgeGame bridgeGame){
        if(bridgeGame.getPosition().get(0).equals(UpOrDown.UP.getValue())){
            if(!isMatch(bridge, bridgeGame.getPosition())){
                System.out.print("X ");
                bridgeGame.onQuestion();
                return;
            }
            System.out.print("O ");
            return;
        }
        System.out.print("  ");
    }
    private void printDownPosition(List<String> bridge, BridgeGame bridgeGame){
        if(bridgeGame.getPosition().get(0).equals(UpOrDown.DOWN.getValue())){
            if(!isMatch(bridge, bridgeGame.getPosition())){
                System.out.print("X ");
                bridgeGame.onQuestion();
                return;
            }
            System.out.print("O ");
            return;
        }
        System.out.print("  ");
    }

    //다리의 빈칸 또는 일치 여부 출력
    private void printBlankOrMatch(int i, List<String> bridge, String UpOrDown){
        if(bridge.get(i).equals(UpOrDown)){
            System.out.print("O | ");
            return;
        }
        System.out.print("  | ");
    }

    //현재 포지션 뒤쪽(즉, 다리) 출력(윗줄, 아랫줄로 나뉘어 있다)
    private void printUpBeforePosition(List<String> bridge, List<Integer> position){
        if(position.get(1).equals(1)){
            return;
        }
        for(int i=0; i<position.get(1)-1; i++){
            printBlankOrMatch(i, bridge, "U");
        }
    }
    private void printDownBeforePosition(List<String> bridge, List<Integer> position){
        if(position.get(1).equals(1)){
            return;
        }
        for(int i=0; i<position.get(1)-1; i++){
            printBlankOrMatch(i, bridge, "D");
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, BridgeGame bridgeGame) {
        System.out.print("[ ");
        printUpBeforePosition(bridge, bridgeGame.getPosition());
        printUpPosition(bridge, bridgeGame);
        System.out.println("]");
        System.out.print("[ ");
        printDownBeforePosition(bridge, bridgeGame.getPosition());
        printDownPosition(bridge, bridgeGame);
        System.out.println("]");
    }

    private void printSuccessOrNot(List<String> bridge, BridgeGame bridgeGame){
        if(bridgeGame.getPosition().get(1).equals(bridge.size()) && isMatch(bridge, bridgeGame.getPosition())){
            System.out.println("게임 성공 여부: 성공");
            String message = String.format("총 시도한 횟수: %s", bridgeGame.getTryNumber());
            System.out.println(message);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        String message = String.format("총 시도한 횟수: %s", bridgeGame.getTryNumber());
        System.out.println(message);
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridge,bridgeGame);
        printSuccessOrNot(bridge, bridgeGame);
    }
}
