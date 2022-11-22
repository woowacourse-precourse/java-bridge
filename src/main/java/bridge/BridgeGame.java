package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;
    public List<String> bridgeUsable = new ArrayList<>();

    public HashMap<Integer, List<String>> result = new HashMap<Integer, List<String>>();

    public int currentIndex = 0;

    public void startGame(int currentIndex) {
        int bridgeSize = inputView.readBridgeSize();
        bridgeUsable = bridgeMaker.makeBridge(bridgeSize);
        for (int i=currentIndex; i<bridgeUsable.size(); i++) {
            String inputMove = inputView.readMoving();
            move(bridgeUsable.get(currentIndex), inputMove, currentIndex);
            outputView.printMap(result);
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move, String inputMove, int currentIndex) {
        String resultUp="";
        String resultDown="";
        List<String> results = new ArrayList<>();
        if (move.equals("U")){
            if (move.equals(inputMove)){
                resultUp="O";
                resultDown="E";
                results.add(resultUp);
                results.add(resultDown);
                result.put(currentIndex, results);
                currentIndex += 1;
            }
            if (!move.equals(inputMove)){
                resultUp="X";
                resultDown="E";
                retry();
            }
        }
        if (move.equals("D")){
            if (move.equals(inputMove)){
                resultUp="E";
                resultDown="O";
                results.add(resultUp);
                results.add(resultDown);
                result.put(currentIndex, results);
                currentIndex += 1;
            }
            if (!move.equals(inputMove)){
                resultUp="E";
                resultDown="X";
                retry();
            }
        }
    }



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            startGame(currentIndex);
        }
        if (gameCommand.equals("Q")) {

            return;
        }
    }
}
