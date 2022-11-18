package bridge.view;

import bridge.Bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuffer uppperBuffer = new StringBuffer();
    private StringBuffer lowerBuffer = new StringBuffer();
    private Bridge bridge;
    private List<String> choices;

    public OutputView(Bridge bridge) {
        this.bridge = bridge;
    }

    /* 특정 위치의 O X 빈칸 중 하나를 출력한다 */
    public String properOXSpace(String UpOrDown , String directionChoice, String whereToPrint) {
        /* 실제로는 위냐 아래냐, 유저 선택은 뭐냐, 위쪽용 프린터냐 아래쪽용 프린터냐 */
        /* String UpOrDown = bridge.returnCertainIndexUpOrDown(index); */
        if (!(directionChoice.equalsIgnoreCase(whereToPrint))) {
            return " ";
        }
        if (UpOrDown.equalsIgnoreCase(directionChoice)) {
            return "O";
        }

        return "X";
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final int ongoing, List<String> choices) {
        this.choices = choices;

        fillEachBuffer(uppperBuffer, ongoing, "U");
        System.out.println(uppperBuffer);

        fillEachBuffer(lowerBuffer, ongoing, "D");
        System.out.println(lowerBuffer);
    }

    public void fillEachBuffer(StringBuffer buffer, int ongoing, String whereToPrint) {
        buffer.append("[ ");
        for (int i = 0; i<=ongoing; i++) {
            String realUpOrDown = bridge.returnCertainIndexUpOrDown(i);
            buffer.append(properOXSpace(realUpOrDown, choices.get(i), whereToPrint)); // 아!
            if (i != ongoing) {
                buffer.append(" | ");
            }
        }
        buffer.append(" ]");
    }

    public void clearBuffer() {
        uppperBuffer.delete(0,uppperBuffer.length());
        lowerBuffer.delete(0,lowerBuffer.length());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printResult(boolean pass, int tryNumber) {
        printWinorLose(pass);
        System.out.println(uppperBuffer.toString());
        System.out.println(lowerBuffer.toString());
        printTryNumbers(tryNumber);
    }

    public void printWinorLose(boolean pass) {
        String result = "";
        if (pass) {
//            result = "성공" ;
            result = "success";
        } else {
//            result = "실패";
            result = "fail";
        };
//        System.out.printf("게임 성공 여부: %s\n", result);
        System.out.printf("game success or not: %s\n", result);
    }

    public void printTryNumbers(int tryNumber) {
//        System.out.printf("총 시도한 횟수: %s", tryNumber);
        System.out.printf("all tried number: %s", tryNumber);
    }
}

