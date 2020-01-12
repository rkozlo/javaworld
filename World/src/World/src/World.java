import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class World {
    private int round;
    private int key;
    private int sizeX;
    private int sizeY;
    private List<Organism> organisms;
    private Organism map[][];

    World(){}

    World(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
        this.organisms = new ArrayList<>();
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

//    public int getKey() {
//        return key;
//    }

//    public void setKey(int key) {
//        this.key = key;
//    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void makeTurn(){
        List<Organism> tempList = new ArrayList<Organism>(organisms);
        for (Organism org:tempList){
            if (this.positionOnBoard(org.position))
                org.makeMove();
        }
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
        if (position.getX() > sizeX || position.getY() > sizeY)
            return false;
        else if (position.getX() >= 0 && position.getY() >=0)
            return true;
        else
            return false;
    }

    public void delOrganism(Organism org){
        organisms.remove(org);
    }

    public boolean positionFree(Position pos){
        for (Organism org:organisms) {
            if (org.position == pos)
                return false;
        }
        return true;
    }

    public Position getFreeNeighboringPosition(Position pos){
        List<Position> neighboringPosition = getNeighboringPositions(pos);
        for (Position position:neighboringPosition){
            if(positionFree(position))
                return position;
        }
        return null;
    }

    public void addOrganism(Organism org){
        organisms.add(org);
    }

}
