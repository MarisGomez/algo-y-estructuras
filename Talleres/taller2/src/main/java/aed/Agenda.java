package aed;

public class Agenda {
    private Recordatorio[] recordatorios;
    private Fecha fechaActual;

    public Agenda(Fecha fechaActual) { //Constructor
        this.fechaActual = fechaActual;
        this.recordatorios = new Recordatorio[0];
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        Recordatorio[] nuevo = new Recordatorio[recordatorios.length + 1];
        for (int i = 0; i < recordatorios.length; i++) {
            nuevo[i] = recordatorios[i];
        }
        nuevo[nuevo.length - 1] = recordatorio;
        this.recordatorios = nuevo;
    }

    @Override
    public String toString() {
        String mensaje = fechaActual + "\n" + "=====" + "\n";
        for (int i = 0; i < recordatorios.length; i++) {
            if (this.recordatorios[i].fecha().dia() == fechaActual.dia() && this.recordatorios[i].fecha().mes() == fechaActual.mes()){
                mensaje += this.recordatorios[i] + "\n";
            }
        }
        return mensaje;
    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return this.fechaActual;
    }

}
