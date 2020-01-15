public class Wolf extends Animal {
    Wolf (World world, int x, int y){
        super(world, new Position(x, y), 5, 'W', 40, 8);
//        this.feed = new ArrayList<>();
//        this.feed.add('S');
    }

    public boolean specialAction(Position pos){
        return true;
    }
    public void feeded(){

    }
}
