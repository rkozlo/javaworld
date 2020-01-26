import java.util.List;
import java.util.Random;

public abstract class Animal extends Organism implements AnimalInterface{
    protected int hunger;
    protected List<Character> feed;

    Animal(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        super(world, pos, initiative, species, liveLength, powerToReproduce);
        this.hunger = 30;
    }

    public void moveOn(Position newPosition){
        world.getMap().moveOnMap(this, newPosition);
        position.setPosition(newPosition);
    }

    private Position lookForFood(List<Position> list){
        for(int i=0; i<list.size(); i++)
            if(list.get(i) != null && this.canEat(lookForOrganism(list.get(i))))
                return list.get(i);
        return null;
    }

@Override
    public void action() {
        if (this.getHunger() > 0) hunger--;
        List<Position> positions = world.getNeighboringPositions(this.position);
        Position newPosition;
        Random rand = new Random();
        Organism orgOnNewPosition;

        if (this.getHunger() < 30 && (newPosition = this.lookForFood(positions)) != null) {
            orgOnNewPosition = lookForOrganism(newPosition);
            world.delOrganism(orgOnNewPosition);
            this.feeded();
            this.moveOn(newPosition);
            return;
        }

        while (positions != null && positions.size() > 0) {
            if (positions.size() > 1)
                newPosition = positions.get(rand.nextInt(positions.size()));
            else
                newPosition = positions.get(0);

            if (world.getMap().isFree(newPosition)) {
                if(this.ifReproduce())
                    this.reproduce(newPosition);
                else
                    moveOn(newPosition);
                break;
            }
            positions.remove(newPosition);
        }
    }

    public boolean canEat(Organism org){
        if (org != null)
            for (int i=0; i < this.feed.size(); i++)
                if (org.species == this.feed.get(i))
                    return true;
        return false;
    }

    public int getHunger(){
        return this.hunger;
    }
}