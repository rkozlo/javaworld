import java.util.ArrayList;

public class Sheep extends Animal {

    Sheep(World world, int x, int y) {
        super(world, new Position(x, y), 5, 'S', 35, 20);
        this.feed = new ArrayList<>();
        feed.add('G');
    }

    Sheep(World world, Position position) {
        super(world, position, 5, 'S', 35, 20);
        this.feed = new ArrayList<>();
        feed.add('G');
    }
    @Override
    public void feeded() {
        this.power += 3;
        this.hunger += 30;
    }
    @Override
    public void reproduce(Position position){
        this.power -= powerToReproduce;
        world.getFactory().getOrganism(species, position);
    }
}
