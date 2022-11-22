package bridge.data.way;

import java.util.ArrayList;
import java.util.List;

public class UpSide {
    private String upSide;
    public List<String> upSideArr = new ArrayList<>();

    public void makeUpSide() {
        String upSideString = String.join(" | ", upSideArr);
        upSide = "[ ";
        upSide += upSideString;
        upSide += " ]";
    }

    public String getUpSide(){
        return upSide;
    }
}
