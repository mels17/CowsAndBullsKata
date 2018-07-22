public class App {

    public static void main(String... args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        Game game = new Game(reader, writer);
        game.start();
    }
}
