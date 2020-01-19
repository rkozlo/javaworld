import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class World {
    private int round;
    private int sizeX;
    private int sizeY;
    private List<Organism> organisms;
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

    public void makeTurn(){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        while (count > 0) {
            this.sortByInitiative();
            for (Organism org : organisms)
                org.setMove(false);

            List<Organism> tempList = new ArrayList<Organism>(organisms);
            for (Organism org : tempList) {
                if (this.positionOnBoard(org.position) && !org.ifIsDead() && !org.isMove())
                    org.makeMove();
            }
            printWold();
            round++;
            count--;
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
        org.setIsDead();
    }
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

    public Position getRandomPosition(){
        Random rand = new Random();
        int tempX, tempY;
        while(true){
            tempX = rand.nextInt(map.getSizeX());
            tempY = rand.nextInt(map.getSizeY());
            if(map.isFree(new Position(tempX, tempY)))
                return new Position(tempX, tempY);
        }
    }

    public void addRandomOrganism(char spec){
        Position position = getRandomPosition();
        switch(spec){
            case 'S':{
                addOrganism(new Sheep(this, position));
                break;
            }
            case 'G':{
                addOrganism(new Grass(this, position));
                break;
            }
            case 'W':{
                addOrganism(new Wolf(this, position));
                break;
            }
            case 'T':{
                addOrganism(new Tree(this, position));
                break;
            }
        }
    }

    public void addOrganism(char spec, Position position){
        switch(spec){
            case 'S':{
                addOrganism(new Sheep(this, position));
                break;
            }
            case 'G':{
                addOrganism(new Grass(this, position));
                break;
            }
            case 'W':{
                addOrganism(new Wolf(this, position));
                break;
            }
            case 'T':{
                addOrganism(new Tree(this, position));
                break;
            }
        }
    }


    public void printWold(){
//        System.out.flush();
        System.out.println("\t\t\tEhh... To jest życie... runda " + round);
        map.printMap();
    }

    public Map getMap() {
        return map;
    }

    public void sortByInitiative(){
        for(int i=0; i<organisms.size(); i++){
            int j=i;
            while(j > 0 && j < organisms.size() && organisms.get(j-1).getInitiative() < organisms.get(j).getInitiative()){
                Organism tempOrg = organisms.get(j-1);
                organisms.set(j-1, organisms.get(j));
                organisms.set(j, tempOrg);
                j--;
            }
        }
    }

    public void fillTheWorld(){
        int area = sizeX * sizeY;
        for(int i=0; i< area/8; i++)
            addRandomOrganism('G');
        for(int i=0; i< area/15; i++)
            addRandomOrganism('S');
        for(int i=0; i< area/80; i++)
            addRandomOrganism('W');
        for(int i=0; i< area/100; i++)
            addRandomOrganism('T');
    }
}
