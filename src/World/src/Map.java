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
        for (int i = 0; i < sizeY; i++){
            if(i==0) System.out.println(line());
            for (int j = 0; j < sizeX; j++){
                if(j == 0) System.out.print("||");
                if(map[j][i] != null)
                    System.out.printf("%c", map[j][i].getSpecies());
                else
                    System.out.printf("%c", ' ');
                if(j == sizeX-1) System.out.print("||");
            }
            System.out.println();
        }
        System.out.println(line());
    }

    private String line(){
        String result = new String();
        result += "\\\\";
        for(int i =0; i< this.sizeX; i++){
            result += "=";
        }
        result += "//";
        return result;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public boolean isFree(Position pos){
        if (map[pos.getX()][pos.getY()] == null)
            return true;
        else
            return false;
    }

    public void addToMap(Organism org){
        this.map[org.position.getX()][org.position.getY()] = org;
    }

    public void remFromMap(Organism org){
        this.map[org.position.getX()][org.position.getY()] = null;
//        System.out.println("USUWAM Z MAPY" + org.toString());
    }

    public void moveOnMap(Organism org, Position newPosition){
        if(org.position.equals(newPosition)) return;
        this.map[newPosition.getX()][newPosition.getY()] = org;
        this.map[org.position.getX()][org.position.getY()] = null;
//        System.out.println(org.toString() + " " + org.position.getX() + " " + org.position.getY() +" nowy " + newPosition.getX() + " " + newPosition.getY());
    }
}
