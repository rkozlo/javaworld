import java.util.ArrayList;
import java.util.Random;

public class Sheep extends Animal {

    Sheep(World world, int x, int y) {
        super(world, new Position(x, y), 5, 'S', 80, 25);
        this.feed = new ArrayList<>();
        feed.add('G');
    }

    Sheep(World world, Position position) {
        super(world, position, 5, 'S', 40, 25);
        this.feed = new ArrayList<>();
        feed.add('G');
    }

    public void feeded() {
        this.power += 2;
        this.hunger += 60;
    }

    public boolean reproduce(Position position){
        Random random = new Random();
        this.power /= 2;
        if(random.nextInt(2) == 0)
            world.addOrganism(this.getSpecies(), position);
        else
            return false;
        return true;
    }

    public boolean specialAction(Position pos){
        Organism lookedOrganism = lookForOrganism(pos);
        if (lookedOrganism != null && lookedOrganism instanceof Grass){
//            System.out.println(this.species + " zjada " + lookedOrganism.species);
            world.delOrganism(lookedOrganism);
            this.feeded();
            this.moveOn(pos);
            return true;
        }
        if (lookedOrganism == null){
            this.moveOn(pos);
            return true;
        }
        return false;
    }
}
