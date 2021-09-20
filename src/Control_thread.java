import java.util.ArrayList;
import java.util.LinkedList;

public class Control_thread extends Thread{

    public static LinkedList<Integer> listlift = new LinkedList<>(); // for elevators
    public static LinkedList <Integer> floor2 = new LinkedList<>(); // for elevators

    public static int temp, control_sum, first_queue, second_queue, third_queue, fourth_queue, a, b, c, d;

    screen s;

    public Control_thread(int control_sum, LinkedList <Integer> listlift, LinkedList<Integer>floor2, int temp, int d){
        Control_thread.control_sum = control_sum;
        Control_thread.listlift = listlift;
        Control_thread.floor2 = floor2;
        Control_thread.temp = temp;
        Control_thread.d = d;
    }

    public Control_thread(int first_queue) {
        Control_thread.first_queue = first_queue;
    }

    public Control_thread(int second_queue, int a) {
        Control_thread.second_queue = second_queue;
        Control_thread.a = a;
    }

    public Control_thread(int third_queue, int a, int b) {
        Control_thread.third_queue = third_queue;
        Control_thread.a = a;
        Control_thread.b = b;
    }

    public Control_thread(int fourth_queue, int a, int b, int c) {
        Control_thread.fourth_queue = fourth_queue;
        Control_thread.a = a;
        Control_thread.b = b;
        Control_thread.c = c;
    }

    public Control_thread(screen s) {
        this.s = s;
    }

    public void run() {
        second_lift_thread second_lift = new second_lift_thread(s);
        third_lift_thread third_lift = new third_lift_thread(s);
        fourth_lift_thread fourth_lift = new fourth_lift_thread(s);
        fifth_lift_thread fifth_lift = new fifth_lift_thread(s);
        while(true){
            synchronized (listlift){

                if(control_sum > 20 || (first_queue + second_queue + third_queue + fourth_queue) > 20){
                    try{
                        second_lift.start();
                    }catch (IllegalThreadStateException ignored){

                    }
                    s.mode_2.setText("Active");
                }

                if(control_sum > 40 || (first_queue + second_queue + third_queue + fourth_queue) > 40){
                    try{
                        third_lift.start();
                    }catch (IllegalThreadStateException ignored){

                    }
                    s.mode_3.setText("Active");
                }

                if(control_sum > 60 || (first_queue + second_queue + third_queue + fourth_queue) > 60){
                    try{
                        fourth_lift.start();
                    }catch (IllegalThreadStateException ignored){

                    }
                    s.mode_4.setText("Active");
                }

                if(control_sum > 80 || (first_queue + second_queue + third_queue + fourth_queue) > 80){
                    try {
                        fifth_lift.start();
                    }catch (IllegalThreadStateException ignored){

                    }
                    s.mode_5.setText("Active");
                }
            }

            if((first_queue + second_queue + third_queue + fourth_queue) < 20){
                s.mode_2.setText("Passive");
                s.secondelevator_t.setText(" ");

                s.mode_3.setText("Passive");
                s.thirdelevator_t.setText(" ");

                s.mode_4.setText("Passive");
                s.fourthelevator_t.setText(" ");

                s.mode_5.setText("Passive");
                s.fifthelevator_t.setText(" ");
            }

            else if((first_queue + second_queue + third_queue + fourth_queue) < 40){
                s.mode_3.setText("Passive");
                s.thirdelevator_t.setText(" ");

                s.mode_4.setText("Passive");
                s.fourthelevator_t.setText(" ");

                s.mode_5.setText("Passive");
                s.fifthelevator_t.setText(" ");
            }

            else if((first_queue + second_queue + third_queue + fourth_queue) < 60){
                s.mode_4.setText("Passive");
                s.fourthelevator_t.setText(" ");

                s.mode_5.setText("Passive");
                s.fifthelevator_t.setText(" ");
            }

            else if((first_queue + second_queue + third_queue + fourth_queue) < 80){
                s.mode_5.setText("Passive");
                s.fifthelevator_t.setText(" ");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}