package edu.escuelaing.arep.Persistence;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * Clase encargada de administrar la base de datos
 * @author Jose
 *
 */
public class BaseDeDatos {
	private MongoCollection<org.bson.Document> columnas;
	private String key;
	private int llave;
	/**
	 * Metodo encargado de realizar la conexion a la base de datos
	 */
	public BaseDeDatos() {
		llave = 0;
		key = "dato";
		MongoClientURI uri = new MongoClientURI("mongodb+srv://Admin:Hola123@cluster0.ikgff.azure.mongodb.net/Calculos?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase dataBase = mongoClient.getDatabase("Calculos");
		columnas = dataBase.getCollection("Numeros");
	}
	/**
	 * Metodoencargado de insertar en la base de datos
	 * @param valor
	 */
	public void insertDataBase(String valor) {
		Document prueba = new Document(key, valor);
		columnas.insertOne(prueba);
	}
	/**
	 * Metodo encargado de consultar los datos disponibles de la base de datos
	 * @return
	 */
	public String consultarDatos() {
		String data ="";
		int i=1;
		for (Document d : columnas.find()) {
			data += "Dato Numero " + String.valueOf(i)+" "+d.get(key).toString()+"\n";
			i++;
		}
		return data; 
	}

}
