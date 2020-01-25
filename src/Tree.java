public class Tree extends Plant{
    public Tree(World world, Position pos){
        super(world, pos, 0, 'T', 200, 160);
    }

    @Override
    public void reproduce(Position newPosition) {
        this.power /= 2;
        world.addOrganism(new Tree(world, newPosition));
    }
}
