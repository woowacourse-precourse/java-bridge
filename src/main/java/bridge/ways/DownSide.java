package bridge.ways;

import java.util.ArrayList;
import java.util.List;

public class DownSide {
    private String downSide;
    public List<String> downSideArr = new ArrayList<>();

    public void makeDownSide() {
        String downSideString = String.join(" | ", downSideArr);
        downSide = "[ ";
        downSide += downSideString;
        downSide += " ]";
    }

    public String getDownSide(){
        return downSide;
    }
}
