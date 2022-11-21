package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map) {
        StringBuilder printUp = new StringBuilder();
        StringBuilder printDown = new StringBuilder();
        for(String bridge : map){
            if (bridge == "U"){
                printUp.append("[ O ]");
                printDown.append("[   ]");
            }
            else if (bridge == "D"){
                printUp.append("[   ]");
                printDown.append("[ O ]");
            }
        }
        System.out.println(printUp);
        System.out.println(printDown);
    }

    public static List<String> initialPrint(String init){
        List<String> inits = new ArrayList<>();
        String printUp = "";
        String printDown = "";
        if (Objects.equals(init, "U")){
            printDown += "[   ]";
            if(Objects.equals(BridgeMaker.bridge.get(0),init)){
                printUp += "[ O ]";
            }
            else{
                printUp += "[ X ]";
            }
        }
        else if (Objects.equals(init, "D")) {
            printUp += "[   ]";
            if (Objects.equals(BridgeMaker.bridge.get(0), init)) {
                printDown += "[ O ]";
            } else {
                printDown += "[ X ]";
            }
        }
        inits.add(printUp);
        inits.add(printDown);
        return inits;
    }
    public static void print(List<String> map) {
        String printUp = initialPrint(map.get(0)).get(0);
        String printDown = initialPrint(map.get(0)).get(1);

        for(int i=1; i<map.size();i++){
            if (Objects.equals(map.get(i), "U")){
                printDown = printDown.replace("]"," |   ]");
                if(Objects.equals(BridgeMaker.bridge.get(i),map.get(i))){
                    printUp=printUp.replace("]"," | O ]");
                }
                else{
                    printUp=printUp.replace("]"," | X ]");
                }
            }
            else if (Objects.equals(map.get(i), "D")){
                printUp = printUp.replace("]"," |   ]");
                if(Objects.equals(BridgeMaker.bridge.get(i),map.get(i))){
                    printDown=printDown.replace("]"," | O ]");
                }
                else{
                    printDown=printDown.replace("]"," | X ]");
                }
            }
        }
        System.out.println(printUp);
        System.out.println(printDown);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
