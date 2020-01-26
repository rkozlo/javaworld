public class main {

    public static void main(String[] args) {
        World world = new World(40, 20);
        world.fillTheWorld();
        while(true)
            world.makeTurn();
    }
}