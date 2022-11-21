package view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public OutputView() {
        printStart();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> userInput) {
        StringBuilder firstRow = new StringBuilder("[");
        StringBuilder secondRow = new StringBuilder("[");

        firstRow = drawFirstRowInMap(bridge, userInput, firstRow);
        secondRow = drawSecondRowInMap(bridge, userInput, secondRow);

        System.out.println(wrapUpMap(firstRow,secondRow));
    }

    private StringBuilder drawFirstRowInMap(List<String> bridge, List<String> userInput, StringBuilder map) {
        for (int i = 0; i < userInput.size(); i++) {

            if (userInput.get(i).equals("U")) {
                boolean isCorrect = userInput.get(i).equals(bridge.get(i));
                map = markMap(map, isCorrect);
                continue;
            }
            map = fillMap(map);
        }
        return map;
    }

    private StringBuilder drawSecondRowInMap(List<String> bridge, List<String> userInput, StringBuilder map) {
        for (int i = 0; i < userInput.size(); i++) {

            if (userInput.get(i).equals("D")) {
                boolean isCorrect = userInput.get(i).equals(bridge.get(i));
                map = markMap(map, isCorrect);
                continue;
            }
            map = fillMap(map);
        }
        return map;
    }

    private StringBuilder markMap(StringBuilder row, boolean isCorrect) {
        if (isCorrect) {
            row.append(" O ");
            row.append("|");
            return row;
        }
        row.append(" X ");
        row.append("|");
        return row;
    }

    private StringBuilder fillMap(StringBuilder row) {
        row.append("   ");
        row.append("|");
        return row;
    }

    private String wrapUpMap(StringBuilder fisrtRow, StringBuilder secondRow) {
        fisrtRow.deleteCharAt(fisrtRow.length() - 1);
        fisrtRow.append("]");

        secondRow.deleteCharAt(secondRow.length() - 1);
        secondRow.append("]");

        return fisrtRow.toString()+"\n"+secondRow.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printAskingForSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printSelection() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
}
