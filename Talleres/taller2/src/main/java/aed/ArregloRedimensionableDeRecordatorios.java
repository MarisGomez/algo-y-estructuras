package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new Recordatorio[0];
    }

    public int longitud() {
        return this.recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevo = new Recordatorio[recordatorios.length + 1];
        for (int j = 0; j < recordatorios.length; j++) {
            nuevo[j] = recordatorios[j];
        }
        nuevo[nuevo.length - 1] = i;
        this.recordatorios = nuevo;
    }

    public Recordatorio obtener(int i) {
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevo = new Recordatorio[recordatorios.length - 1];
        for (int j = 0; j < recordatorios.length - 1; j++) {
            nuevo[j] = recordatorios[j];
        }
        this.recordatorios = nuevo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.recordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.recordatorios = vector.copiar().recordatorios;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios nuevoArreglo = new ArregloRedimensionableDeRecordatorios();
        for (int i = 0; i < recordatorios.length; i ++) {
            nuevoArreglo.agregarAtras(new Recordatorio(this.recordatorios[i].mensaje(), this.recordatorios[i].fecha(), this.recordatorios[i].horario()));
        }
        return nuevoArreglo;
    }
}
