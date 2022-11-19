package view;

import domain.AllBridge;

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
    public void printMap(AllBridge allBridge,int dis) {
        String upper = makeUpperCase(allBridge,dis);
        String lower = makeLowerCase(allBridge,dis);

        System.out.println(upper);
        System.out.println(lower);
    }

    public String makeUpperCase(AllBridge allBridge,int dis) {
        List<String> bridge = allBridge.getBridge();
        String upper = "[";
        for(int i=0; i<dis-1; i++) {
            upper += up(bridge.get(i)) + "|";
        }
        upper += up(bridge.get(dis-1)) + "]";
        return upper;
    }

    public String makeLowerCase(AllBridge allBridge,int dis) {
        List<String> bridge = allBridge.getBridge();
        String lower = "[";
        for(int i=0; i<dis-1; i++) {
            lower += down(bridge.get(i)) + "|";
        }
        lower += down(bridge.get(dis-1)) + "]";
        return lower;
    }

    public String up(String str) {
        if(str.equals("U")) {
            return " O ";
        }
        return "   ";
    }

    private String down(String str) {
        if(str.equals("D")) {
            return " O ";
        }
        return "   ";
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
