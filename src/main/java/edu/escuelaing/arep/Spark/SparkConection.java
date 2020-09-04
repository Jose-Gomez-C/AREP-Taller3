package edu.escuelaing.arep.Spark;

import edu.escuelaing.arep.HTTPServer.Respuestas;
import edu.escuelaing.arep.Persistence.BaseDeDatos;
/**
 * Clase encargada de conectar HTTPServer con la base de datos 
 * @author Jose
 *
 */
public class SparkConection {
	private static BaseDeDatos baseDatos;
	private static SparkConection sparkConection;
	/**
	 * Metodo encargado de conectar la base de datos
	 */
	public SparkConection() {
		baseDatos = new BaseDeDatos();
	}
	/**
	 * Metodod encargado de crear la conexion a la base de datos si no existe o retornarla 
	 * @return retorna la conexion a la base de datos
	 */
	public static SparkConection  getSparkConection() {
		if (sparkConection == null) {
			sparkConection = new SparkConection();
		}
		return sparkConection;
	}
	/**
	 * Metodo encargado de trasformar la peticion  en el dato que se desea insertar 
	 * @param solicitud Los datos de la solicitud
	 */
	public void InsertarDato(Respuestas solicitud) {
		String[] dato= solicitud.getBody().split("\n");
		String datoInsertar = dato[dato.length-1];
		datoInsertar = datoInsertar.replace("[", "").replace("]", "");
		//String[] datos = datoInsertar.split(",");
		baseDatos.insertDataBase(datoInsertar);
	}
	/**
	 * Metodo encargado de consultar los datos de la bse de datos
	 * @param solicitud la informacion de los datos solicitados
	 */
	public void CapturaInfo(Respuestas solicitud) {
		baseDatos.consultarDatos();
	}
	/**
	 * 
	 * @return La base de datos
	 */
	public static BaseDeDatos getBaseDeDatos() {
		return baseDatos;
	}

}
