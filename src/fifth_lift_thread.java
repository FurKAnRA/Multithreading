import java.util.*;

public class fifth_lift_thread extends Thread{

    public static LinkedList<Integer> listlift = new LinkedList<>();
    public static LinkedList <Integer> floor2 = new LinkedList<>();
    public static int temp, floor3, lift5_floor, temp2;

    screen s;

    public fifth_lift_thread(LinkedList<Integer> listlift, int temp, LinkedList<Integer> floor2){
        fifth_lift_thread.listlift = listlift;
        fifth_lift_thread.temp = temp;
        fifth_lift_thread.floor2 = floor2;
    }

    public fifth_lift_thread(screen s){
        this.s = s;
    }

    public void run() {
        while (true)
        {

            synchronized (floor2){
                //System.out.println("First Lift Carrying" + listlift + " People " + floor2 + ".floor");
                if(!listlift.isEmpty()){
                    s.fifthelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                    s.mode_5.setText("Active");
                }

                try {
                    floor3 = Collections.max(floor2);
                } catch (NoSuchElementException | ConcurrentModificationException ignored) {

                }

                if (lift5_floor == floor3 && temp2 != 5 && temp > 0) {
                    s.fifth_lift_floor.setText(String.valueOf(temp2));
                    s.fifth_direction.setText("Down");
                } else {
                    s.fifth_lift_floor.setText(String.valueOf(lift5_floor));
                    s.fifth_direction.setText("Up");
                }

                temp = 0;

                try {
                    if (floor2.contains(1) && lift5_floor == 1) {
                        for (int i = 0; i < floor2.size(); i++) {
                            if (floor2.get(i) == 1) {
                                new first_floor(floor2.get(i), listlift.get(i));
                                floor2.remove(i);
                                listlift.remove(i);
                                s.fifthelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                            }
                        }
                    }

                    if (floor2.contains(2) && lift5_floor == 2) {
                        for (int i = 0; i < floor2.size(); i++) {
                            if (floor2.get(i) == 2) {
                                new second_floor(floor2.get(i), listlift.get(i));
                                floor2.remove(i);
                                listlift.remove(i);
                                s.fifthelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                            }
                        }
                    }

                    if (floor2.contains(3) && lift5_floor == 3) {
                        for (int i = 0; i < floor2.size(); i++) {
                            if (floor2.get(i) == 3) {
                                new third_floor(floor2.get(i), listlift.get(i));
                                floor2.remove(i);
                                listlift.remove(i);
                                s.fifthelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                            }
                        }
                    }

                    if (floor2.contains(4) && lift5_floor == 4) {
                        for (int i = 0; i < floor2.size(); i++) {
                            if (floor2.get(i) == 4) {
                                new fourth_floor(listlift.get(i));
                                floor2.remove(i);
                                listlift.remove(i);
                                s.fifthelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                            }
                        }
                    }

                } catch (NullPointerException | IndexOutOfBoundsException | ConcurrentModificationException ignored) {

                }

                if (lift5_floor < floor3) {
                    lift5_floor++;
                    if (lift5_floor == floor3)
                        temp2 = lift5_floor;
                } else {
                    temp2--;
                    if (temp2 == 0) {
                        lift5_floor = 0;
                        temp2 = 5;
                        floor3 = 0;
                    }
                }

                if(lift5_floor == 0 && listlift.isEmpty() && temp == 0){
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