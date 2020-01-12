import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    private int round;
    private int sizeX;
    private int sizeY;
    private List<Organism> organisms;
//    private Organism map[][];
    private Map map;

    World(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
        this.organisms = new ArrayList<>();
        this.map = new Map(sizeX, sizeY);//new Organism[x][y];
        this.round=0;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public List<Organism> getOrganisms(){
        return this.organisms;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    };

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void makeTurn() {
        printWold();
        List<Organism> tempList = new ArrayList<Organism>(organisms);
        for (Organism org:tempList){
            if (this.positionOnBoard(org.position) && !org.ifIsDead())
                org.makeMove();
        }
//        int i = 0;
//        while (true){
//            organisms.get(i).makeMove();
//            if (i == organisms.len)
//        }
        round++;
    }

    public List<Position> getNeighboringPositions(Position self){
        List<Position> positions = new ArrayList<>();
        Position tempPostion;
        for (int y = -1; y < 2; y++){
            for (int x = -1; x < 2; x++){
                tempPostion = new Position(self.getX() + x, self.getY() +y);
                if (positionOnBoard(tempPostion))
                    positions.add(tempPostion);
            }
        }
        return positions;
    }

    public boolean positionOnBoard(Position position){
        if (position.getX() >= map.getSizeX() || position.getY() >= map.getSizeY())
            return false;
        else if (position.getX() >= 0 && position.getY() >=0)
            return true;
        else
            return false;
    }

    public void delOrganism(Organism org){
        organisms.remove(org);
        map.remFromMap(org);
    }

//    public boolean positionFree(Position pos){
//        for (Organism org:organisms) {
//            if (org.position == pos)
//                return false;
//        }
//        return true;
//    }


    public Position getFreeNeighboringPosition(Position pos){
        List<Position> neighboringPosition = getNeighboringPositions(pos);
        for (Position position:neighboringPosition){
            if(map.isFree(position))
                return position;
        }
        return null;
    }

    public void addOrganism(Organism org){
        organisms.add(org);
        this.map.addToMap(org);
    }

    public void addObject(Class org){
        Random rand = new Random();
        int tempX, tempY;
        while(true){
            tempX = rand.nextInt(map.getSizeX());
            tempY = rand.nextInt(map.getSizeY());
            if(map.isFree(new Position(tempX, tempY)))
                break;
        }
//        Object newObject = org.newInstance();
//        addOrganism(org.newInstance()this, tempX, tempY));
    }


    public void printWold(){
        System.out.flush();
        System.out.println("\t\t\tTo jest życie... runda " + round);
        map.printMap();
    }

    public Map getMap() {
        return map;
    }
}
