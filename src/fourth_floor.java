import java.util.*;

public class fourth_floor extends Thread{

    Random random = new Random();

    public static LinkedList<Integer> fourth_floor_queue = new LinkedList<>();
    public static int fourth_queue, floor2, listlift, q;

    screen s;

    public fourth_floor(Integer floor2, Integer listlift){
        fourth_floor.floor2 = floor2;
        fourth_floor.listlift = listlift;

        if(listlift != 0)
            fourth_floor_queue.add(listlift);
        try{
            fourth_queue = fourth_floor_queue.stream().mapToInt(Integer::intValue).sum();
        }catch (ConcurrentModificationException ignored){

        }
    }

    public fourth_floor(int fourth_queue){
        fourth_floor.fourth_queue = fourth_queue;
    }

    public fourth_floor(screen s) {
        this.s = s;
    }

    public void run(){
        while (true){
            if(!fourth_floor_queue.isEmpty()){
                try{
                    s.fourthfloor_t.setText(String.valueOf(fourth_floor_queue));
                    //System.out.println(fourth_queue + "   " + fourth_floor_queue + " 4.Floor");
                }catch (ConcurrentModificationException | NullPointerException | NoSuchElementException ignored){

                }
            }

            new AVM_exit_thread(fourth_queue, fourth_floor_queue, 0, 0, 0);
            new Control_thread(fourth_queue, 0, 0, 0);

            try {
                s.total5.setText(String.valueOf(fourth_floor_queue.stream().mapToInt(Integer::intValue).sum()));

            }catch (ConcurrentModificationException | NullPointerException  ignored){

            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}