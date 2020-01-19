import java.util.List;
import java.util.Random;

public abstract class Animal extends Organism {
    int hunger;
    protected List<Character> feed;

    Animal(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        super(world, pos, initiative, species, liveLength, powerToReproduce);
        this.hunger = 60;
    }

    public void moveOn(Position newPosition){
        world.getMap().moveOnMap(this, newPosition);
        position.setPosition(newPosition);
    }

    public abstract void feeded();

    public abstract boolean specialAction(Position pos);

    public abstract boolean reproduce(Position position);

    private Position lookForFood(List<Position> list){
        for(int i=0; i<list.size(); i++)
            if(list.get(i) != null && this.canEat(lookForOrganism(list.get(i))))
                return list.get(i);
        return null;
    }

@Override
    public void action() {
        if (this.hunger <= 0) {
            world.delOrganism(this);
            return;
        }
//        hunger--;
        List<Position> positions = world.getNeighboringPositions(this.position);
        Position newPosition = this.lookForFood(positions);
        Random rand = new Random();
        Organism orgOnNewPosition;
        if (newPosition != null) {
        //                    System.out.println(this.species + " zjada " + orgOnNewPosition.species);
            orgOnNewPosition = lookForOrganism(newPosition);
            world.delOrganism(orgOnNewPosition);
            this.feeded();
            this.moveOn(newPosition);
            return;
        }
        while (positions != null && positions.size() > 0) {
            if (newPosition == null && positions.size() > 1)
                newPosition = positions.get(rand.nextInt(positions.size()));
            else
                newPosition = positions.get(0);
            orgOnNewPosition = lookForOrganism(newPosition);
            if (world.getMap().isFree(newPosition)) {
//                System.out.println(this.species + " przemieszcza się");
                if(this.ifReproduce())
                    this.reproduce(newPosition);
                else
                    moveOn(newPosition);
                break;
            }
//            if (orgOnNewPosition != null) {
//                if (orgOnNewPosition.getClass() == this.getClass()) {
//                    Position tempPosition;
//                    if (orgOnNewPosition.getPower() >= powerToReproduce && this.getPower() >= powerToReproduce) {
//                        if((tempPosition = world.getFreeNeighboringPosition(this.position)) != null || (tempPosition = world.getFreeNeighboringPosition(orgOnNewPosition.position)) != null) {
//                            this.setPower(this.getPower()/2);
//                            orgOnNewPosition.setPower(orgOnNewPosition.getPower()/2);
//                            if(!this.reproduce(tempPosition))
//                                return;
//                        }
//                        else
//                            break;
////                        System.out.println("Rodzi się nowy " + this.getSpecies());
//                        return;
//                    }
//                }
//            }

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

