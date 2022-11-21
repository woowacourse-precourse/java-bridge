package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static List<String> mapUp = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
    private static List<String> mapDown = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
    private static final String CONTOUR = " | ";
    private static String str;
    String addOxContour;
    String emptyContour;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String ox, int order, String upDown) {
        addOxContour = CONTOUR + ox;
        emptyContour = CONTOUR + " ";

        // X가 틀린 곳에 있어야함..

        if(order == 0){
            addOxContour = ox;
            emptyContour = " ";
        }

        if(upDown.equals("U")){
            mapUp.add(mapUp.size()-1,addOxContour);
            mapDown.add(mapDown.size()-1,emptyContour);
        } else if (upDown.equals("D")) {
            mapUp.add(mapUp.size()-1,emptyContour);
            mapDown.add(mapDown.size()-1,addOxContour);
        }

        this.str = String.join("", mapUp) + "\n" + String.join("", mapDown);

        System.out.println(str);
    }

    public void resetMap(){
        this.mapUp = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
        this.mapDown = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryNumber, String successFail) {
        System.out.println("최종 게임 결과");
        System.out.println(this.str);

        System.out.println("게임 성공 여부: "+successFail+"\n"
                + "총 시도한 횟수: "+tryNumber);

    }
}
