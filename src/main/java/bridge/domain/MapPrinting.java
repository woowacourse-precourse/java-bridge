package bridge.domain;

import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class MapPrinting {

    List<Boolean> upCapable = new ArrayList<>();
    List<Boolean> downCapable = new ArrayList<>();
    static List<Integer> upDownLocation = new ArrayList<>();
    OutputView outputView = new OutputView();
    static final int UP=1;
    static final int DOWN=0;
    int nowIndex;
    static boolean restart=false;


    public MapPrinting(List<Boolean> upCapable, List<Boolean> downCapable, int nowIndex) {
        this.upCapable = upCapable;
        this.downCapable = downCapable;
        this.nowIndex = nowIndex;
    }

    public static boolean isMoveStop() {
        return restart;
    }

    public static void clearUpDownLocation() {
        upDownLocation.clear();
    }

    public static void setRestart() {
        restart=false;
    }

    public void makeList(){
        upDownLocation.add(nowIndex);
        makeUpList();
        makeDownList();
    }



    public void makeUpList(){
        String upListString = "[ ";

        upListString = upListString + addString(upCapable, UP);
        upListString = upListString + "]";
        outputView.printMap(upListString);
    }

    private String addString(List<Boolean> capable, int upDown) {
        String ListString = "";
        for(int i=0; i< capable.size(); i++){
            ListString= ListString+ chooseString(capable, i, upDown);
            if(i == capable.size()-1){
                continue;
            }
            ListString = ListString + "| ";
        }
        return ListString;
    }

    private String chooseString(List<Boolean> bridgeCapable, int i, int upDown) {
        if(bridgeCapable.get(i) && upDownLocation.get(i)==upDown){
            return "O ";
        }
        if(!bridgeCapable.get(i) && upDownLocation.get(i)==upDown){// capable이 갈 수 있는지? 여부 다리가 잇는지, updownLocation 지금 내가 있는 위치  updown은 출력하고자하는 위치
            restart=true;
            return "X ";
        }
        return "  ";
    }

    public void makeDownList(){
        String downListString = "[ ";

        downListString = downListString + addString(downCapable, DOWN);
        downListString = downListString + "]";
        outputView.printMap(downListString);
    }

}
