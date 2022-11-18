package bridge.model;

public enum Floor {
    D, U;

    public static String getName(int value){
        for (Floor floor : values()){
            if (floor.ordinal() == value)
                return floor.name();
        }
        return null;
    }
}
