import java.util.LinkedList;
import java.util.Random;

public class  AVM_login_thread extends Thread{

    Random random = new Random();

    public static LinkedList <Integer> list = new LinkedList<>(); // 0.floor queue
    public static LinkedList <Integer> listlift = new LinkedList<>(); // for elevators
    public static LinkedList <Integer> floor = new LinkedList<>();  // for 0.floor
    public static LinkedList <Integer> floor2 = new LinkedList<>(); // for elevators

    public static int temp, control_sum, a, Entrance, total_floor0;

    screen s;

    public AVM_login_thread(int temp) {
        AVM_login_thread.temp = temp;
    }

    public AVM_login_thread(screen s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true){
            login();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void login(){
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(4) + 1;

        Entrance += a;

        floor.add(b);
        list.add(a);
        //System.out.println("0.floor = " + list + " ");
        s.floor0_t.setText(String.valueOf(list));
        s.Target_floor.setText(String.valueOf(floor));
        control_sum += list.getFirst();

        control_sum = list.stream().mapToInt(Integer::intValue).sum();
        s.total1.setText(String.valueOf(control_sum));

        new first_lift_thread(listlift, temp, floor2);
        if((temp + list.getFirst()) <= 10){
            temp += list.getFirst();
            listlift.add(list.getFirst());
            control_sum -= temp;
            floor2.add(b);
            list.removeFirst();
            floor.removeFirst();
        }

        new Control_thread(control_sum, listlift, floor2, temp, 0);
        new second_lift_thread(listlift, temp, floor2);
        new third_lift_thread(listlift, temp, floor2);
        new fourth_lift_thread(listlift, temp, floor2);
        new fifth_lift_thread(listlift, temp, floor2);

        s.Entrance_Count.setText(String.valueOf(Entrance));
    }
}
