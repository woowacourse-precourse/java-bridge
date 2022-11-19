package bridge;

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
    public void printMap(List<String> userPaths, boolean recentResult) {
        printUpTunnel(userPaths, recentResult);
        printDownTunnel(userPaths, recentResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userPaths, int currentLocation, int tryCount) {
        System.out.println("최종 게임 결과");
        if (userPaths.size() > currentLocation) {
            printMap(userPaths, false);
        } else {
            printMap(userPaths, true);
        }

        System.out.println();

        if (userPaths.size() == currentLocation) {
            System.out.println("게임 성공 여부: 성공");
        } else {
            System.out.println("게임 성공 여부: 실패");
        }

        System.out.println("총 시도한 횟수: " + tryCount);


    }

    //위 칸(1번째 줄)을 출력하는 함수
    private void printUpTunnel(List<String> userPaths, boolean recentResult) {
        String upTunnel = "[";
        int index = 0;
        for ( ; index < userPaths.size() - 1; index++) {
            String currentPath = userPaths.get(index);
            upTunnel += getSquareResult(currentPath, "U");
        }
        upTunnel += getLastSquareResult(userPaths.get(index), recentResult, "U");

        System.out.println(upTunnel);
    }

    //아래 칸(2번째 줄)을 출력하는 함수
    private void printDownTunnel(List<String> userPaths, boolean recentResult) {
        String downTunnel = "[";
        int index = 0;
        for ( ; index < userPaths.size() - 1; index++) {
            String currentPath = userPaths.get(index);
            downTunnel += getSquareResult(currentPath, "D");
        }
        downTunnel += getLastSquareResult(userPaths.get(index), recentResult, "D");

        System.out.println(downTunnel);
    }

    private String getSquareResult(String currentPath, String floor) {
        if (currentPath.equals(floor)) {
            return " O |";
        }

        return "   |";
    }

    private String getLastSquareResult(String lastUserPath, boolean recentResult, String bridgePath) {
        if (lastUserPath.equals(bridgePath)) {
            if (recentResult == true) {
                return " O ]";
            }
            return " X ]";
        }

        return "   ]";
    }
}
