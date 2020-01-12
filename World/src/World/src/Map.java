public class Map {
    private int sizeX;
    private int sizeY;
    private Organism[][] map;

    Map(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
        this.map = new Organism[this.sizeX][this.sizeY];
    }

    public void printMap(){
        for (int i = 0; i < sizeX; i++){
            for (int j = 0; j < sizeY; j++){
                if(map[i][j] != null)
                    System.out.printf("%c", map[i][j].getSpecies());
                else
                    System.out.printf("%c", ' ');
            }
            System.out.println();
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public boolean isFree(Position pos){
        if (map[pos.getX()][pos.getX()] == null)
            return true;
        else
            return false;
    }

    public void addToMap(Organism org){
        this.map[org.position.getX()][org.position.getY()] = org;
    }

    public void remFromMap(Organism org){
        this.map[org.position.getX()][org.position.getY()] = null;
    }

    public void moveOnMap(Organism org, Position newPosition){
        this.map[newPosition.getX()][newPosition.getY()] = org;
        this.map[org.position.getX()][org.position.getY()] = null;
    }
}
