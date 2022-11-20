package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String PARTITION = " | ";
    private static final String HEAD = "[ ";
    private static final String TAIL = " ]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final Bridge bridge, List<String> movings) {
        System.out.print(HEAD);
        printUpperMap(bridge, movings);
        System.out.println(TAIL);
        System.out.print(HEAD);
        printLowerMap(bridge, movings);
        System.out.println(TAIL);
    }

    public void printUpperMap(final Bridge bridge, final List<String> movings){
        for (int i = 0; i < movings.size(); i++) {
            if(isO(bridge,movings,i)) {
                printOorBlankOnUpperMap(movings.get(i));
            }
            if(!isO(bridge,movings,i)){
                System.out.print("X");
            }
            System.out.print(PARTITION);
        }
    }

    public void printLowerMap(final Bridge bridge, final List<String> movings){
        for (int i = 0; i < movings.size(); i++) {
            if(isO(bridge,movings,i)) {
                printOorBlankOnLowerMap(movings.get(i));
            }
            if(!isO(bridge,movings,i)){
                System.out.print("X");
            }
            System.out.print(PARTITION);
        }
    }

    public void printOorBlankOnUpperMap(String moving){
        if(moving.equals("U")){
            System.out.print("O");
        }
        if(moving.equals("D")){
            System.out.print(" ");
        }
    }

    public void printOorBlankOnLowerMap(String moving){
        if(moving.equals("D")){
            System.out.print("O");
        }
        if(moving.equals("U")){
            System.out.print(" ");
        }
    }

    public boolean isO(final Bridge bridge, final List<String> movings, int index){
       if(bridge.hasUAtIndex(index) & movings.get(index).equals("U")){
           return true;
       }
       if(!bridge.hasUAtIndex(index) & movings.get(index).equals("D")){
           return true;
       }
       return false;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
