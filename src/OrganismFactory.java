public class OrganismFactory {
    private World thisWorld;

    public void getOrganism(char spec, Position pos){
        switch(spec){
            case 'S':{
                thisWorld.addOrganism(new Sheep(thisWorld, pos));
                break;
            }
            case 'G':{
                thisWorld.addOrganism(new Grass(thisWorld, pos));
                break;
            }
            case 'W':{
                thisWorld.addOrganism(new Wolf(thisWorld, pos));
                break;
            }
            case 'T':{
                thisWorld.addOrganism(new Tree(thisWorld, pos));
                break;
            }
        }
    }

    public void setThisWorld(World world){
        thisWorld = world;
    }
}
