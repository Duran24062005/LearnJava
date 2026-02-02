package models;

/**
 * Estados posibles de una orden
 */
public enum OrderStatus {
    PENDING, // Esperando procesamiento
    PROCESSING, // En proceso
    COMPLETED, // Completada exitosamente
    FAILED, // Falló por algún error
    CANCELLED // Cancelada
}
