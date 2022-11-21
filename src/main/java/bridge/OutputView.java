package bridge;

// 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.

public class OutputView {

    static StringBuilder upperBridge = new StringBuilder();
    static StringBuilder lowerBridge = new StringBuilder();

    final String deathStep = " X";
    final String safeStep = " O";
    final String notStep = "  ";

    public void printMap(String userDirection, boolean dead) {
        if (userDirection.equals("U")) upperMove(dead);
        if (userDirection.equals("D")) lowerMove(dead);

        System.out.println("[" + upperBridge + " ]");
        System.out.println("[" + lowerBridge + " ]");

        upperBridge.append(" |");
        lowerBridge.append(" |");

        if (dead) resetBridge();
    }

    public void upperMove(boolean dead) {
        if (dead) upperBridge.append(deathStep);
        if (!dead) upperBridge.append(safeStep);
        lowerBridge.append(notStep);
    }

    public void lowerMove(boolean dead) {
        if (dead) lowerBridge.append(deathStep);
        if (!dead) lowerBridge.append(safeStep);
        upperBridge.append(notStep);
    }

    public void resetBridge() {
        upperBridge.setLength(0);
        lowerBridge.setLength(0);
    }

    public void printResult(boolean success, int trial) {
        System.out.println("최종 게임 결과");
        System.out.println("[" + upperBridge + " ]");
        System.out.println("[" + lowerBridge + " ]");
        if (success) System.out.println("게임 성공 여부: 성공");
        if (!success) System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시대한 횟수: " + trial);
    }
}
