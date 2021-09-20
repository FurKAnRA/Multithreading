import javax.swing.*;

public class screen extends JFrame {
    private JPanel panel1;

    private JLabel first_elevator;
    private JLabel first_floor;
    private JLabel second_floor;
    private JLabel third_floor;
    private JLabel fourth_floor;
    private JLabel second_elevator;
    private JLabel fourth_elevator;
    private JLabel fifth_elevator;

    public JTextField floor0_t;
    public JTextField firstfloor_t;
    public JTextField secondfloor_t;
    public JTextField thirdfloor_t;
    public JTextField fourthfloor_t;

    public JTextField firstelevator_t;
    public JTextField secondelevator_t;
    public JTextField thirdelevator_t;
    public JTextField fourthelevator_t;
    public JTextField fifthelevator_t;

    public JTextField mode_1;
    public JTextField mode_2;
    public JTextField mode_3;
    public JTextField mode_4;
    public JTextField mode_5;

    public JTextField first_lift_floor;
    public JTextField second_lift_floor;
    public JTextField third_lift_floor;
    public JTextField fourth_lift_floor;
    public JTextField fifth_lift_floor;

    public JTextField first_direction;
    public JTextField second_direction;
    public JTextField third_direction;
    public JTextField fourth_direction;
    public JTextField fifth_direction;

    private JLabel Direction;
    private JLabel Floor;

    public JTextField Target_floor;
    public JTextField Exit_Count;

    public JTextField Exitqueue1;
    public JTextField Exitqueue2;
    public JTextField Exitqueue3;
    public JTextField Exitqueue4;

    private JLabel Exit_queue1;
    private JLabel Exit_queue2;
    private JLabel Exit_queue3;
    private JLabel Exit_queue4;

    public JTextField Entrance_Count;

    public JTextField total5;
    public JTextField total4;
    public JTextField total3;
    public JTextField total2;
    public JTextField total1;

    public screen(){
        add(panel1);
        setResizable(false);
        setSize(750,800);

        setLocationRelativeTo(null);
        setTitle("Elevator");
    }
}
