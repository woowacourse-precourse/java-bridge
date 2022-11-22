package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> currentPath, List<String> answerPath) {
        int sz = currentPath.size() * 4;

        System.out.println("[" + makePath(currentPath, answerPath, "U").substring(0, sz - 1) + "]");
        System.out.println("[" + makePath(currentPath, answerPath, "D").substring(0, sz - 1) + "]");
    }

    private String makePath(List<String> currentPath, List<String> answerPath, String keyString) {

        return IntStream.range(0, currentPath.size()).boxed()
                .map((idx) -> getNextPathString(currentPath.get(idx), answerPath.get(idx), keyString)).collect(Collectors.joining());
    }

    private String getNextPathString(String current, String answer, String keyString) {
        if (!current.equals(keyString))
            return "   |";
        if (current.equals(answer)) {
            return " O |";
        }
        return " X |";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryNumber, List<String> currentPath, List<String> answerPath) {
        System.out.println("최종 게임 결과");
        printMap(currentPath, answerPath);
        System.out.println();

        boolean ok = true;
        for (int i = 0; i < currentPath.size(); i++) {
            if (currentPath.get(i).equals(answerPath.get(i)))
                continue;
            ok = false;
        }

        System.out.printf("게임 성공 여부: %s\n", ok ? "성공" : "실패");
        System.out.printf("총 시도한 횟수: %d\n", tryNumber);
    }
}
