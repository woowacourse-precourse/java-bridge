package bridge.ui;

import bridge.BridgeGame;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final Map<Boolean, String> result = new TreeMap<>();

    public OutputView() {
        result.put(true, "성공");
        result.put(false, "실패");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param playLog 플레이어의 행동 로그 리스트
     * @param lastMoveSuccess 마지막 스탭에서는 성공하였는지?
     */
    public void printMap(final List<String> playLog, boolean lastMoveSuccess) {
        printPlayLogOnPos(playLog, "U", lastMoveSuccess);
        printPlayLogOnPos(playLog, "D", lastMoveSuccess);
    }

    /**
     * 한 pos(상, 하)에 대한 PlayLog를 출력하는 메서드
     * @param playLog 플레이어의 행동 로그 리스트
     * @param pos "U" - 위, "D" - 아래
     * @param lastMoveSuccess 마지막 스탭에서는 성공하였는지?
     */
    private void printPlayLogOnPos(final List<String> playLog, String pos, boolean lastMoveSuccess) {
        System.out.print('[');

        for (int i = 0; i < playLog.size() - 1; i++){
            System.out.print(checkOneStep(playLog, i, pos, lastMoveSuccess));
            System.out.print('|');
        }

        System.out.print(checkOneStep(playLog, playLog.size() - 1, pos, lastMoveSuccess));
        System.out.println(']');
    }

    /**
     * 한 스탭에서 어떤 출력을 해야하는지 알려주는 메서드
     * @param playLog 플레이어의 행동 로그 리스트
     * @param playLogIdx 몇 번째 스탭인지
     * @param pos "U" - 위, "D" - 아래
     * @param lastMoveSuccess 마지막 스탭에서는 성공하였는지?
     * @return 출력할 메서드를 반환
     */
    private String checkOneStep(final List<String> playLog, int playLogIdx, String pos, boolean lastMoveSuccess) {
        if(playLog.get(playLogIdx).equals(pos)){
            if(playLogIdx == playLog.size() - 1 && !lastMoveSuccess)
                return " X ";
            return " O ";
        }

        return "   ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param bridgeGame
     */
    public void printResult(final BridgeGame bridgeGame, boolean lastMoveSuccess){


        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getPlayLog(), lastMoveSuccess);
        System.out.println("\n게임 성공 여부: " + result.get(lastMoveSuccess));
        System.out.println("총 시도한 횟수: " + bridgeGame.getPlayCount());
    }
}
