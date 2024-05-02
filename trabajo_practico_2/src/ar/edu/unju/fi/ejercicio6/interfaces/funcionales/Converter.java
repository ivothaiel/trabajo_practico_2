package ar.edu.unju.fi.ejercicio6.interfaces.funcionales;

import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

@FunctionalInterface
public interface Converter<T, R> {
    R convert(T t);

    static <T> boolean isNotNull(T t) {
        return t != null;
    }

    default void mostrarObjeto(R r) {
        if (isNotNull(r)) {
            if (r instanceof FelinoSalvaje) {
                FelinoSalvaje felinoSalvaje = (FelinoSalvaje) r;
                System.out.println("Nombre: " + felinoSalvaje.getNombre());
                System.out.println("Edad: " + felinoSalvaje.getEdad());
                System.out.println("Peso: " + felinoSalvaje.getPeso());
            } else if (r instanceof FelinoDomestico) {
                FelinoDomestico felinoDomestico = (FelinoDomestico) r;
                System.out.println("Nombre: " + felinoDomestico.getNombre());
                System.out.println("Edad: " + felinoDomestico.getEdad());
                System.out.println("Peso: " + felinoDomestico.getPeso());
            } else {
                System.out.println("Tipo de felino desconocido");
            }
        } else {
            System.out.println("El objeto es nulo");
        }
    }
}
