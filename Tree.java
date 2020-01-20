import java.util.Random;

public class Tree extends Plant{
    public Tree(World world, Position pos){
        super(world, pos, 0, 'T', 200, 100);
    }

    @Override
    public boolean reproduce(Position newPosition) {
        Random rand = new Random();
        boolean status = false;
        if(rand.nextInt(2) == 0) {
            world.addOrganism(new Tree(world, newPosition));
            status = true;
        }
        return status;
    }
}
