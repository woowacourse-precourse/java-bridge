package view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> userInput) {
        StringBuilder firstRow = new StringBuilder("[");
        StringBuilder secondRow = new StringBuilder("[");

        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i).equals("U")) {
                if (userInput.get(i).equals(bridge.get(i))){
                    firstRow.append(" O ");
                    firstRow.append("|");
                    continue;
                }
                firstRow.append(" X ");
                firstRow.append("|");
            } else if (userInput.get(i).equals("D")) {
                if (userInput.get(i).equals(bridge.get(i))){
                    secondRow.append(" O ");
                    secondRow.append("|");
                    continue;
                }
                secondRow.append(" X ");
                secondRow.append("|");
            }
        }

        firstRow.deleteCharAt(userInput.size() - 1);
        secondRow.deleteCharAt(userInput.size() - 1);
        firstRow.append("]");
        secondRow.append("]");

        System.out.println(firstRow.toString());
        System.out.println(secondRow.toString());
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
