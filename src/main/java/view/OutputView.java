package view;

public class Print {

    static StringBuilder sb;

    static public void printMessage(String str) {
        sb = new StringBuilder();
        sb.append(str);
        System.out.println(sb.toString());
    }
}
