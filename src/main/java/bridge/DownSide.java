package bridge;

import java.util.ArrayList;
import java.util.List;

public class DownSide {
    private String downSide;
    public List<String> downSideArr = new ArrayList<>();

    public String makeDownSide() {
        String downSideString = String.join(" | ", downSideArr);
        downSide = "[ ";
        downSide += downSideString;
        downSide += " ]";
        return downSide;
    }

    public void addDownSide(String input) {
        downSideArr.add(input);
    }
    public String getDownSide(){
        return downSide;
    }
}
