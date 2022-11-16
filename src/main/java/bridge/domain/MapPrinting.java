package bridge.domain;

import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class MapPrinting {

    List<Boolean> upCapable = new ArrayList<>();
    List<Boolean> downCapable = new ArrayList<>();
    OutputView outputView = new OutputView();
    static final int UP=1;
    static final int DOWN=0;
    int nowIndex;


    public MapPrinting(List<Boolean> upCapable, List<Boolean> downCapable, int nowIndex) {
        this.upCapable = upCapable;
        this.downCapable = downCapable;
        this.nowIndex = nowIndex;
    }

    public void makeList(){
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

    private String chooseString(List<Boolean> capable, int i, int upDown) {
        if(capable.get(i) && upDown==nowIndex){
            return "O ";
        }
        if(capable.get(i) && upDown!=nowIndex){
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


    public void makeWrongList() {
        makeUpList();
        makeDownList();
    }

}
