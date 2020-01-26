public abstract class Plant extends Organism {
    public Plant(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        super(world, pos, initiative, species, liveLength, powerToReproduce);
    }

    public void action(){
        Position newPosition;
        if (this.ifReproduce()){
            newPosition = world.getFreeNeighboringPosition(this.position);
            if(newPosition != null)
                reproduce(newPosition);
        }
    }
}
