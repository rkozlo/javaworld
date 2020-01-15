public abstract class Organism{
    protected int power;
    protected int initiative;
    protected Position position;
    protected int age;
    protected boolean move;
    protected World world;
    protected char species;
    protected int powerToReproduce;
    protected int liveLength;
    protected boolean isDead;

    public Organism(World world, Position pos, int initiative, char species, int liveLength, int powerToReproduce){
        this.world = world;
        this.position = new Position(pos.getX(), pos.getY());
        this.age = 0;
        this.move = true;
        this.initiative = initiative;
        this.species = species;
        this.liveLength = liveLength;
        this.powerToReproduce = powerToReproduce;
        world.addOrganism(this);
        this.isDead = false;
    }

//    Organism(World world, int x, int y){
//        this.world = world;
//        this.position.setX(x);
//        this.position.setY(y);
//    }
//    public abstract void individualAction();

//    public abstract void move();

    public char getSpecies(){
        return this.species;
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
        if (this.power >= this.powerToReproduce)
            return true;
        else
            return false;
    }

    public boolean ifIsDead(){
        return isDead;
    }

    public void makeMove(){
        if (this.age >= liveLength){
            System.out.println(this.species + " umiera ze staroścu");
            world.delOrganism(this);
            return;
        }
        if (this.move) return;
        action();
        this.position.toString();

//        System.out.printf("%d , %d, %s\n", this.position.getX(), this.position.getY(), this.toString());
        this.move = true;
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

    public void killOrganism(){
        world.delOrganism(this);
        this.isDead = true;
    }


}
