public class MyArrayDataExeption extends NumberFormatException {
    private int i;
    private int j;

    public MyArrayDataExeption(String s, int i, int j) {
        super(s);
        this.i = i;
        this.j = j;
    }
}
