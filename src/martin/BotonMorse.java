package martin;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class BotonMorse extends Button {

    private double duracionPulsacionCorta = 200;
    private double duracionPulsacionLarga = 2000;

    private ArrayList<LetraResultado> listaLetras = new ArrayList<>();

    private double inicioPresion;

    private char primeraPulsacion = ' '; //' ' no hubo pulsacion. C-> pulsacion corta. L-> Pulsación larga
    private char segundaPulsacion = ' ';

    //private DoubleProperty duracionPulsacionCorta = new SimpleDoubleProperty(0);
    //private DoubleProperty duracionPulsacionLarga = new SimpleDoubleProperty(0);


    public BotonMorse() {
       // pressedProperty().addListener()
        /*
        double inicioPresion = 0;
                int corta = 0;
                int larga = 0;
                if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                    inicioPresion = System.currentTimeMillis();
                } else if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
                    if (System.currentTimeMillis() - inicioPresion > duracionPulsacionCorta && System.currentTimeMillis() - inicioPresion < duracionPulsacionLarga) {
                        System.out.println("Pulsacion Larga: " + (System.currentTimeMillis() - inicioPresion) + " milliseconds");
                        larga++;
                        if (primeraPulsacion!=' ')
                        {

                        }
                        else
                            primeraPulsacion = 'L';
                    } else if (System.currentTimeMillis() - inicioPresion < duracionPulsacionCorta && System.currentTimeMillis() - inicioPresion > 0)
                        System.out.println("Pulsacion Corta: " + (System.currentTimeMillis() - inicioPresion) + " milliseconds");
                    else
                        System.out.println("La pulsacion no es correcta, demasiado larga, el usuario no contempla pulsaciones tan largas");
                }
        * */

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                inicioPresion = System.currentTimeMillis();
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double finPresion = System.currentTimeMillis();
                double tiempoPresion = finPresion - inicioPresion;
                if (tiempoPresion > 200 && tiempoPresion < 2000){
                    System.out.println("Pulsacion Larga: " + (tiempoPresion) + " milliseconds");
                    if (primeraPulsacion != ' '){
                        segundaPulsacion = 'L';
                    }else
                        primeraPulsacion = 'L';
                }else {
                    if (tiempoPresion < 200 && tiempoPresion > 0){
                        System.out.println("Pulsacion Corta: " + (tiempoPresion) + " milliseconds");
                        if(primeraPulsacion != ' '){
                            segundaPulsacion = 'C';
                        }else
                            primeraPulsacion = 'C';
                    }
                }
                if(listaLetras!=null) {
                    for (int i = 0; i < listaLetras.size(); i++) {
                        listaLetras.get(i).ejecuta(sacarLetra());
                    }
                }
            }
        });
    }

    public char sacarLetra(){
        if (primeraPulsacion == 'C' && segundaPulsacion == 'L'){
            return 'A';
        }
        if (primeraPulsacion == 'L' && segundaPulsacion == 'C'){
            return 'N';
        }
        if (primeraPulsacion == 'C' && segundaPulsacion == 'C'){
            return 'I';
        }
        if (primeraPulsacion == 'L' && segundaPulsacion == 'L'){
            return 'M';
        }
        primeraPulsacion = ' ';
        segundaPulsacion = ' ';
        return ' ';

    }

    public void addListaLetras(LetraResultado letraResultado){//añadir a la lista
        listaLetras.add(letraResultado);
    }

    public double getDuracionPulsacionCorta() {
        return duracionPulsacionCorta;
    }

    public void setDuracionPulsacionCorta(double duracionPulsacionCorta) {
        this.duracionPulsacionCorta = duracionPulsacionCorta;
    }

    public double getDuracionPulsacionLarga() {
        return duracionPulsacionLarga;
    }

    public void setDuracionPulsacionLarga(double duracionPulsacionLarga) {
        this.duracionPulsacionLarga = duracionPulsacionLarga;
    }
}
