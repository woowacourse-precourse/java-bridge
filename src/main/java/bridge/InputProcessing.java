package bridge;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

public class InputProcessing {

    private InputView inputView;
    private List<String> upSide;
    private List<String> downSide;

    public InputProcessing(){
        inputView = new InputView();
        upSide = new ArrayList<>();
        downSide = new ArrayList<>();
    }

    //이부분 바꿀 수 있다면 노력해보자
    //랜덤으로 입력된 브릿지를 매개변수로 사용자의 입력과 매치한다.
    public void matchInput(List<String> bridge){
        for (int i = 0 ; i < bridge.size();) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = inputView.readMoving();
            if (input.length() == 0){
                continue;
            }
            if (jumpToBridge(bridge, input, i++)){
                return;
            }
        }
    }

    public boolean jumpToBridge(List<String> bridge, String input, int i){
        if (input.equals(bridge.get(i))){
            selectedBridgeIsSucceed(input);
        }
        if (!input.equals(bridge.get(i))){
            selectedBridgeIsFail(input);
            return true;
        }
        return false;
    }

    public void selectedBridgeIsSucceed(String input) {
        if (input.equals("U")) {
            upSide.add("O");
            downSide.add(" ");
        }
        if (input.equals("D")) {
            upSide.add(" ");
            downSide.add("O");
        }
    }

    public void selectedBridgeIsFail(String input) {
        if (input.equals("U")) {
            upSide.add("X");
            downSide.add(" ");
        }
        if (input.equals("D")) {
            upSide.add(" ");
            downSide.add("X");
        }
    }
    public void printBridge(){
        System.out.println(upSide.stream().collect(joining(" | ", "[ ", " ]")));
        System.out.println(downSide.stream().collect(joining(" | ", "[ ", " ]")));
    }
}
