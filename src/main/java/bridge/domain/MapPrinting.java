package bridge.domain;

import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class MapPrinting {

    private List<Boolean> upCapable;
    private List<Boolean> downCapable;
    private static List<Integer> upDownLocation = new ArrayList<>();
    private OutputView outputView = new OutputView();
    private int nowIndex;
    private static boolean stop =false;


    public MapPrinting(List<Boolean> upCapable, List<Boolean> downCapable, int nowIndex) {
        this.upCapable = upCapable;
        this.downCapable = downCapable;
        this.nowIndex = nowIndex;
    }

    public static boolean isMoveStop() {
        return stop;
    }

    public static void clearUpDownLocation() {
        upDownLocation.clear();
    }

    public static void initRestart() {
        stop =false;
    }

    public void makeList(){
        upDownLocation.add(nowIndex);
        makeUpList();
        makeDownList();
        System.out.println();
    }


    private void makeUpList(){
        String upListString = "[ ";
        final int UP=1;
        upListString = upListString + addString(upCapable, UP);
        upListString = upListString + "]";
        outputView.printMap(upListString);
    }

    private String addString(List<Boolean> bridgeCapable, int upDown) {
        String ListString = "";
        for(int index=0; index< bridgeCapable.size(); index++){
            ListString= ListString + chooseString(bridgeCapable, index, upDown);
            if(isIndexBetweenSpace(index, bridgeCapable.size())){
                continue;
            }
            ListString = ListString + "| ";
        }
        return ListString;
    }

    private boolean isIndexBetweenSpace(int index, int bridgeCapableSize) {
        bridgeCapableSize= bridgeCapableSize-1;
        return index == bridgeCapableSize;
    }

    private String chooseString(List<Boolean> bridgeCapable, int i, int upDown) {
        if(bridgeCapable.get(i) && upDownLocation.get(i)==upDown){
            return "O ";
        }
        if(!bridgeCapable.get(i) && upDownLocation.get(i)==upDown){// capable이 갈 수 있는지? 여부 다리가 잇는지, updownLocation 지금 내가 있는 위치  updown은 출력하고자하는 위치
            stop =true;
            return "X ";
        }
        return "  ";
    }

    private void makeDownList(){
        String downListString = "[ ";
        final int DOWN= 0;
        downListString = downListString + addString(downCapable, DOWN);
        downListString = downListString + "]";
        outputView.printMap(downListString);
    }

}
