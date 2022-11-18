package bridge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final HashMap<String, Integer> directionToIndex = new HashMap<>();
    private final List<List<String>> roundResult;
    private int gameRound = 0;

    public BridgeGame(List<String> bridgeScaffold) {
        directionToIndex.put("D", 1);
        directionToIndex.put("U", 0);
        roundResult = makeRoundResult(bridgeScaffold);
    }

    private List<List<String>> makeRoundResult(List<String> bridgeScaffold) {
        List<List<String>> roundResult = new ArrayList<>();
        roundResult.add(new ArrayList<>(Collections.nCopies(bridgeScaffold.size(), " ")));
        roundResult.add(new ArrayList<>(Collections.nCopies(bridgeScaffold.size(), " ")));

        for (int i = 0; i < bridgeScaffold.size(); i++) {
            int resultIndex = directionToIndex.get(bridgeScaffold.get(i));
            roundResult.get(resultIndex).set(i,"O");
        }
        return roundResult;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        boolean isSurvive = checkSurvive(direction);

        System.out.println(isSurvive);
//        printResult(isSurvive);
        this.gameRound++;

        return isSurvive;
    }

    private boolean checkSurvive(String direction) {
        return "O".equals(roundResult.get(directionToIndex.get(direction)).get(this.gameRound));
    }

    private void printResult(boolean isSurvive) {
//        for (int i = 0; i < gameRound; i++) {
//            this.roundResult.get(i);
//        }
//        if(isSurvive){
//
//        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameRound = 0;
    }
}
