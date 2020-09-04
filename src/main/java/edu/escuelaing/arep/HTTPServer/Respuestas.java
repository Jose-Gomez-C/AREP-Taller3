package edu.escuelaing.arep.HTTPServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;

import javax.print.attribute.standard.OutputDeviceAssigned;

/**
 * Metodo que almcaena lo necesario para responder el metodo get
 * @author Jose
 *
 */
public class Respuestas {
	private String contentType;
	private OutputStream response;
	private String path;
	private boolean esImagen;
	private boolean isPost;
	private String estado;
	private String pagina;
	private String body; 
	private static final String ok = "HTTP/1.1 200 OK\r\n";
	private static final String bad = "HTTP/1.1 404 Not Found \r\n" + "Content-type: text/html" + "\r\n\r\n";
	public Respuestas() {
		
	}
	/**
	 * Metodo encargado de guardar los paramentros necesarios de la respuesta
	 * @param response OutputStream que le pertenece 
	 * @param path la ruta de lo que desea hacer 
	 */
	public Respuestas(OutputStream response, String path) {
		isPost=false; 
		this.response = response;
		this.path = path;
		if(path.endsWith(".html")) {
			contentType = "html";
			esImagen =false;
		}else if(path.endsWith("css")) {
			contentType = "css";
			esImagen =false;
		}else if(path.endsWith(".jpg")) {
			contentType = "jpg";
			esImagen =true;
		}else if(path.endsWith(".png")) {
			contentType = "png";
			esImagen =true;
		}else if (path.endsWith("js")) {
			contentType = "js";
			esImagen =false;
		}else {
			esImagen =false;
		}
		
	}
	/**
	 * Metodo encargado de guardar los paramentros necesarios de la respuesta
	 * @param outputStream OutputStream que le pertenece 
	 * @param body Cuerpo de la pagina que desea guardar
	 * @param path la ruta de lo que desea hacer
	 */
	public Respuestas(OutputStream outputStream, String body, String path) {
		this.response = outputStream;
		this.path =path;
		this.body = body; 
		isPost = true;
	}
	/**
	 * Lee los archivos que encuentre en la ruta
	 * @return Lapagina a cargar 
	 */
	public String generatePage() {
		pagina ="";
		try {
			String body = "";
			BufferedReader page = new BufferedReader(new FileReader(new File(System.getProperty("user.dir"),"src/main/resources/public"+path)));
			String linea;
			while ((linea = page.readLine()) != null) {
				body += linea+"\n";
			}
			pagina = body;
			estado=ok;
		} catch (Exception e) {
			estado = bad;
			pagina= "404 File not found";
		}
		return pagina; 
	}
	/**
	 * 
	 * @return
	 */
	public String getPagina() {
		return pagina;
	}
	/**
	 * 
	 * @return
	 */
	public boolean getIsPost() {
		return isPost;
	}
	/**
	 * 
	 * @return
	 */
	public String getOk() {
		return ok;
	}
	/**
	 * 
	 * @return
	 */
	public String getBad() {
		return bad;
	}
	/**
	 * 
	 * @return
	 */
	public OutputStream getResponse() {
		return response;
	}
	/**
	 * 
	 * @return
	 */
	public String getContentType() {
		return contentType;
	}
	/**
	 * 
	 * @return
	 */
	public OutputStream getOutputStream() {
		return response;
	}
	
	public String getPath() {
		return path;
	}
	/**
	 * 
	 * @return
	 */
	public boolean getEsImagen() {
		return esImagen;
	}
	/**
	 * 
	 * @return
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * 
	 * @param pagina
	 */
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	/**
	 * 
	 * @return
	 */
	public String getBody() {
		return body; 
}

}
