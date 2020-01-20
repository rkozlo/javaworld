import java.util.Random;

public class main {

    public static void main(String[] args) {
        World world = new World(100, 40);
        world.fillTheWorld();
        while(true)
            world.makeTurn();

    }
}
