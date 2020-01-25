public class Grass extends Plant {
    public Grass(World world, Position pos){
        super(world, pos, 0, 'G', 60, 2);
    }

    Grass(World world, int x, int y){
        super(world, new Position(x, y),  0, 'G', 60, 2);
    }

    @Override
    public void reproduce(Position pos){
        this.power /= 2;
        world.addOrganism(new Grass(world, pos));
    }
}
