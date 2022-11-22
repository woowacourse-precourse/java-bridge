package bridge.domain;

import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int index = 0;
    public static int gameCount = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, String readMoving) {
        if (bridge.get(index).equals(readMoving)){
            return (true);
        }
        return (false);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge, int bridgeSize) {
        index = 0;
        gameCount += 1;
        Game reGame = new Game(bridge, bridgeSize);
        reGame.start();
    }

    private void correctMove(String input, MapString mapString){
        if (input.equals("U")){
            mapString.setUpstairs("O");
            mapString.setDownstairs(" ");
            return ;
        }
        mapString.setUpstairs(" ");
        mapString.setDownstairs("O");
    }

    private void incorrectMove(String input, MapString mapString){
        if (input.equals("U")){
            mapString.setUpstairs("X");
            mapString.setDownstairs(" ");
            return ;
        }
        mapString.setUpstairs(" ");
        mapString.setDownstairs("X");
    }

    public MapString makeMap(String input, boolean move, MapString mapString){
        if (move){
            correctMove(input, mapString);
            return (mapString);
        }
        incorrectMove(input, mapString);
        return (mapString);
    }
}
