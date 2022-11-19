package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    final static String DELIMITER = " | ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String>[] map) {
        System.out.println(convertForm(map[0]));
        System.out.println(convertForm(map[1]));
    }
    private String convertForm(List<String> result) {
        StringBuilder convertedForm = new StringBuilder();
        convertedForm.append("[ ");
        for (int i = 0; i < result.size(); i++) {
            convertedForm.append(result.get(i));
            if (i != result.size() - 1) {
                convertedForm.append(DELIMITER);
            }
        }
        convertedForm.append(" ]");
        return convertedForm.toString();
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String>[] map, boolean isFail, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(map);
        String result = "성공";
        if (isFail) {
            result = "실패";
        }
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
