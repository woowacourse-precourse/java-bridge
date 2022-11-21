package bridge;

public class OutputView {
    static StringBuilder upper = new StringBuilder();
    static StringBuilder lower = new StringBuilder();

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
            lower.append("X ");
            upper.append("  ");
        }

        if (!death) {
            upper.append("O ");
            lower.append("  ");
        }
    }

    public void curPathUpdate_Down(boolean death) {
        if (death) {
            upper.append("X ");
            lower.append("  ");
        }

        if (!death) {
            lower.append("O ");
            upper.append("  ");
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