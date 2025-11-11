package com.biglietteria.controllers;

import com.biglietteria.entities.Cliente;
import com.biglietteria.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    private IClienteRepository clienteRepo;

    @GetMapping("/login/{codCliente}")
    public ResponseEntity<?> login(@PathVariable int codCliente) {
        Optional<Cliente> clienteOpt = clienteRepo.findById(codCliente);
        if (clienteOpt.isPresent()) {
            return ResponseEntity.ok(clienteOpt.get());
        } else {
            return ResponseEntity
                    .status(404)
                    .body("{\"success\": false, \"message\":\"Cliente non trovato\"}");
        }
    }

    // Login tramite POST
    @PostMapping("/login")
    public ResponseEntity<?> loginPost(@RequestBody LoginRequest loginRequest) {
        Optional<Cliente> clienteOpt = clienteRepo.findById(loginRequest.getCodCliente());
        if (clienteOpt.isPresent()) {
            return ResponseEntity.ok(clienteOpt.get());
        } else {
            return ResponseEntity
                    .status(404)
                    .body("{\"success\": false, \"message\":\"Cliente non trovato\"}");
        }
    }

    // DTO per login POST
    public static class LoginRequest {
        private int codCliente;
        public int getCodCliente() { return codCliente; }
        public void setCodCliente(int codCliente) { this.codCliente = codCliente; }
    }
}