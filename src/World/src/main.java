public class main {

    public static void main(String[] args) {
        World world = new World(100, 40);
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('W');
//        world.addRandomOrganism('W');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('T');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('T');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('W');
//        world.addRandomOrganism('W');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('T');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('T');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('W');
//        world.addRandomOrganism('W');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('S');
//        world.addRandomOrganism('T');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('G');
//        world.addRandomOrganism('T');
        world.fillTheWorld();
        int i = 0;
        while (i < 200) {
            world.makeTurn();
            i++;

        }
    }
}
