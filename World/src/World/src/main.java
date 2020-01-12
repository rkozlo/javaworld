import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        World world = new World(10, 10);
        Grass trawa = new Grass(world, 2, 9);
        Sheep owca = new Sheep(world, 1, 1);
        int i = 0;
        while (i < 20) {
            world.makeTurn();
            i++;
            if (i == 5) {
                Scanner scan = new Scanner(System.in);
            }
        }
    }
}
