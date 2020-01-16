import java.util.List;
import java.util.Random;

public abstract class Animal extends Organism {
    int hunger;
    protected List<Character> feed;

    Animal(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        super(world, pos, initiative, species, liveLength, powerToReproduce);
        this.hunger = 40;
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
        hunger--;
        List<Position> positions = world.getNeighboringPositions(this.position);
        Position newPosition;
        Random rand = new Random();

        while (positions != null && positions.size() > 0) {
            if (positions.size() > 1)
                newPosition = positions.get(rand.nextInt(positions.size()));
            else
                newPosition = positions.get(0);
            Organism orgOnNewPosition = lookForOrganism(newPosition);
            if (world.getMap().isFree(newPosition)) {
                System.out.println(this.species + " przemieszcza się");
                moveOn(newPosition);
                break;
            }
            if (orgOnNewPosition != null) {
                if (canEat(orgOnNewPosition)) {
                    System.out.println(this.species + " zjada " + orgOnNewPosition.species);
                    world.delOrganism(orgOnNewPosition);
                    this.feeded();
                    this.moveOn(newPosition);
                    return;
                }
                System.out.println(this.toString() + " " + orgOnNewPosition.toString());
                if (orgOnNewPosition.getClass() == this.getClass()) {
                    Position tempPosition;
                    if (orgOnNewPosition.getPower() >= powerToReproduce && this.getPower() >= powerToReproduce) {
                        if((tempPosition = world.getFreeNeighboringPosition(this.position)) != null || (tempPosition = world.getFreeNeighboringPosition(orgOnNewPosition.position)) != null) {
                            int draw = rand.nextInt(2);
                            if(draw == 1)
                                world.addOrganism(this.getSpecies(), tempPosition);
                            else
                                return;
                        }
                        else
                            break;
                        System.out.println("Rodzi się nowy " + this.getSpecies());
                        return;
                    }
                }
            }

            positions.remove(newPosition);
        }
    }

    public boolean canEat(Organism org){
        if (org != null){
            for (int i=0; i < this.feed.size(); i++)
                if (org.species == this.feed.get(i))
                    return true;
        }
        return false;
    }
}

