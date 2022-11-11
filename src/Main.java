import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void searchForTitle(List<Game> games, String gameSelcted) {
        Game gameUser = null;
        for (Game game : games) {
            if(game.Name.contains(gameSelcted)) {
                gameUser = game;
                System.out.println(gameUser.toString());
            }
        }
        if(gameUser == null) System.out.println("Jogo não econtrado");
    }

    public static void searchForGenre(List<Game> games, String genreSelected) {
        Game gameUser = null;
        for (Game game : games) {
            if(game.Genre.name().contains(genreSelected)) {
                gameUser = game;
                System.out.println(gameUser.toString());
            }
        }
        if(gameUser == null) System.out.println("Genero não econtrado");
    }

    public static void searchForPrice(List<Game> games, double price) {
        Game gameUser = null;
        for (Game game : games) {
            if(game.Price <= price) {
                gameUser = game;
                System.out.println(gameUser.toString());
            }
        }
        System.out.println("Preço nao encontrado");;
    }

    public static void searchForNumber(List<Game> games, int number){
        int valInital = 0;
        int valFinal = games.size();
        int half;
        int[] numberGame = new int[games.size()];

        for (Game game : games) {
            numberGame[game.number] = game.number;
        }

        while (valInital <= valFinal){
            half = (valInital + valFinal) / 2;

            if(numberGame[half] == number){
                for (Game game : games) {
                    if(game.number == number) {
                        System.out.println(game.toString());
                    }
                }
            }
            if(numberGame[half] < number) valInital = half+1;
            else valFinal = half-1;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int option = 0;

        Game game1 = new Game("Legue Of Legendes", Genres.RPG, 10.99);
        Game game2 = new Game("SLA", Genres.RPG, 200.9);

        List<Game> games = new ArrayList<Game>();
        games.addAll(Arrays.asList(game1, game2));

        System.out.println("SEJA BEM-VINDO");
        while(option != 4){
            System.out.println("\n\nVocê deseja buscar por:\n[0]Titulo\n[1]Gênero\n[2]Preço\n[3]Codigo\n\n[4]Sair\n____________________");
            option = entrada.nextInt();

            switch(option){
                case 0:
                    System.out.println("Digite o titulo do jogo que deseja buscar:");
                    String gameSelected = entrada.next();
                    searchForTitle(games, gameSelected);
                    System.out.println("\nDIGITE QUALQUER TECLA PARA CONTINUAR");
                    entrada.next();
                    break;
                case 1:
                    System.out.println("Digite o gênero do jogo que deseja buscar:");
                    String genreSelected = entrada.next();
                    searchForGenre(games, genreSelected);
                    System.out.println("\nDIGITE QUALQUER TECLA PARA CONTINUAR");
                    entrada.next();
                    break;
                case 2:
                    System.out.println("Digite um preço max para os jogos: ");
                    double priceSelected = entrada.nextDouble();
                    searchForPrice(games, priceSelected);
                    System.out.println("\nDIGITE QUALQUER TECLA PARA CONTINUAR");
                    entrada.next();
                    break;
                case 3:
                    System.out.println("Digite o numero do jogo: ");
                    int numberSelected = entrada.nextInt();
                    searchForNumber(games, numberSelected);
                    System.out.println("\nDIGITE QUALQUER TECLA PARA CONTINUAR");
                    entrada.next();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Valor inválido, digite novamente!");
                    break;
            }
        }
    }
}