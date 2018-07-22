public class ConsoleWriter implements Writer {
    @Override
    public void write(String input) {
        System.out.println(input);
    }
}
