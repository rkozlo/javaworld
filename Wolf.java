import java.util.ArrayList;
import java.util.Random;

public class Wolf extends Animal {

    Wolf (World world, int x, int y){
        super(world, new Position(x, y), 7, 'W', 70, 30);
        this.feed = new ArrayList<>();
        this.feed.add('S');
    }

    Wolf (World world, Position position){
        super(world, position, 7, 'W', 70, 30);
        this.feed = new ArrayList<>();
        this.feed.add('S');
    }

    public boolean specialAction(Position pos){
        return true;
    }
    public void feeded(){
        this.hunger += 30;
        this.power += 4;
    }

    public boolean reproduce(Position position){
        Random random = new Random();
        this.power /= 2;
        if(random.nextInt(3) == 0)
            world.addOrganism(this.getSpecies(), position);
        else
            return false;
        return true;
    }
}