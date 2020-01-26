import java.util.ArrayList;

public class Wolf extends Animal {

    Wolf (World world, int x, int y){
        super(world, new Position(x, y), 7, 'W', 90, 50);
        this.feed = new ArrayList<>();
        this.feed.add('S');
    }

    Wolf (World world, Position position){
        super(world, position, 7, 'W', 90, 50);
        this.feed = new ArrayList<>();
        this.feed.add('S');
    }
    @Override
    public void feeded(){
        this.hunger += 20;
        this.power += 2;
    }
    @Override
    public void reproduce(Position position){
        this.power -= powerToReproduce;
        world.getFactory().getOrganism(this.getSpecies(), position);
    }
}
