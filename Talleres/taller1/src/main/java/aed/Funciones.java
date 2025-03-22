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

    int cantDivisores(int n) {
        int contador = 1;
        int res = 0;
            while(contador <= n){
                if(n % contador == 0){
                    res += 1;
                    contador += 1;
                }else {
                    contador += 1;
                }
            }
        return res;
    }

    boolean esPrimo(int n) {
        if(cantDivisores(n) == 2){
            return true;
        }
        return false;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int x:numeros){
            res += x;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for (int x:numeros){
            if (x == buscado){
                return res;
            } else{
                res += 1;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        for (int x:numeros){
            if (esPrimo(x)){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int x:numeros){
            if (x % 2 != 0){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        } else{
            for (int i = 0; i < s1.length(); i++){
                if (s1.charAt(i) != s2.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        } else{
            for (int i = 0; i < s1.length(); i++){
                if (s1.charAt(s1.length() - i - 1) != s2.charAt(s2.length() - i - 1)){
                    return false;
                }
            }
        }
        return true;
    }
}
