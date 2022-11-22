package bridge.view;

import bridge.model.GameResult;
import bridge.model.Judge;
import bridge.model.MoveResult;
import bridge.model.Moving;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView implements Output {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public void printMap(Judge judge) {
        List<String> upper = new ArrayList<>();
        List<String> lower = new ArrayList<>();

        for (int i = 0; i < judge.getUserBridge().size(); i++) {
            upper.add(makeOX(Moving.UP, judge.getBridge().get(i), judge.getUserBridge().get(i)));
            lower.add(makeOX(Moving.DOWN, judge.getBridge().get(i), judge.getUserBridge().get(i)));
        }
        printLine(upper);
        printLine(lower);
    }

    private void printLine(List<String> upperOrLower) {
        StringBuilder line = new StringBuilder();
        line.append(Message.MAP_START);
        for (int i = 0; i < upperOrLower.size(); i++) {
            if (i != upperOrLower.size() - 1) line.append(upperOrLower.get(i)).append(Message.MAP_MIDDLE);
            if (i == upperOrLower.size() - 1) line.append(upperOrLower.get(i));
        }
        line.append(Message.MAP_END);
        System.out.println(line);
    }

    private String makeOX(Moving moving, String bridgeMove, String userBrideMove) {
        if (!moving.getValue().equals(userBrideMove)) return " ";
        if (bridgeMove.equals(userBrideMove)) return MoveResult.CORRECT.getValue();
        return MoveResult.NOT_CORRECT.getValue();
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Judge judge, GameResult gameResult, int gameCount) {
        System.out.println(Message.FINAL_GAME_RESULT);
        printMap(judge);
        System.out.println(Message.IS_GAME_SUCCESS + gameResult.getValue());
        System.out.println(Message.TOTAL_GAME_COUNT + gameCount);
    }
}
