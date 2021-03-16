import threadsFotogramas.*;
import threadsSonido.*;

public class MuybridgeRaceSonora {

    public static void main(String[] args) {
        tMovie movie = new tMovie();
        tAudio audio = new tAudio();
        Thread threadMovie = new Thread(movie);
        Thread threadAudio = new Thread(audio);
        threadAudio.run();
        threadMovie.run();
    }
}
