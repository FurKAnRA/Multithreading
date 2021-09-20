import java.util.*;

public class second_lift_thread extends Thread{

    public static LinkedList<Integer> listlift = new LinkedList<>();
    public static LinkedList <Integer> floor2 = new LinkedList<>();
    public static int temp, lift2_floor, temp2, floor3;

    screen s;

    public second_lift_thread(LinkedList<Integer> listlift, int temp, LinkedList<Integer> floor2){
        second_lift_thread.listlift = listlift;
        second_lift_thread.temp = temp;
        second_lift_thread.floor2 = floor2;
    }

    public second_lift_thread(screen s){
        this.s = s;
    }

    public void run() {
        while (true)
        {
            synchronized (floor2) {
                //System.out.println("Second Lift Carrying" + listlift + " People " + floor2 + ".floor");
                if (!listlift.isEmpty()) {
                    s.secondelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                    s.mode_2.setText("Active");
                }

                try {
                    floor3 = Collections.max(floor2);
                } catch (NoSuchElementException | ConcurrentModificationException ignored) {

                }

                if (lift2_floor == floor3 && temp2 != 5 && temp > 0) {
                    s.second_lift_floor.setText(String.valueOf(temp2));
                    s.second_direction.setText("Down");
                } else {
                    s.second_lift_floor.setText(String.valueOf(lift2_floor));
                    s.second_direction.setText("Up");
                }

                temp = 0;

                try {
                    if (floor2.contains(1) && lift2_floor == 1) {
                        for (int i = 0; i < floor2.size(); i++) {
                            if (floor2.get(i) == 1) {
                                new first_floor(floor2.get(i), listlift.get(i));
                                floor2.remove(i);
                                listlift.remove(i);
                                s.secondelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                            }
                        }
                    }

                    if (floor2.contains(2) && lift2_floor == 2) {
                        for (int i = 0; i < floor2.size(); i++) {
                            if (floor2.get(i) == 2) {
                                new second_floor(floor2.get(i), listlift.get(i));
                                floor2.remove(i);
                                listlift.remove(i);
                                s.secondelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                            }
                        }
                    }

                    if (floor2.contains(3) && lift2_floor == 3) {
                        for (int i = 0; i < floor2.size(); i++) {
                            if (floor2.get(i) == 3) {
                                new third_floor(floor2.get(i), listlift.get(i));
                                floor2.remove(i);
                                listlift.remove(i);
                                s.secondelevator_t.setText(listlift + " Person  " + String.valueOf(floor2) + ".floor");
                            }
                        }
                    }

                    if (floor2.contains(4) && lift2_floor == 4) {
                        for (int i = 0; i < floor2.size(); i++) {
                            if (floor2.get(i) == 4) {
                                new fourth_floor(floor2.get(i), listlift.get(i));
                                floor2.remove(i);
                                listlift.remove(i);
                                s.secondelevator_t.setText(listlift + " Person  " + floor2 + ".floor");
                            }
                        }
                    }

                } catch (NullPointerException | IndexOutOfBoundsException | ConcurrentModificationException ignored) {

                }

                if (lift2_floor < floor3) {
                    lift2_floor++;
                    if (lift2_floor == floor3)
                        temp2 = lift2_floor;
                } else {
                    temp2--;
                    if (temp2 == 0) {
                        lift2_floor = 0;
                        temp2 = 5;
                        floor3 = 0;
                    }
                }

                if (lift2_floor == 0 && listlift.isEmpty() && temp == 0) {
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