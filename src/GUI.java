import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class GUI extends JFrame {

    GUI(){
        // Start fullscreen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1750, 600);
        setTitle("Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        weekCalendar();

        setVisible(true);
    }

    private void weekCalendar() {
        // Create panel allDays which includes 7 panels representing each weekday
        JPanel allDays = new JPanel();
        allDays.setLayout(new BoxLayout(allDays, BoxLayout.X_AXIS));

        // Loop through all days and create a panel for them
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : days) {
            allDays.add(Box.createRigidArea(new Dimension(10, 0)));
            allDays.add(dayPanel(day));
            allDays.add(Box.createRigidArea(new Dimension(10, 0)));
        }

        add(allDays);
    }

    // Create panel dayPanel which contains components used to represent each day
    private JPanel dayPanel(String day) {
        JPanel dayPanel = new JPanel();
        dayPanel.setLayout(new BorderLayout());

        JLabel dayLabel = new JLabel(day);
        JLabel dateLabel = new JLabel(String.valueOf(Week.getDate(day)));

        JTextField newEvent = new JTextField();
        newEvent.setPreferredSize(new Dimension(100, 25));

        JTextArea dayProperties = new JTextArea();
        dayProperties.setPreferredSize(new Dimension(100, 950));
        dayProperties.setLineWrap(true);
        dayProperties.setEditable(false);

        // Button takes text written in newEvent and appends to dayProperties
        JButton dayButton = new JButton("Create");

        JPanel header = new JPanel();
        header.add(dayLabel);
        header.add(dateLabel);
        // Mark today's day
        if (Week.getDate(day).equals(LocalDate.now())){
            header.setBackground(Color.decode("#c1e6cd"));
        }

        JPanel footer = new JPanel();
        footer.add(newEvent);
        footer.add(dayButton);

        dayPanel.add(header, BorderLayout.NORTH);
        dayPanel.add(dayProperties, BorderLayout.CENTER);
        dayPanel.add(footer, BorderLayout.SOUTH);

        dayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dayProperties.append(newEvent.getText() + "\n");
                newEvent.setText("");
            }
        });

        return dayPanel;
    }
}