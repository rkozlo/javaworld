import java.util.Set;

public class Wolf extends Animal {
    private static Set<Character> feed;
    Wolf (World world, Position pos){
//        super(world, pos);
        this.power = 8;
        this.initiative = 5;
        this.species = 'W';
        this.liveLength = 40;
    }
    static{
        feed.add('S');
    }
    public boolean specialAction(Position pos){
        return true;
    }
//    @Override
//    public void individualAction(){}
//    public void hunt(){
//    }
//
    public void feeded(){

    }
}
