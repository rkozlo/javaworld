public class Sheep extends Animal {

    Sheep(World world, Position pos) {
        super(world, pos, 5, 'S', 20, 8);
    }

    Sheep(World world, int x, int y) {
        super(world, new Position(x, y), 5, 'S', 20, 8);
//        this.feed = new char[]{'G'};
//        this.liveLength = 20;
//        this.power = 4;
//        this.initiative = 5;
//        this.species = 'S';
    }

    public void feeded() {
        this.power++;
        this.hunger += 5;
    }

    public boolean specialAction(Position pos){
        Organism lookedOrganism = lookForOrganism(pos);
        if (lookedOrganism != null && lookedOrganism instanceof Grass){
            System.out.println(this.species + " zjada " + lookedOrganism.species);
            world.delOrganism(lookedOrganism);
            this.feeded();
            this.moveOn(pos);
            return true;
        }
        if (lookedOrganism != null){
            this.moveOn(pos);
            return true;
        }
        return false;
    }
}
