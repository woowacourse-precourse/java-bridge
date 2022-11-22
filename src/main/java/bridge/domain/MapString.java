package bridge.domain;

public class MapString {
    private String upstairs;
    private String downstairs;

    public MapString(String upstairs, String downstairs){
        this.upstairs = upstairs;
        this.downstairs = downstairs;
    }

    public void makeMapStringWhenSuccess(String input){
        if (input.equals("U")){
            upstairs += "O";
            downstairs += " ";
            return ;
        }
        upstairs += " ";
        downstairs += "O";
    }

    public void makeMapStringWhenFail(String input){
        if (input.equals("U")){
            upstairs += "X";
            downstairs += " ";
            return ;
        }
        upstairs += " ";
        downstairs += "X";
    }

    public String getUpstairs(){
        return (this.upstairs);
    }

    public String getDownstairs(){
        return (this.downstairs);
    }
}
