package audio;

import audio.wavfile.WavFileException;
import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;

import java.io.IOException;

public class ModificarDeAudio {

    AudioFileRecord audioFileRecord;
    public ModificarDeAudio() throws IOException, WavFileException {
        audioFileRecord = new AudioFileRecord("src/audio/audio.wav");
        subirVolumenAudio();
//        SalidaPorDefecto.terminal( "Se ha subido el audio por 1\n");
//        SalidaPorDefecto.terminal( "Presiona enter para continuar: ");
//        EntradaPorDefecto.consolaCadenas();
//        acelerarAudio();
//        SalidaPorDefecto.terminal( "Se ha acelerado el audio    ");

//        relentizarAudio();

//        eliminarSilencio();
        invertirAudio();
    }

    private void subirVolumenAudio() throws IOException, WavFileException {
        double cantidad = 0.7;
        audioFileRecord.subirVolumen(cantidad);
    }

    private void bajarVolumen() throws IOException, WavFileException {
        double cantidad = 1.0;
        audioFileRecord.bajarVolumen(cantidad);
    }

    private void acelerarAudio() {
        audioFileRecord.acelararAudio(3);
    }
    private void relentizarAudio() {
        audioFileRecord.relentizarAudio(2);
    }

    private void eliminarSilencio() {
        audioFileRecord.eliminarSilencios();
    }

    private void invertirAudio() {
        audioFileRecord.invertirAudio();
    }
}
