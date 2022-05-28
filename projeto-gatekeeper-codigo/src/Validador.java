
public class Validador {

    public static boolean validaInteiro(String valor) {
        try {
            Long.valueOf(valor).longValue();
            boolean convertido = true;
            return convertido;
        } catch (NumberFormatException e) {
            /*e.printStackTrace();*/
            boolean convertido = false;
            return convertido;
        }

    }
}

