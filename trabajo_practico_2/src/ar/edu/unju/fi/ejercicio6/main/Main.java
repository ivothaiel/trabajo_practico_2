package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

    public static void main(String[] args) {
        // Creamos un felino doméstico
        FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);

        // Definimos una expresión lambda que define el convertidor de FelinoDomestico a FelinoSalvaje
        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),
                x.getEdad(), x.getPeso());

        // Realizamos la conversión
        FelinoSalvaje felino1 = converter.convert(gato);

        // Mostramos los datos del objeto felino salvaje felino1
        System.out.println("Conversión de felino doméstico a felino salvaje:");
        converter.mostrarObjeto(felino1);

        // Realizamos la conversión inversa de un objeto felino salvaje a felino doméstico
        FelinoSalvaje felinoSalvaje = new FelinoSalvaje("Tanner", (byte) 20, 186f);

        // Verificamos si el objeto a convertir no es nulo utilizando el método estático de la interfaz
        if (Converter.isNotNull(felinoSalvaje)) {
            // Mostramos los datos del objeto felino salvaje antes de la conversión
            System.out.println("\nAntes de la conversión:");
            converter.mostrarObjeto(felinoSalvaje);
        }

        // Realizamos la conversión inversa
        Converter<FelinoSalvaje, FelinoDomestico> converterInverso = x -> new FelinoDomestico(x.getNombre(),
                x.getEdad(), x.getPeso());

        FelinoDomestico felino2 = converterInverso.convert(felinoSalvaje);

        // Mostramos los datos del objeto felino doméstico después de la conversión
        System.out.println("\nConversión de felino salvaje a felino doméstico:");
        converterInverso.mostrarObjeto(felino2);
    }
}
