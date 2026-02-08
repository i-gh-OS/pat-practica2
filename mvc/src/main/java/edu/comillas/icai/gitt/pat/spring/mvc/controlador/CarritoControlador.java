package edu.comillas.icai.gitt.pat.spring.mvc.controlador;

import edu.comillas.icai.gitt.pat.spring.mvc.modelo.Carrito;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CarritoControlador {
    private final Map<Integer, Carrito> carritos = new HashMap<>(); //tipo del hashmap debe coincidir con la del carrito

    //ahora importamos las peticiones que tenemos que hacer

    //leer todos los carritos
    @GetMapping("/api/carrito")
    public Collection<Carrito> getCarritos() {
        return carritos.values();
    }

    //crear un carrito
    @PostMapping("/api/carrito")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito creaCarrito(@RequestBody Carrito carrito) {
        carritos.put(carrito.getIdCarrito(), carrito);
        return carrito;
    }

    //leer un carrito especifico
    @GetMapping("/api/carrito/{idCarrito}")
    public Carrito getCarrito(@PathVariable int idCarrito) {
        return carritos.get(idCarrito);
    }


//    @PutMapping("/api/contadores/{nombre}/incremento/{incremento}")
//    public ModeloContador incrementa(@PathVariable String nombre,
//                                     @PathVariable Integer incremento) {
//        ModeloContador contadorActual = contadores.get(nombre);
//        ModeloContador contadorIncrementado =
//                new ModeloContador(nombre, contadorActual.valor() + incremento);
//        contadores.put(nombre, contadorIncrementado);
//        return contadorIncrementado;
//    }
}
