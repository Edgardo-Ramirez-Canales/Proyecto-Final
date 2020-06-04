package clases;

import java.util.HashMap;
import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class EnemigoAnimado extends ObjetoJuego{
	private int velocidad;
	private double velociadadAnimacion  ;
	private double num;
	private HashMap<String, Animacion> animaciones;
	private String animacionActual ;
	private int orientacion = 1;
	private int arp =0;
	private int puntuacion = 0;
	private String ultimaAnimacion = "descanso";
	public Juego juego;
	private boolean capturado;

	public EnemigoAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual ) {
		super(x, y,indiceImagen);
		this.velocidad = velocidad;
		this.velociadadAnimacion = num;
		this.animacionActual = animacionActual;
		animaciones = new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}

	public void inicializarAnimaciones() {
		
		Rectangle[] CoorrdenadasDescanso = {
				new Rectangle(75,92,62,68),
		};
		animaciones.put("descanso",new Animacion("descanso",0.20,CoorrdenadasDescanso));
		
		
		
		
		
	
	     }
	
	
	//Se ejecuta por cada iteracion del ciclo de juego
	public void mover() {
		if (y<20) {
			y= 620;
			
		}
	
		
	     if(x < Juego.positionX)
	            y+=velocidad;
	        
	        if(x > Juego.positionX)
	            y-=velocidad;
	        
	        if(y < Juego.positionY)
	            y+=velocidad;
	        
	        if(y > Juego.positionY)
	            y-=velocidad;
	        

		
		
		
		
	}

	
	public void actualizarAnimacion(double time) {
		Rectangle rectanguloActual = animaciones.get(animacionActual).calcularFrameActual(time);
		this.xImagen = (int)rectanguloActual.getX();
		this.yImagen = (int)rectanguloActual.getY();
		this.anchoImagen = (int)rectanguloActual.getWidth();
		this.altoImagen = (int)rectanguloActual.getHeight();
	}
	
	
	public void pintar (GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(indiceImagen), xImagen, yImagen, anchoImagen, altoImagen, x+arp, y, (orientacion)*anchoImagen, altoImagen);
	}

	public void agregarPuntuacion(int puntuacion) {
		this.puntuacion+= puntuacion;
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public boolean verificarColision(Item item) {
		if (obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal()) && !item.isCapturado()) {
			item.setCapturado(true);
			agregarPuntuacion(1);
			System.out.println("Estan colisionando");
			return true;
		}
		return false;
	}

	
	
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public HashMap<String, Animacion> getAnimaciones() {
		return animaciones;
	}

	public void setAnimaciones(HashMap<String, Animacion> animaciones) {
		this.animaciones = animaciones;
	}

	public String getAnimacionActual() {
		return animacionActual;
	}

	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}

	public int getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(int orientacion) {
		this.orientacion = orientacion;
	}

	public double getVelociadadAnimacion() {
		return velociadadAnimacion;
	}

	public void setVelociadadAnimacion(double velociadadAnimacion) {
		this.velociadadAnimacion = velociadadAnimacion;
	}

	public int getArp() {
		return arp;
	}

	public void setArp(int arp) {
		this.arp = arp;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getUltimaAnimacion() {
		return ultimaAnimacion;
	}

	public void setUltimaAnimacion(String ultimaAnimacion) {
		this.ultimaAnimacion = ultimaAnimacion;
	}
	
	
	public boolean isCapturado() {
		return capturado;
	}
	
	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
	

	
	

	
	
}


