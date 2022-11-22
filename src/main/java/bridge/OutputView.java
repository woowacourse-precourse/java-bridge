package bridge;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> currentPath) {
        int sz = currentPath.size()*4;

        System.out.println("["+makePath(currentPath, ("U")).substring(0, sz-1)+"]");
        System.out.println("["+makePath(currentPath, ("D")).substring(0, sz-1)+"]");
    }

    private String makePath(List<String> currentPath, String keyString) {
        return currentPath.stream().map((String s) -> (s.equals(keyString)) ? " O |" : "   |").collect(Collectors.joining());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
