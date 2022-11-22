package bridge;

public class MakeList {
    private static String upList;
    private static String downList;

    public MakeList(String upList, String downList){
        this.upList = upList;
        this.downList = downList;
    }

    public String getUpList(){
        return upList;
    }

    public String getDownList(){
        return downList;
    }

    public static MakeList something(){
        String upList = "[O]";
        String downList = "[X]";

        return new MakeList(upList, downList);
    }

    public static MakeList falsePrint(String ans, int count) {
        if(ans.equals("U")) {
            if (count == 0) {
                String upList = " X ";
            }
            if (count > 0) {
                String upList = "| X ";
            }
            String downList = " ";
        }
        if(ans.equals("D")){
            if(count == 0){
                String downList = " X ";
            }
            if(count > 0){
                String downList = "| X ";
            }
            String upList =" ";
        }
        return new MakeList(upList, downList);
    }
}
