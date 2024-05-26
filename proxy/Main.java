package proxy;
import java.util.ArrayList;

interface IGamesLibrary {
    public void addGame(Game game);
    public void removeGame(Game game);
    public void playGame(Game game);
    public void showGames();
}

class Game {
    public String title;
    public Game(String title) {
        this.title = title;
    }
}

class GamesLibrary implements IGamesLibrary {
    private ArrayList<Game> games = new ArrayList<>();

    @Override
    public void addGame(Game game) {
        games.add(game);
    }
    @Override
    public void removeGame(Game game) {
        games.remove(game);
    }
    @Override
    public void playGame(Game game) {
        System.out.println("Playing - "+game.title);
    }
    @Override
    public void showGames() {
        System.out.println("Your games collection:");
        for(Game game : games) {
            System.out.println(game.title);
        }
    }
}

class ProxyLibrary implements IGamesLibrary {
    private GamesLibrary gamesLibrary;

    protected ProxyLibrary() {
        gamesLibrary = new GamesLibrary();
    }

    @Override
    public void addGame(Game game) {
        gamesLibrary.addGame(game);
    }
    @Override
    public void removeGame(Game game) {
        gamesLibrary.removeGame(game);
    }
    @Override
    public void playGame(Game game) {
        gamesLibrary.playGame(game);
    }
    @Override
    public void showGames() {
        gamesLibrary.showGames();
    }
}

class Client {
    void performAction() {
        ProxyLibrary library = new ProxyLibrary();

        Game game1 = new Game("The Witcher 3");
        Game game2 = new Game("Cyberpunk 2077");
        Game game3 = new Game("Red Dead Redemption 2");

        library.addGame(game1);
        library.addGame(game2);
        library.addGame(game3);

        library.showGames();
        library.playGame(game1);
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}