package bridge;

public class SbMap {

    private final StringBuilder upSb;
    private final StringBuilder downSb;

    public SbMap() {
        upSb = new StringBuilder();
        downSb = new StringBuilder();
    }

    public void print() {
        System.out.println(upSb);
        System.out.println(downSb);
    }

    public void append(String str) {
        upSb.append(str);
        downSb.append(str);
    }

    public void deleteCharAt(int idx) {
        upSb.deleteCharAt(idx);
        downSb.deleteCharAt(idx);
    }

    public StringBuilder getUpSb() {
        return upSb;
    }

    public StringBuilder getDownSb() {
        return downSb;
    }
}
