public class App {

    public static void main(String... args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        SecretFactory secretFactory = new RandomNumberSecretFactory();

        Game game = new Game(reader, writer, secretFactory);
        game.start();
    }
}
