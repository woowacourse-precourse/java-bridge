package bridge.ui;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
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
    private void printPlayLogOnPos(List<String> playLog, String pos, boolean lastMoveSuccess) {
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
    private String checkOneStep(List<String> playLog, int playLogIdx, String pos, boolean lastMoveSuccess) {
        if(playLog.get(playLogIdx).equals(pos)){
            if(playLogIdx == playLog.size() - 1 && !lastMoveSuccess)
                return " X ";
            return " O ";
        }

        return "   ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
