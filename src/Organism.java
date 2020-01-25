public abstract class Organism implements OrganismInterface{
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
        this.isDead = false;
    }

    public char getSpecies(){
        return this.species;
    }

    public int getInitiative() {
        return initiative;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean ifReproduce(){
        int count=0;
        for (Position pos: world.getNeighboringPositions(this.position))
            if( !world.getMap().isFree(pos) && lookForOrganism(pos).getSpecies() == this.getSpecies())
                count++;
        if (this.power >= this.powerToReproduce && count <= 2)
            return true;
        else
            return false;
    }

    public boolean ifIsDead(){
        return isDead;
    }

    public void setIsDead() { this.isDead = true; }

    public void makeMove(){
        if (this.age >= liveLength){
            world.delOrganism(this);
            return;
        }
        if (this.move) return;
        action();
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
}
