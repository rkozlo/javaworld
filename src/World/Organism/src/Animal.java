import java.util.List;
import java.util.Random;

public abstract class Animal extends Organism {
    int hunger;
    protected List<Character> feed;

    Animal(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        super(world, pos, initiative, species, liveLength, powerToReproduce);
        this.hunger = 20;
    }

    public void moveOn(Position newPosition){
        world.getMap().moveOnMap(this, newPosition);
        position.setPosition(newPosition);
    }

    public abstract void feeded();

    public abstract boolean specialAction(Position pos);

@Override
    public void action() {
        if (this.hunger <= 0) {
            world.delOrganism(this);
            return;
        }
        List<Position> positions = world.getNeighboringPositions(this.position);
        Position newPosition;
        Random rand = new Random();

        if (positions != null) {
            while (positions != null) {
                newPosition = positions.get(rand.nextInt(positions.size()));
                Organism orgOnNewPosition = lookForOrganism(newPosition);
                if(this.specialAction(newPosition))
                    break;
                if (canEat(orgOnNewPosition)) {
                    System.out.println(this.species + " zjada " + orgOnNewPosition.species);
                    world.delOrganism(orgOnNewPosition);
                    this.feeded();
                    this.moveOn(newPosition);
                    return;
                }
                if (world.getMap().isFree(newPosition)) {
//                    System.out.println(this.species + " przemieszcza się");
                    moveOn(newPosition);
                    break;
                }
                positions.remove(newPosition);
            }
        }
    }

    public boolean canEat(Organism org){
        if (org != null){
            System.out.println(this.toString());
            for (int i=0; i < this.feed.size(); i++)//for (char sign:this.feed)
                if (org.species == this.feed.get(i))
                    return true;
        }
        return false;
    }
}

