public class Position {
    private int x;
    private int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    Position(){
        this.x = -1;
        this.y = -1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

//    public void incrX(){ this.x++; }
//
//    public void incrY() { this.y++; }
//
//    public void decrX() { this.x--; }
//
//    public void decrY() { this.y--; }

    public void setPosition(Position pos){
        this.x = pos.getX();
        this.y = pos.getY();
    }

    public boolean equals(Position other){
        return this.x == other.getX() && this.y == other.getY();
    }

    public String toString(){
        return x + " " + y;
    }

}
