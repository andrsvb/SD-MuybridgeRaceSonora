package threadsFotogramas;

import javax.swing.*;
import java.awt.*;

public class tMovie implements Runnable {

    @Override
    public void run() {
        // 1. Create a movie with images
        Movie photoSeq = new Movie("./fotograms/Muybridge", 15);


        // 2.Create a frame
        JFrame f = new JFrame();
        f.setBackground(Color.WHITE);

        // 2.Close when the close button is pressed
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Put the photo in the frame
        f.add(photoSeq);

        while (true) {
            // Size the frame
            f.pack();
            f.repaint();
            // Show the frame
            f.setVisible(true);

            try {
                Thread.sleep(150); // how fast it is played?
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            // show the next movement
            photoSeq.nextMovement();
        }
    }
}
