/**
 * The ClockApp program in Java creates a GUI application that displays the current time and date, 
 * updating every second. It uses a JLabel to show the formatted date and time, and two separate 
 * threads to handle the updating of the display and the printing of the time to the console.
 * 
 * The main components and functionalities include:
 * 1. ClockApp Class: Extends JFrame and implements Runnable to create a window and handle clock updates.
 * 2. timeLabel: JLabel to display the current time and date.
 * 3. running: Boolean flag to control the running state of the clock.
 * 4. updateTime_Date Method: Updates the JLabel with the current time and date.
 * 5. printTime_Date Method: Prints the current time and date to the console.
 * 6. isRunning Method: Checks if the clock is running.
 * 7. dispose Method: Stops the clock and disposes of the JFrame.
 * 8. ClockApp Constructor: Sets up the GUI, including the initial time update.
 * 9. Main Method: Creates and starts two threads - one for updating the clock display and another for printing the time to the console.
 * 10. PrintTimeTask Class: Implements Runnable to handle the printing of the time to the console in a separate thread.
 */


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockApp extends JFrame implements Runnable {
    private JLabel timeLabel;
    private boolean running = true;

    @Override
    public void run() {
        while (running) {
	    // Ensure the UI update happens on the EDT (Event Dispatch Thread)
            SwingUtilities.invokeLater(this::updateTime_Date);
            try {
                Thread.sleep(1000); // Update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateTime_Date() {
        // Update the current time and date
        SimpleDateFormat timeDate = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        String currentTime_Date = timeDate.format(new Date());
        timeLabel.setText(currentTime_Date);
    }

    public void printTime_Date() {
        // Print the current time and date to the console
        SimpleDateFormat timeDate = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        String currentTime_Date = timeDate.format(new Date());
        System.out.println("Current time and date: " + currentTime_Date);
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void dispose() {
        running = false;
        super.dispose();
    }

    public ClockApp() {
        super("Clock App");
        setLayout(new FlowLayout());
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        add(timeLabel);

        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Force the initial time update on the EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            updateTime_Date();
            // Force a repaint of the frame on the EDT
            repaint();
        });
    }

    public static void main(String[] args) {
        ClockApp clockApp = new ClockApp();
        
        // Thread for updating the clock display
        Thread clockUpdateThread = new Thread(clockApp, "ClockUpdateThread");
        clockUpdateThread.setPriority(Thread.MAX_PRIORITY); // Higher priority for display thread
        clockUpdateThread.start();
        
        // Thread for printing time to the console
        Thread consolePrintThread = new Thread(new PrintTimeTask(clockApp), "ConsolePrintThread");
        consolePrintThread.setPriority(Thread.MIN_PRIORITY); // Lower priority for print thread
        consolePrintThread.start();
    }
}

class PrintTimeTask implements Runnable {
    private final ClockApp clockApp;

    public PrintTimeTask(ClockApp clockApp) {
        this.clockApp = clockApp;
    }

    @Override
    public void run() {
        while (clockApp.isRunning()) {
            clockApp.printTime_Date();
            try {
                Thread.sleep(1000); // Print every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
