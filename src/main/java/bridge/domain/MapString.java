package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MapString {
    private String upstairs = "";
    private String downstairs = "";

    public MapString(String upstairs, String downstairs){
        this.upstairs = upstairs;
        this.downstairs = downstairs;
    }
    public List<String> makeMapString(String upstairs, String downstairs){
        List<String> mapString = new ArrayList<>();
        mapString.add(upstairs);
        mapString.add(downstairs);
        return (mapString);
    }

    public String getUpstairs(){
        return (this.upstairs);
    }

    public String getDownstairs(){
        return (this.downstairs);
    }

    public void setUpstairs(String str){
        this.upstairs += str;
    }

    public void setDownstairs(String str){
        this.downstairs += str;
    }
}
