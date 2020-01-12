public class Grass extends Plant {

    private static int powerToReproduce;
    public Grass(World world, Position pos){
//        super(world, pos, pow, init, spec, );
        super(world, pos, 0, 'G', 30, 4);

    }

    Grass(World world, int x, int y){
        super(world, new Position(x, y),  0, 'G', 30, 6);

    }

    public void individualAction(){}

    public void move(){}

    @Override
    public void reproduce(Position pos){

//        world.addOrganism(new Grass(world, pos));
    }
}
