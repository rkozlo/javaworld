import java.util.Random;

public class Grass extends Plant {
    public Grass(World world, Position pos){
        super(world, pos, 0, 'G', 10, 6);
    }

    Grass(World world, int x, int y){
        super(world, new Position(x, y),  0, 'G', 30, 6);

    }

    public void individualAction(){}

    public void move(){}

    @Override
    public boolean reproduce(Position pos){
        Random rand = new Random();
        if(rand.nextInt(2) == 0) {
            world.addOrganism(new Grass(world, pos));
            return true;
        }
        return false;
    }
}
