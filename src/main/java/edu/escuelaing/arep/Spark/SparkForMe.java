package edu.escuelaing.arep.Spark;

import edu.escuelaing.arep.HTTPServer.HTTPServer;
import edu.escuelaing.arep.HTTPServer.Respuestas;
/**
 * Clase encargada de correr el servidor
 * @author Jose
 *
 */
public class SparkForMe {
	 public static void main(String[] args) {
		HTTPServer page = new HTTPServer();
		page.start();
		page.ingresarSolicitud("/Datos",(Respuestas) -> {
			return SparkConection.getSparkConection().getBaseDeDatos().consultarDatos();
		});
		
	}
}
