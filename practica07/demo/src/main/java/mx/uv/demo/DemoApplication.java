package mx.uv.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class DemoApplication {
	List<Productos> elementos = new ArrayList<Productos>();
	List<Persona> agenda = new ArrayList<Persona>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public String name1(){
		return "hola mundo";
	}

	@RequestMapping("/adios")
	public String name2(){
		return "adios mundo";
	}

	@RequestMapping("/pregunta")
	public String name3(){
		return "<h1>¿Como estas?</h1>";
	}

	@RequestMapping(value="/personas", method = RequestMethod.POST)
	public String personaPOST(@RequestBody Persona persona){
		agenda.add(persona);
		return "OK";
	}

	@RequestMapping(value = "/personas", method = RequestMethod.GET)
	public List<Persona> personaGET(){
		return agenda;
	}
	
	// @RequestMapping("/productos")
	// public List<String>productos(){
	// 	List<String> p = new ArrayList<String>();
	// 	p.add("pambazos");
	// 	p.add("tamales");
	// 	p.add("refrescos");
	// 	return p;
	// }

	// @RequestMapping("/productos2")
	// public List<Productos>productos2(){
	// 	List<Productos> lista = new ArrayList<Productos>();
	// 	Productos p = new Productos("pambazos", 10);
	// 	lista.add(p);
	// 	Productos p1 = new Productos("tamales", 50);
	// 	lista.add(p1);
	// 	Productos p2 = new Productos("refrescos", 20);
	// 	lista.add(p2);
	// 	return lista;
	// }

	// //curl -i localhost:8080
	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	// public String saludarGet(){
	// 	return "Hola mundo /saludar GET!!";
	// }

	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public List<Productos>productos(){
		return elementos;
	}

	//curl -i -X POST localhost:8080
	// @RequestMapping(value = "/post", method = RequestMethod.POST)
	// public String saludarPost(){
	// 	return "Hola mundo /saludar POST!!";
	// }

	@RequestMapping(value = "/productos/{nombre}/{cantidad}", method = RequestMethod.POST)
	public String meterDatos(@PathVariable String nombre, @PathVariable Integer cantidad){
		Productos productos = new Productos(nombre, cantidad);
		elementos.add(productos);
		return "Se ha añadido un producto";
	}

	@PutMapping(value = "/productos/{nombre}/{cantidad}")
	public void actualizarProd(@PathVariable String nombre,@PathVariable Integer cantidad, @RequestBody Productos productos){
		Productos p = new Productos();
		Integer indice = 0;
		p.setNombre(nombre);
		p.setCantidad(cantidad);
		for(Productos prod : elementos) {
			if(prod.getNombre().equals(nombre)) {
				indice = elementos.indexOf(prod);
			}
		}
		elementos.set(indice, p);
	}

	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable String nombre){
		int indice = -1;
		for(Productos prod : elementos) {
			if(prod.getNombre().equals(nombre)) {
				indice = elementos.indexOf(prod);
			}
		}
		elementos.remove(indice);
	}
	//este solamente agarra el parámetro como el de nombre
	// @RequestMapping(value="/recurso/{nombre}", method= RequestMethod.POST)
	// public String saludarPathVariable(@PathVariable String nombre){
	// 	return "Hola";
	// }

	// //Este otro recibe un json como el del comentario de abajo
	// @RequestMapping(value="/recurso/{nombre}", method= RequestMethod.POST)
	// public String saludarJson(@RequestBody Persona nombre){
	// 	return "Hola";
	// }

	//p.json
	// {"nombre":"xxx",
	// "color: verde",
	// "edad":12}
}
