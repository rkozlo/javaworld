public abstract class Plant extends Organism {
    public Plant(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        super(world, pos, initiative, species, liveLength, powerToReproduce);
    }
    public abstract boolean reproduce(Position newPosition);

    public void action(){
        Position newPosition;
        if (this.ifReproduce()){
            newPosition = world.getFreeNeighboringPosition(this.position);
            if(newPosition != null && newPosition.getX() != -1) {
                int count = 0;
                for(Position pos : world.getNeighboringPositions(this.position))
                    if(lookForOrganism(pos) instanceof Plant)
                        count++;
                if( count <= 2 && reproduce(newPosition));
                    System.out.println();
                this.power /= 2;
            }
        }
//    power++;
    }
}
