import java.util.ArrayList;

public class Wolf extends Animal {

    Wolf (World world, int x, int y){
        super(world, new Position(x, y), 7, 'W', 40, 12);
        this.feed = new ArrayList<>();
        this.feed.add('S');
    }

    Wolf (World world, Position position){
        super(world, position, 7, 'W', 40, 12);
        this.feed = new ArrayList<>();
        this.feed.add('S');
    }

    public boolean specialAction(Position pos){
        return true;
    }
    public void feeded(){
        this.hunger += 20;
        this.power += 5;
    }
}
