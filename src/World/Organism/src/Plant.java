public abstract class Plant extends Organism {
    public Plant(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        super(world, pos, initiative, species, liveLength, powerToReproduce);
    }
    public abstract void reproduce(Position newPosition);

    public void action(){
        Position newPosition;
        if (this.ifReproduce()){
            newPosition = world.getFreeNeighboringPosition(this.position);
            if(newPosition != null && newPosition.getX() != -1) {
                this.power /= 2;
                reproduce(newPosition);
                System.out.println(this.species + " rozprzestrzenia się");
            }
        }

    }

}
