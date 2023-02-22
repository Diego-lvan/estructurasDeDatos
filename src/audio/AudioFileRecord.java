package audio;

import java.io.*;

import audio.wavfile.*;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;

public class AudioFileRecord {
    private long numFrames;  //numero de tramas, número de muestras totales del archivo por canal
    private long sampleRate; //numero de muestras por segundo a la que se discretiza la señal
    private int numChannels; //número de canales
    private double[] buffer; //audio original
    private double[] buffer2; //audio modificado
    private String archivo;   //nombre de archivo dado por el usuario
    private WavFile wavFileR; //apuntador de archivo leido
    private WavFile wavFileW;  //apuntador de archivo a escribir
    private String nomArchivo; //nombre archivo (uno.wav)
    private String nomRuta;    //ruta donde esta guardado el archivo (/home)
    private int validBits;     //bits usados para la discretización

    private final double VALOR_SILENCIO = -0.09;


    private ListaEstaticaNumerica bufferTmp;

    public AudioFileRecord(String archivo) {
        this.archivo = archivo;
        // Abre el archivo wav y asigna parámetros a las variables
        try {
            File file = new File(archivo);
            wavFileR = WavFile.openWavFile(file);
            nomArchivo = file.getName();
            nomRuta = file.getParent();
        } catch (Exception e) {

        }
        numChannels = wavFileR.getNumChannels();
        numFrames = wavFileR.getNumFrames();
        sampleRate = wavFileR.getSampleRate();
        validBits=wavFileR.getValidBits();
        bufferTmp = new ListaEstaticaNumerica((int)numFrames);

    }

    public void leerAudio() {

        try {

            // Muestra datos del archivo
            wavFileR.display();

            // Crea buffer de origen y de temporal
            buffer = new double[(int) numFrames * numChannels];
            buffer2 = new double[buffer.length];

            //tramas leidas
            int framesRead;

            // Lee tramas totales
            framesRead = wavFileR.readFrames(buffer, (int) numFrames);

            // Recorrer todas las tramas del archivo y guardarlas en el arreglo.
            for (int s = 0; s < framesRead * numChannels; s++) {
                buffer2[s] = buffer[s];
            }

            // Cierra archivo
            wavFileR.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void EscribirAudio() {
        try {

            //Crear el apuntador al archivo para guardar datos del temporal
            File file = new File(nomRuta + "/2_" + nomArchivo);

            // Creamos un nuevo archivo de audio con los mismos datos que el original
            wavFileW = WavFile.newWavFile(file, numChannels, numFrames, validBits, sampleRate);

            // Escribimos los frames o muestras totales del temporal
            wavFileW.writeFrames(buffer2, (int) numFrames);

            // Cerramos el archivo
            wavFileW.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public double[] getBuffer2() {
        return buffer2;
    }

    public void setBuffer2(double[] buffer2) {
        this.buffer2 = buffer2;
    }

    public void preEnfasis() {
        leerAudio();
        // puede que no funcione
        bufferTmp.agregarBuffer(ListaEstatica.doubleArrayToObject(buffer2));
        for(int idx = 1; idx < bufferTmp.cantidad(); idx++) {
            bufferTmp.cambiar(idx, formulaFir((Double) bufferTmp.obtener(idx), (Double) bufferTmp.obtener(idx - 1)));
        }
        // write frame
    }

    private double formulaFir(double valActual, double valAnterior) {
        double alpha = 0.97;
        return valActual + alpha * valAnterior;
    }
    public  void subirVolumen(double intensidad) throws IOException, WavFileException {
        leerAudio();
        bufferTmp.agregarBuffer(ListaEstatica.doubleArrayToObject(buffer2));
        for(int idx = 0; idx < bufferTmp.cantidad(); idx++) {
            bufferTmp.cambiar(idx, buffer2[idx] * intensidad);
        }
        tmpToBuffer();
        EscribirAudio();
    }

    private void tmpToBuffer() {
        buffer2 = new double[bufferTmp.cantidad()];
        SalidaPorDefecto.terminal( buffer2.length + " " + bufferTmp.cantidad());

        for(int idx = 0; idx < bufferTmp.cantidad(); idx++) {
            buffer2[idx] = (double) bufferTmp.obtener(idx);
        }
    }
    public void bajarVolumen(double intensidad) throws IOException, WavFileException {
        subirVolumen(-intensidad);
    }

    public void acelararAudio(int velocidad) {
        leerAudio();
        bufferTmp.agregarBuffer(ListaEstatica.doubleArrayToObject(buffer2));
        int newSize = buffer2.length / velocidad;
        bufferTmp = new ListaEstaticaNumerica(newSize);
        double curSum = 0.0;
        for(int idx = 0; idx < buffer2.length; idx ++) {
            curSum += buffer2[idx];
            if((idx + 1) % velocidad == 0) {
                double newVal = curSum / velocidad;
                bufferTmp.agregar(newVal);
                curSum = 0.0;
            }
        }
        tmpToBuffer();
        numFrames /= velocidad;
        EscribirAudio();
    }

    public void relentizarAudio(int decremento) {
        leerAudio();
        bufferTmp.agregarBuffer(ListaEstatica.doubleArrayToObject(buffer2));
        int newSize = buffer2.length * decremento;
        bufferTmp = new ListaEstaticaNumerica(newSize);
        for(int idx = 1; idx < buffer2.length; idx++) {
            bufferTmp.agregar(buffer2[idx]);
            double promedio = (buffer2[idx - 1] + buffer2[idx]) / 2;
            for(int relleno = 1; relleno < decremento; relleno++) {
                bufferTmp.agregar(promedio);
            }
        }
        tmpToBuffer();
        numFrames *= decremento;
        EscribirAudio();
    }


    public void eliminarSilencios() {
        leerAudio();
        bufferTmp = new ListaEstaticaNumerica(buffer2.length);
        int cntFrames = 0;
        for(int idx = 0; idx < buffer2.length; idx++) {
            if(buffer2[idx] > VALOR_SILENCIO) {
                bufferTmp.agregar(buffer2[idx]);
                cntFrames++;
            }
        }
        tmpToBuffer();
        numFrames = cntFrames;
        EscribirAudio();
    }

    public  void invertirAudio() {
        leerAudio();
        bufferTmp = new ListaEstaticaNumerica(buffer2.length);
        bufferTmp.rellenar(0, buffer2.length);

        int l = 0, r = buffer2.length - 1;
        while(l < r) {
            double tmpLeftVal = buffer2[l];
            bufferTmp.insertar(l, buffer2[r]);
            bufferTmp.insertar(r, tmpLeftVal);
            l++; r--;
        }
        tmpToBuffer();
        EscribirAudio();
    }

}
