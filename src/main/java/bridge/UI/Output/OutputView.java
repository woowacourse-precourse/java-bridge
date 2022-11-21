package bridge.UI.Output;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    List<String> bridge;
    StringBuilder top;
    StringBuilder bottom;


    public OutputView(List<String> bridge){
        this.bridge = bridge;
        this.top = new StringBuilder();
        this.bottom = new StringBuilder();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean printMap(int currentLocation, String move) {
        boolean flag = true;
        if(move.equals("U")) flag = compareTop(currentLocation);

        if(move.equals("D")) flag = compareBottom(currentLocation);

        System.out.println(formattingBridge(top));
        System.out.println(formattingBridge(bottom));

        return flag;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean flag, int count) {
        String isSuccess = "실패";
        System.out.println("\n최종 게임 결과");
        System.out.println(formattingBridge(this.top));
        System.out.println(formattingBridge(this.bottom));

        if(flag) isSuccess = "성공";

        System.out.println("\n게임 성공 여부: " + isSuccess);
        System.out.println("총 시도한 횟수: " + count);
    }

    private boolean compareTop(int location) {
        // 다리를 맞춘 경우
        if(bridge.get(location).equals("U")) {
            top.append('O');
            bottom.append(' ');
            return true;
        }

        // 다리를 틀린 경우
        top.append('X');
        bottom.append(' ');
        return false;
    }

    private boolean compareBottom(int location) {
        // 다리를 맞춘 경우
        if(bridge.get(location).equals("D")) {
            bottom.append('O');
            top.append(' ');
            return true;
        }

        // 다리를 틀린 경우
        bottom.append('X');
        top.append(' ');
        return false;
    }

    public void clear() {
        this.top = new StringBuilder();
        this.bottom = new StringBuilder();
    }

    private String formattingBridge(StringBuilder bridgeSide) {
        StringBuilder builder = new StringBuilder();

        builder.append('[');

        for(int i = 0; i < bridgeSide.length(); i++){
            builder.append(' ')
                    .append(bridgeSide.charAt(i))
                    .append(' ')
                    .append('|');

        }
        builder.deleteCharAt(builder.lastIndexOf("|"));
        builder.append(']');

        return builder.toString();
    }

}
