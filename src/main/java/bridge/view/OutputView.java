package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String upSideIndex = "";
    private String downSideIndex = "";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int count, String moving, boolean isPass) {
        if (moving.equals("U")) {
            setUpSideIndex(count, isPass);
        }
        if (moving.equals("D")) {
            setDownSideIndex(count, isPass);
        }
        System.out.println("[" + upSideIndex + "]");
        System.out.println("[" + downSideIndex + "]");
    }

    public void setUpSideIndex(int count, boolean isPass) {
        if (isPass) {
            upSideIndex += addDelimiter(count) + " O ";
            downSideIndex += addDelimiter(count) + "   ";
            return;
        }
        upSideIndex += addDelimiter(count) + " X ";
        downSideIndex += addDelimiter(count) + "   ";
    }

    public void setDownSideIndex(int count, boolean isPass) {
        if (isPass) {
            upSideIndex += addDelimiter(count) + "   ";
            downSideIndex += addDelimiter(count) + " O ";
            return;
        }
        upSideIndex += addDelimiter(count) + "   ";
        downSideIndex += addDelimiter(count) + " X ";
    }

    public String addDelimiter(int count) {
        if (count > 1) {
            return "|";
        }
        return "";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int totalNumberOfAttempts) {
        System.out.println("최종 게임 결과");
        String result = "실패";
        if (isSuccess) {
            result = "성공";
        }
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + totalNumberOfAttempts);
    }
}
