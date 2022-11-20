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
    public void printMap(List<String> bridge, List<String> userRoute) {
        String bridgeUpLine = getBridgeLine(bridge, userRoute, "U");
        String bridgeDownLine = getBridgeLine(bridge, userRoute, "D");

        System.out.println(bridgeUpLine);
        System.out.println(bridgeDownLine);
    }

    // type 'U', 'D'
    private String getBridgeLine(List<String> bridge, List<String> userRoute, String type) {
        StringBuffer sb = makeBaseLine(userRoute.size());
        for (int i = 0; i < userRoute.size(); i++) {
            if (isCorrectAndEqualsType(bridge.get(i), userRoute.get(i), type)) {
                sb.setCharAt(2 + i * 4, 'O');
                continue;
            }
            if (isWrong(userRoute.get(i), type))
                sb.setCharAt(2 + i * 4, 'X');
        }
        return sb.toString();
    }

    private StringBuffer makeBaseLine(int index) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < index; i++) {
            sb.append("   ");
            if (i != index - 1)
                sb.append("|");
        }
        sb.append("]");
        return sb;
    }

    private boolean isWrong(String userRoute, String type) {
        return type.equals(userRoute);
    }

    private boolean isCorrectAndEqualsType(String bridge, String userRoute, String type) {
        return userRoute.equals(bridge) && type.equals(userRoute);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> userRoute, int count) {
        // TODO 출력하는 로직만 올 수 있도록 수정
        System.out.println();
        System.out.println("최종 게임 결과");
        printMap(bridge, userRoute);
        System.out.println();
        System.out.println("게임 성공 여부: " + convertSuccessOrFailureFormat(bridge.equals(userRoute)));
        System.out.println("총 시도한 횟수: " + count);
    }

    public String convertSuccessOrFailureFormat(boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
        return "실패";
    }
}
