public abstract class Plant extends Organism {
    public Plant(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        super(world, pos, initiative, species, liveLength, powerToReproduce);
    }

    public abstract void reproduce(Position newPosition);
//@Override
//    public void move(){}

//    @Override
//    public void individualAction() {
//
//    }

    public void action(){
        Position newPosition = new Position();
        if (this.ifReproduce()){
            newPosition = world.getFreeNeighboringPosition(this.position);
        }
        if(newPosition != null){
            this.power /= 2;
            reproduce(newPosition);
            System.out.println(this.species + " rozprzestrzenia się");
        }
    }

}
