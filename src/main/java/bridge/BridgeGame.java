package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    public List<String> bridgeUsable;

    public int currentIndex = 0;
    public int retrycount=0;

    public void startGame() {
        bridgeUsable = new ArrayList<>();
        int bridgeSize = inputView.readBridgeSize();
        bridgeUsable = bridgeMaker.makeBridge(bridgeSize);
        restartGame();
    }

    public void restartGame() {
        currentIndex=0;
        retrycount+=1;
        HashMap<Integer, List<String>> resultMap = new HashMap<Integer, List<String>>();
        for (int i=0; i<bridgeUsable.size(); i++) {
            String inputMove = inputView.readMoving();
            move(bridgeUsable.get(i), inputMove, resultMap);
        }
        outputView.printResult("성공", retrycount, resultMap);

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move, String inputMove, HashMap<Integer, List<String>> resultMap) {
        String resultUp="";
        String resultDown="";
        List<String> results = new ArrayList<>();
        if (move.equals("U")){
            if (move.equals(inputMove)){
                resultUp="O";
                resultDown="E";
                results.add(resultUp);
                results.add(resultDown);
                resultMap.put(currentIndex, results);
                outputView.printMap(resultMap);
                currentIndex += 1;
            }
            if (!move.equals(inputMove)){
                resultUp="E";
                resultDown="X";
                results.add(resultUp);
                results.add(resultDown);
                resultMap.put(currentIndex, results);
                outputView.printMap(resultMap);
                retry("실패", resultMap);
            }
        }
        if (move.equals("D")){
            if (move.equals(inputMove)){
                resultUp="E";
                resultDown="O";
                results.add(resultUp);
                results.add(resultDown);
                resultMap.put(currentIndex, results);
                outputView.printMap(resultMap);
                currentIndex += 1;
            }
            if (!move.equals(inputMove)){
                resultUp="X";
                resultDown="E";
                results.add(resultUp);
                results.add(resultDown);
                resultMap.put(currentIndex, results);
                outputView.printMap(resultMap);
                retry("실패", resultMap);
            }
        }
    }



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String result, HashMap<Integer, List<String>> resultMap) {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            restartGame();
        }
        if (gameCommand.equals("Q")) {
            outputView.printResult(result, retrycount, resultMap);
            currentIndex=0;
            System.exit(0);
        }
    }
}
