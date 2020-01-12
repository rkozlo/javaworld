import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Animal extends Organism {
    int hunger;
    private static char feed[];

    Animal(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        super(world, pos, initiative, species, liveLength, powerToReproduce);
        this.hunger = 20;
    }

    Animal(){ }

    public void moveOn(Position newPosition){
        position.setPosition(newPosition);
    }

    public abstract void feeded();

    public abstract boolean specialAction(Position pos);

//    public void moveOn(int direction){
//        switch(direction){
//            case 0:
//                if (this.position.getX() + 1 < world.getSizeX()) {
//                    this.position.incrX();
//                }
//                break;
//            case 1:
//                if (this.position.getX() + 1 < world.getSizeX() && this.position.getX() + 1 < world.getSizeY()) {
//                    this.position.incrX();
//                    this.position.incrY();
//                }
//                break;
//            case 2:
//                if (this.position.getY() + 1 < world.getSizeY()) {
//                    this.position.incrY();
//                }
//                break;
//            case 3:
//                if (this.position.getX() - 1 >= 0 && this.position.getY() + 1 < world.getSizeY()) {
//                    this.position.decrX();
//                    this.position.incrY();
//                }
//                break;
//            case 4:
//                if (this.position.getX() - 1 >= 0) {
//                    this.position.decrX();
//                }
//                break;
//            case 5:
//                if (this.position.getX() - 1 >= 0 && this.position.getY() - 1 >= 0) {
//                    this.position.decrX();
//                    this.position.decrY();
//                }
//                break;
//            case 6:
//                if (this.position.getY() - 1 >= 0) {
//                    this.position.decrY();
//                }
//                break;
//            case 7:
//                if (this.position.getX() + 1 < world.getSizeX() && this.position.getY() - 1 >= 0) {
//                    this.position.incrX();
//                    this.position.decrY();
//                }
//                break;
//        }
//    }
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
//                if (canEat(orgOnNewPosition)) {
//                    System.out.println(this.species + " zjada " + orgOnNewPosition.species);
//                    world.delOrganism(orgOnNewPosition);
//                    this.feeded();
//                    this.moveOn(newPosition);
//                    return;
//                }
                if (world.positionFree(newPosition)) {
                    System.out.println(this.species + " przemieszcza się");
                    moveOn(newPosition);
                    break;
                }
                positions.remove(newPosition);
            }
        }
    }

//    public boolean canEat(Organism org){
//        if (org != null){
//            System.out.println(this.toString());
//            for (int i=0; i < this.length; i++)//for (char sign:this.feed)
//                if (org.species == this.feed[i])
//                    return true;
//        }
//        return false;
//    }
}

