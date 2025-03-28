package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) { //Constructor
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) { //Constructor
        
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    public String toString() {
        return dia + "/" + mes;
    }

    @Override
    public boolean equals(Object otra) {
        boolean otroEsNull = (otra == null);
        boolean claseDistinta = otra.getClass() != this.getClass();

        if (otroEsNull || claseDistinta) {
            return false;
        }
    Fecha otraFecha = (Fecha) otra;
    
    return dia == otraFecha.dia && mes == otraFecha.mes;
    }

    public void incrementarDia() {
        if(this.dia == 31 && this.mes == 12){
            dia = 1;
            mes = 1;
        }else if(this.dia == diasEnMes(mes)){
            dia = 1;
            mes += 1;
        } else {
            dia += 1;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
