import java.util.*;

public class first_lift_thread extends Thread{

    public static LinkedList<Integer> listlift = new LinkedList<>();
    public static LinkedList <Integer> floor2 = new LinkedList<>();
    public static int temp, floor3, lift1_floor, temp2;

    screen s;

    public first_lift_thread(LinkedList<Integer> listlift, int temp, LinkedList<Integer> floor2){
        first_lift_thread.listlift = listlift;
        first_lift_thread.temp = temp;
        first_lift_thread.floor2 = floor2;
    }

    public first_lift_thread(screen s){
        this.s = s;
    }

    public void run() {
       while (true) {
               //System.out.println("First Lift Carrying" + listlift + " People " + floor2 + ".floor");
           synchronized (floor2) {
               if (!listlift.isEmpty()) {
                   s.firstelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                   s.mode_1.setText("Active");
               }

               try {
                   floor3 = Collections.max(floor2);
               } catch (NoSuchElementException | ConcurrentModificationException ignored) {

               }

               if (lift1_floor == floor3 && temp2 != 5 && temp > 0) {
                   s.first_lift_floor.setText(String.valueOf(temp2));
                   s.first_direction.setText("Down");
               } else {
                   s.first_lift_floor.setText(String.valueOf(lift1_floor));
                   s.first_direction.setText("Up");
               }

               temp = 0;

               try {
                   if (floor2.contains(1) && lift1_floor == 1) {
                       for (int i = 0; i < floor2.size(); i++) {
                           if (floor2.get(i) == 1) {
                               new first_floor(floor2.get(i), listlift.get(i));
                               floor2.remove(i);
                               listlift.remove(i);
                               s.firstelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                           }
                       }
                   }

                   if (floor2.contains(2) && lift1_floor == 2) {
                       for (int i = 0; i < floor2.size(); i++) {
                           if (floor2.get(i) == 2) {
                               new second_floor(floor2.get(i), listlift.get(i));
                               floor2.remove(i);
                               listlift.remove(i);
                               s.firstelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                           }
                       }
                   }

                   if (floor2.contains(3) && lift1_floor == 3) {
                       for (int i = 0; i < floor2.size(); i++) {
                           if (floor2.get(i) == 3) {
                               new third_floor(floor2.get(i), listlift.get(i));
                               floor2.remove(i);
                               listlift.remove(i);
                               s.firstelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                           }
                       }
                   }

                   if (floor2.contains(4) && lift1_floor == 4) {
                       for (int i = 0; i < floor2.size(); i++) {
                           if (floor2.get(i) == 4) {
                               new fourth_floor(floor2.get(i), listlift.get(i));
                               floor2.remove(i);
                               listlift.remove(i);
                               s.firstelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                           }
                       }
                   }

               } catch (NullPointerException | IndexOutOfBoundsException | ConcurrentModificationException ignored) {

               }

               if (lift1_floor < floor3) {
                   lift1_floor++;
                   if (lift1_floor == floor3)
                       temp2 = lift1_floor;
               } else {
                   temp2--;
                   if (temp2 == 0) {
                       lift1_floor = 0;
                       temp2 = 5;
                       floor3 = 0;
                   }
               }

               if (lift1_floor == 0 && listlift.isEmpty() && temp == 0) {
                   new AVM_login_thread(temp);
               }

               try {
                   Thread.sleep(200);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }
}
