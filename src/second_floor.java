import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class second_floor extends Thread{

    public static LinkedList<Integer> second_floor_queue = new LinkedList<>();
    public static int second_queue, floor2, listlift;

    screen s;

    public second_floor(Integer floor2, Integer listlift){
        second_floor.floor2 = floor2;
        second_floor.listlift = listlift;

        if(listlift != 0)
            second_floor_queue.add(listlift);
        second_queue = second_floor_queue.stream().mapToInt(Integer::intValue).sum();
    }

    public second_floor(int second_queue){
        second_floor.second_queue = second_queue;
    }

    public second_floor(screen s) {
        this.s = s;
    }

    public void run(){
        while (true){
            if(!second_floor_queue.isEmpty()){
                try{
                    s.secondfloor_t.setText(String.valueOf(second_floor_queue));
                    //System.out.println(second_queue + "   " + second_floor_queue + " 2.Floor");
                }catch (ConcurrentModificationException | NullPointerException | NoSuchElementException ignored){

                }
            }

            new AVM_exit_thread(second_queue, second_floor_queue, 0);
            new Control_thread(second_queue, 0);

            try {
                s.total3.setText(String.valueOf(second_floor_queue.stream().mapToInt(Integer::intValue).sum()));
            }catch (ConcurrentModificationException | NullPointerException  ignored){

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
