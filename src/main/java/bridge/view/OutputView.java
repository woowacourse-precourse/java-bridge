package bridge.view;

import bridge.model.Course;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_POINT = "[ ";
    private static final String END_POINT = " ]";
    private static final String PARTITION = " | ";
    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String COUNT_OF_TRY = "총 시도한 횟수: ";

    public void gameStart() {
        System.out.println(START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String[]> curMap) {
        printLayer(curMap, Course.TOP.getNumber());
        printLayer(curMap, Course.BOTTOM.getNumber());
    }

    private void printLayer(List<String[]> map, int course) {
        String[] layer = new String[map.size()];
        System.out.print(START_POINT);
        for (int i = 0; i < map.size(); i++) {
            layer[i] = map.get(i)[course];
        }
        System.out.print(String.join(PARTITION, layer));
        System.out.println(END_POINT);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String[]> finalMap, String resultOfGame, int gameCount) {
        System.out.println(GAME_RESULT);
        printLayer(finalMap, Course.TOP.getNumber());
        printLayer(finalMap, Course.BOTTOM.getNumber());
        System.out.print(SUCCESS_OR_NOT);
        System.out.println(resultOfGame);
        System.out.print(COUNT_OF_TRY);
        System.out.println(gameCount);
    }
}
