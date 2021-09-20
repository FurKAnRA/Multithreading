import javax.swing.*;

public class Multithreading {
    public static void main(String[] args) {

        screen s = new screen();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                s.setVisible(true);
                s.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });

        AVM_login_thread login = new AVM_login_thread(s);
        AVM_exit_thread exit = new AVM_exit_thread(s);

        first_lift_thread first_lift = new first_lift_thread(s);

        Control_thread control = new Control_thread(s);

        first_floor first_floor = new first_floor(s);
        second_floor second_floor = new second_floor(s);
        third_floor third_floor = new third_floor(s);
        fourth_floor fourth_floor = new fourth_floor(s);

        login.start();
        exit.start();

        first_lift.start();

        control.start();

        first_floor.start();
        second_floor.start();
        third_floor.start();
        fourth_floor.start();
    }
}
