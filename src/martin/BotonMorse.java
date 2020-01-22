package martin;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;

public class BotonMorse extends Button {

    //private double duracionPulsacionCorta;
    //private double duracionPulsacionLarga;

    private DoubleProperty duracionPulsacionCorta = new SimpleDoubleProperty(0);
    private DoubleProperty duracionPulsacionLarga = new SimpleDoubleProperty(0);


    public BotonMorse() {
        pressedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {

            }
        });
    }

    public double getDuracionPulsacionCorta() {
        return duracionPulsacionCorta.get();
    }

    public DoubleProperty duracionPulsacionCortaProperty() {
        return duracionPulsacionCorta;
    }

    public void setDuracionPulsacionCorta(double duracionPulsacionCorta) {
        this.duracionPulsacionCorta.set(duracionPulsacionCorta);
    }

    public double getDuracionPulsacionLarga() {
        return duracionPulsacionLarga.get();
    }

    public DoubleProperty duracionPulsacionLargaProperty() {
        return duracionPulsacionLarga;
    }

    public void setDuracionPulsacionLarga(double duracionPulsacionLarga) {
        this.duracionPulsacionLarga.set(duracionPulsacionLarga);
    }
}
