package bridge.domain;

public class MapString {
    private String upstairs;
    private String downstairs;

    public MapString(String upstairs, String downstairs){
        this.upstairs = upstairs;
        this.downstairs = downstairs;
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
