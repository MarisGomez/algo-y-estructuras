package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha.dia(), fecha.mes());
        this.horario = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return new Fecha(this.fecha);
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje + " @ " + this.fecha + " " + this.horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null || otro.getClass() != this.getClass()) return false;
        Recordatorio otroRecordatorio = (Recordatorio) otro;
    
        return mensaje == otroRecordatorio.mensaje() &&
        this.horario().equals(otroRecordatorio.horario) &&
        this.fecha().equals(otroRecordatorio.fecha);
    }
}
