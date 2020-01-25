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
    private OrganismFactory factory;

    World(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
        this.organisms = new ArrayList<>();
        this.map = new Map(sizeX, sizeY);
        this.round=0;
        this.factory = new OrganismFactory();
        factory.setThisWorld(this);
    }

    public OrganismFactory getFactory() {
        return factory;
    }

    public List<Organism> getOrganisms(){
        return this.organisms;
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
        map.remFromMap(org);
        organisms.remove(org);
        org.setIsDead();
    }

    public Position getFreeNeighboringPosition(Position pos){
        List<Position> neighboringPosition = getNeighboringPositions(pos);
        Random rand = new Random();
        while(neighboringPosition.size() != 0){
            int draw = rand.nextInt(neighboringPosition.size());
            if(map.isFree(neighboringPosition.get(draw)))
                return neighboringPosition.get(draw);
            else
                neighboringPosition.remove(draw);
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

    public void printWold(){
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
        Position position;
        for(int i=0; i< area/20; i++) {
            position = getRandomPosition();
            factory.getOrganism('G', position);
        }
        for(int i=0; i< area/60; i++) {
            position = getRandomPosition();
            factory.getOrganism('S', position);
        }
        for(int i=0; i< area/90; i++) {
            position = getRandomPosition();
            factory.getOrganism('W', position);
        }
        for(int i=0; i< area/100; i++) {
            position = getRandomPosition();
            factory.getOrganism('T', position);
        }
    }
}
