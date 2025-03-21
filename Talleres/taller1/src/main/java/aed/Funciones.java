package aed;

class Funciones {
    int cuadrado(int x) {
        int res = x*x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x*x + y*y);
        return res;
    }

    boolean esPar(int n) {
        if (n % 2 == 0){
            return true;
        }
        return false;
    }

    boolean esBisiesto(int n) {
        if (n % 400 == 0){
            return true;
        }else if (n % 4 == 0 && n % 100 != 0){
            return true;
        }
        return false;
    }

    int factorialIterativo(int n) {
        int contador = 1;
        int res = 1;
        while(contador <= n){
            res *= contador;
            contador += 1;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if (n == 0){
            return 1;
        }else {
            return n * factorialRecursivo(n-1);
        }
    }

    boolean esPrimo(int n) {
        return false;
    }

    int sumatoria(int[] numeros) {
        return 0;
    }

    int busqueda(int[] numeros, int buscado) {
        // COMPLETAR
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        // COMPLETAR
        return false;
    }

    boolean todosPares(int[] numeros) {
        // COMPLETAR
        return false;
    }

    boolean esPrefijo(String s1, String s2) {
        // COMPLETAR
        return false;
    }

    boolean esSufijo(String s1, String s2) {
        // COMPLETAR
        return false;
    }
}
