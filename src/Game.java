public class Game {
    public String Name;
    public Genres Genre;
    public double Price;
    public int number;
    static int num = 0;

    public Game(String Name, Genres Genre, double Price) {
        this.Name = Name;
        this.Genre = Genre;
        this.Price = Price;
        this.number = num++;
    }

    @Override
    public String toString() {
        return "Codigo: " + number + " | Titulo: " + this.Name + " | Genero: " + this.Genre + " | Preço: " + this.Price;
    }
}

enum Genres {
    ACAO,
    AVENTURA,
    RPG,
    SIMULACAO,
    PUZZLE,
    ESPORTES,
    ESTRATEGIA,
    NENHUM
}
