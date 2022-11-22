package bridge;

public class OutputView {
    static StringBuilder upper = new StringBuilder();
    static StringBuilder lower = new StringBuilder();

    final static String goodMove = "O ";
    final static String badMove = "X ";
    final static String noMove = "  ";

    public void printMap(String curStep, boolean death) {
        if (curStep.equals("U")) curPathUpdate_Up(death);
        if (curStep.equals("D")) curPathUpdate_Down(death);

        System.out.println("[ " + upper + "]");
        System.out.println("[ " + lower + "]");

        upper.append("| ");
        lower.append("| ");
    }

    public void curPathUpdate_Up(boolean death) {
        if (death) {
            lower.append(badMove);
            upper.append(noMove);
        }

        if (!death) {
            upper.append(goodMove);
            lower.append(noMove);
        }
    }

    public void curPathUpdate_Down(boolean death) {
        if (death) {
            upper.append(badMove);
            lower.append(noMove);
        }

        if (!death) {
            lower.append(goodMove);
            upper.append(noMove);
        }
    }

    public void outputReset(String command) {
        if (command.equals("R")) {
            upper.setLength(0);
            lower.setLength(0);
        }
    }

    public void printResult(boolean death, int count) {
        System.out.println();
        System.out.println("최종 게임 결과");
        System.out.println("[ " + upper.substring(0, upper.length() - 2) + "]");
        System.out.println("[ " + lower.substring(0, upper.length() - 2) + "]");
        if (death) System.out.println("게임 성공 여부: 실패");
        if (!death) System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: " + count);
    }
}