package bridge;

public class Bridge {
    private final String upShape;
    private final String downShape;

    Bridge(String upShape, String downShape) {
        this.upShape = upShape;
        this.downShape = downShape;
    }

    public String getUpShape() {
        return upShape;
    }

    public String getDownShape() {
        return downShape;
    }
}
