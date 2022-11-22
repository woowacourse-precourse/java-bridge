package bridge.View;

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
    public void printMap() {

        System.out.printf("[%s ]\n", upSideIndex);
        System.out.printf("[%s ]\n", downSideIndex);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean success, int attempt) {
        System.out.println(Message.RESULT_STRING);
        printMap();
        System.out.println(Message.WIN_OR_LOSE + succesString(success));
        System.out.println(Message.NUM_OF_ATTEMPT + attempt);
    }

    public void buildIndex(String move, String result, int position) {
        String tempstr = separator(position);
        if (move.equals("U")) {
            this.upSideIndex += tempstr;
            this.upSideIndex += result;
            this.downSideIndex += tempstr + " ";
            return;
        }
        this.downSideIndex += tempstr;
        this.downSideIndex += result;
        this.upSideIndex += tempstr + " ";
    }

    private String separator(int position) {
        if (position > 0) {
            return " | ";
        }
        return " ";
    }

    public void resetIndex() {
        this.upSideIndex = "";
        this.downSideIndex = "";
    }

    private String succesString(boolean success) {
        if (success == true) {
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    public static void gameStart() {
        System.out.println(Message.START_GAME);
    }

}
