package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame extends BridgeGameInit{


    public BridgeGame() {
        super();
    }

    public String play() {
        for (int i=0; i < bridge.size(); i++) {
            String gameResult = move(bridge,i);
            if (gameResult == "Q") {
                return "F"; //실패
            } else if (gameResult == "R") {
                return "R"; //재시작
            }
        }
        return "S"; //성공
    }



    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> ladder, int i) {
        String moveDir = inputView.readMoving();
        if (!moveDir.equals(ladder.get(i))) {
            outputView.printMap(moveDir+"X");
            return inputView.readGameCommand();
        }
        outputView.printMap(moveDir+"O");
        return "C";
    }




    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
