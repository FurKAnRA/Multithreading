import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class AVM_exit_thread extends Thread{

    Random random = new Random();

    public static LinkedList<Integer> first_floor_queue;
    public static LinkedList<Integer> second_floor_queue;
    public static LinkedList<Integer> third_floor_queue;
    public static LinkedList<Integer> fourth_floor_queue;
    public static LinkedList<Integer> floor2;
    public static int first_queue, second_queue, third_queue, fourth_queue, Exit_Count;
    public static int x, y, z;

    screen s;

    public AVM_exit_thread(int first_queue, LinkedList<Integer> first_floor_queue){
        AVM_exit_thread.first_queue = first_queue;
        AVM_exit_thread.first_floor_queue = first_floor_queue;
    }

    public AVM_exit_thread(int second_queue, LinkedList<Integer> second_floor_queue, int x){
        AVM_exit_thread.second_queue = second_queue;
        AVM_exit_thread.second_floor_queue = second_floor_queue;
        AVM_exit_thread.x = x;
    }

    public AVM_exit_thread(int third_queue, LinkedList<Integer> third_floor_queue, int x, int y){
        AVM_exit_thread.third_queue = third_queue;
        AVM_exit_thread.third_floor_queue = third_floor_queue;
        AVM_exit_thread.x = x;
        AVM_exit_thread.y = y;
    }

    public AVM_exit_thread(int fourth_queue, LinkedList<Integer> fourth_floor_queue, int x, int y, int z){
        AVM_exit_thread.fourth_queue = fourth_queue;
        AVM_exit_thread.fourth_floor_queue = fourth_floor_queue;
        AVM_exit_thread.x = x;
        AVM_exit_thread.y = y;
        AVM_exit_thread.z = z;
    }

    public AVM_exit_thread(LinkedList<Integer> floor2){
        AVM_exit_thread.floor2 = floor2;
    }

    public AVM_exit_thread(screen s){
        this.s = s;
    }

    @Override
    public void run() {

        while (true){
            int q = random.nextInt(4) + 1;

            if(first_queue > 10 && q == 1){
                int a = random.nextInt(5) + 1, b = 0;
                //System.out.println(first_queue + "   "  + first_floor_queue + " 1.Floor");
                s.Exitqueue1.setText(String.valueOf(a));

                try{
                    b = first_floor_queue.getFirst();
                }catch (NoSuchElementException ignored){

                }

                b -= a;

                try{
                    first_floor_queue.removeFirst();
                }catch (NoSuchElementException ignored){

                }

                if(b > 0)
                    first_floor_queue.addFirst(b);
                else{
                    try{
                        first_floor_queue.removeFirst();
                    }catch (NoSuchElementException ignored){

                    }
                }
                first_queue -= a;
                Exit_Count += a;
                new first_floor(first_queue);
            }

            else if(second_queue > 10 && q == 2){
                int a = random.nextInt(5) + 1, b = 0;
                //System.out.println(second_queue + " " + second_floor_queue + " 2.Floor");
                s.Exitqueue2.setText(String.valueOf(a));

                try{
                    b = second_floor_queue.getFirst();
                }catch (NoSuchElementException ignored){

                }

                b -= a;

                try{
                    second_floor_queue.removeFirst();
                }catch (NoSuchElementException ignored){

                }

                if(b > 0)
                    second_floor_queue.addFirst(b);
                else{
                    try{
                        second_floor_queue.removeFirst();
                    }catch (NoSuchElementException ignored){

                    }
                }
                second_queue -= a;
                Exit_Count += a;
                new second_floor(second_queue);
            }

            else if(third_queue > 10 && q == 3){
                int a = random.nextInt(5) + 1, b = 0;
                //System.out.println(third_queue + "   "  + third_floor_queue + " 3.Floor");
                s.Exitqueue3.setText(String.valueOf(a));

                try{
                    b = third_floor_queue.getFirst();
                }catch (NoSuchElementException ignored){

                }

                b -= a;

                try{
                    third_floor_queue.removeFirst();
                }catch (NoSuchElementException ignored){

                }

                if(b > 0)
                    third_floor_queue.addFirst(b);
                else{
                    try{
                        third_floor_queue.removeFirst();
                    }catch (NoSuchElementException ignored){

                    }
                }
                third_queue -= a;
                Exit_Count += a;
                new third_floor(third_queue);
            }

            else if(fourth_queue > 10 && q == 4){
                int a = random.nextInt(5) + 1, b = 0;
                //System.out.println(fourth_queue + "   "  + fourth_floor_queue + " 4.Floor");
                s.Exitqueue4.setText(String.valueOf(a));

                try{
                    b = fourth_floor_queue.getFirst();
                }catch (NoSuchElementException ignored){

                }
                b -= a;

                try{
                    fourth_floor_queue.removeFirst();
                }catch (NoSuchElementException ignored){

                }

                if(b > 0)
                    fourth_floor_queue.addFirst(b);
                else{
                    try{
                        fourth_floor_queue.removeFirst();
                    }catch (NoSuchElementException ignored){

                    }
                }
                fourth_queue -= a;
                Exit_Count += a;

                new fourth_floor(fourth_queue);
            }

            s.Exit_Count.setText(String.valueOf(Exit_Count));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}