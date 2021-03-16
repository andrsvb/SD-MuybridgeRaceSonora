package threadsSonido;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class tAudio implements Runnable {

    @Override
    public void run() {
        try {
            // Se crea el Clip de sonido
            Clip galope = AudioSystem.getClip();

            // Se carga con el fichero wav
            galope.open(AudioSystem.getAudioInputStream(new File("./sounds/galope.wav")));

            // Comienza la reproduccion en bucle
            galope.start();
            galope.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

