package bridge.enums;

public enum DorU {
    DOWN("D",0),
    UP("U",1);


    private final String name;
    private final Integer number;

    DorU(String name, Integer number){
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public Integer getNumber() {
        return number;
    }

    public static String numberConvertName(int object){
        if (object == DOWN.number){
            return DOWN.name;
        }
        return UP.name;
    }
}
