import java.io.*;
import javax.sound.sampled.*;

public class Sound {
    Clip clip;

    AudioInputStream audioInputStream;

    public Sound(String soundPath, boolean loop) {
        try {
            // create AudioInputStream object
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundPath).getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    public void playSound() {
        clip.start();
    }
}
