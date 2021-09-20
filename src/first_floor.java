import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class first_floor extends Thread{

    public static LinkedList<Integer> first_floor_queue = new LinkedList<>();
    public static int first_queue, floor2, listlift;

    screen s;

    public first_floor(Integer floor2, Integer listlift){
        first_floor.floor2 = floor2;
        first_floor.listlift = listlift;

        if(listlift != 0)
            first_floor_queue.add(listlift);
        first_queue = first_floor_queue.stream().mapToInt(Integer::intValue).sum();
    }

    public first_floor(int first_queue){
        first_floor.first_queue = first_queue;
    }

    public first_floor(screen s){
        this.s = s;
    }

    public void run(){
        while (true){
            if(!first_floor_queue.isEmpty()){
                try{
                    s.firstfloor_t.setText(String.valueOf(first_floor_queue));
                    //System.out.println(first_queue + "   " + first_floor_queue + " 1.Floor");

                }catch(ConcurrentModificationException | NullPointerException | NoSuchElementException ignored){

                }
            }

            new AVM_exit_thread(first_queue, first_floor_queue);
            new Control_thread(first_queue);

            try {
                s.total2.setText(String.valueOf(first_floor_queue.stream().mapToInt(Integer::intValue).sum()));
            }catch (ConcurrentModificationException | NullPointerException ignored){

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}