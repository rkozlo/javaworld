import java.util.Random;

public class Grass extends Plant {
    public Grass(World world, Position pos){
        super(world, pos, 0, 'G', 60, 1);
    }

    Grass(World world, int x, int y){
        super(world, new Position(x, y),  0, 'G', 60, 1);

    }

    @Override
    public boolean reproduce(Position pos){
        Random rand = new Random();
//        if(rand.nextInt(2) == 1) {
            world.addOrganism(new Grass(world, pos));
//            return true;
//        }
        return false;
    }
}
