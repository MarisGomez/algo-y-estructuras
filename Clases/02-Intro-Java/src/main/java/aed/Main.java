package aed;

class Main {
    int fibonacci(int n) {
        int res = 0 ;
        if (n == 0) {
            res = 0;
        } else if (n == 1) {
            res = 1;
        } else {
            res = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return res;
    }

    int fibonacciReturn(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciReturn(n - 1) + fibonacciReturn(n - 2);
    }

    double maximo(double[] xs) { //double -> numeros reales, double [] -> tipo arreglo de num reales
        double res = xs[0]; //primer elem del arreglo
        for (double x : xs) {
            // Si encuentro un elemento mayor al que tenía guardado, me lo guardo
            if (x > res) {
                res = x;
            }
        }
        return res;
    }

    int[] sumarArreglos(int[] seq1, int[] seq2) {
        int[] res = new int[seq1.length]; // new (nueva instancia) -> para crear un nuevo arreglo de la misma longitud que seq1, contiene basura
        for (int i = 0; i < seq1.length; i++) {
            res[i] = seq1[i] + seq2[i];
        }
        return res;
    }

    String iniciales(String texto) {
        //Ej: texto = "hola mundo", res = "hm"
        String res = "";
        for (int i = 0; i < texto.length(); i++) {
            if (i == 0 || (texto.charAt(i-1) == ' ' && texto.charAt(i) != ' ')) { //carAt(i) -> devuelve el caracter del texto que esta en posicion i
                res += texto.charAt(i);
            }
        }
        return res;
    }
}