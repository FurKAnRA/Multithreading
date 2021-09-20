import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class third_floor extends Thread{

    public static LinkedList<Integer> third_floor_queue = new LinkedList<>();
    public static int third_queue, floor2, listlift;

    screen s;

    public third_floor(Integer floor2, Integer listlift){
        third_floor.floor2 = floor2;
        third_floor.listlift = listlift;

        if(listlift != 0)
            third_floor_queue.add(listlift);
        try{
            third_queue = third_floor_queue.stream().mapToInt(Integer::intValue).sum();
        }catch (ConcurrentModificationException ignored){

        }
    }

    public third_floor(int third_queue){
        third_floor.third_queue = third_queue;
    }

    public third_floor(screen s) {
        this.s = s;
    }

    public void run(){
        while (true){
            if(!third_floor_queue.isEmpty()){
                try{
                    s.thirdfloor_t.setText(String.valueOf(third_floor_queue));
                    //System.out.println(third_queue + "   " + third_floor_queue + " 3.Floor");
                }catch (ConcurrentModificationException | NullPointerException | NoSuchElementException ignored){

                }
            }

            new AVM_exit_thread(third_queue, third_floor_queue, 0, 0);
            new Control_thread(third_queue, 0, 0);

            try{
                s.total4.setText(String.valueOf(third_floor_queue.stream().mapToInt(Integer::intValue).sum()));
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