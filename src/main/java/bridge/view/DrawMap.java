package bridge.view;

import java.util.ArrayList;
import java.util.List;

public class DrawMap {
    private List<String> topList = new ArrayList<>();
    ;
    private List<String> bottomList = new ArrayList<>();

    private String user;
    private String upDown;

    public List<String> getTopList() {
        return topList;
    }

    public List<String> getBottomList() {
        return bottomList;
    }

    public void map(String user, String upDown) {
        this.user = user;
        this.upDown = upDown;
        addTopList();
        addBottomList();
    }

    public void addTopList() {
        if(upDown.equals("U")){
            topList.add(user);
            bottomList.add(" ");
        }
    }

    public void addBottomList() {
        if(upDown.equals("D")){
            topList.add(" ");
            bottomList.add(user);
        }
    }
}
