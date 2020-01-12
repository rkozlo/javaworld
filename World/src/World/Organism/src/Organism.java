import java.util.List;

public abstract class Organism{
    protected int power=0;
    protected int initiative;
    protected Position position;
    protected int age;
    protected boolean move;
    protected World world;
    protected char species;
    protected int powerToReproduce;
    protected int liveLength;

    public Organism(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        this.world = world;
        this.position = new Position(pos.getX(), pos.getY());
        this.age = 0;
        this.move = false;
        this.initiative = initiative;
        this.species = species;
        this.liveLength = liveLength;
        this.powerToReproduce = powerToReproduce;
        world.addOrganism(this);
    }

//    Organism(World world, int x, int y){
//        this.world = world;
//        this.position.setX(x);
//        this.position.setY(y);
//    }
    Organism(){ }
//    public abstract void individualAction();

//    public abstract void move();

    public char getSpecies(){
        return this.species;
    }

    public void setWorld(World world){
        this.world= world;
    }
    public abstract void action();

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean ifReproduce(){
        boolean result = false;

        if (this.power >= this.powerToReproduce)
            result = true;
        return result;
    }

    public void makeMove(){
        if (this.age >= liveLength){
            world.delOrganism(this);
            return;
        }
        action();
        this.position.toString();

        age++;
        power++;
    }

    public Organism lookForOrganism(Position pos){
        for (Organism org:world.getOrganisms()){
            if (org.position.equals(pos))
                return org;
        }
        return null;
    }


//    public void getNeighboringPosition(){
//        return this.world.getNeighboringPositions(this.position);
//    }
}
