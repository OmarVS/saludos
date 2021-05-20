package cl.duoc.ldapservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @ApiOperation(value = "getSaludo",
            notes = "La aplicación te saluda")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = String.class),
            @ApiResponse(code = 405, message = "Method Not Allowed", response = String.class),
            @ApiResponse(code = 415, message = "Unsupported Media Type", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)
    })
    @GetMapping(value = "/saludo")
    public ResponseEntity<String> getSaludo(@Nullable @RequestParam(name = "nombre") String nombre) {
        String body = "<html><title>Saludos</title><body><h1>Hola a todos!</h1><p>Un saludo a la clase de Azure :D</p>";
        if(nombre != null && !nombre.isEmpty()){
            body += "<p>Un saludo especial para " + nombre + "!</p>";
        }
        body += "</body><html>";
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @ApiOperation(value = "getDespedida",
            notes = "La aplicación se despide")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = String.class),
            @ApiResponse(code = 405, message = "Method Not Allowed", response = String.class),
            @ApiResponse(code = 415, message = "Unsupported Media Type", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)
    })
    @GetMapping(value = "/despedida")
    public ResponseEntity<String> getDespedida() {
        return new ResponseEntity<>("<html><title>Despedida</title><body><h1>Muchas gracias!</h1><p>Gracias por ser parte de este curso :D</p></body><html>", HttpStatus.OK);
    }
}
