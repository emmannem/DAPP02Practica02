/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.DAPP02Practica02;

import java.net.URI;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author JMRes
 */
@RestController
@RequestMapping("/api/v2/")
public class ControllerEmpleados {

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    @GetMapping("/empleado/")
    public List<Empleado> list() {
        return repositoryEmpleado.findAll();
    }

    @GetMapping("/empleado/{id}")
    public Empleado get(@PathVariable Long id) {
        Optional<Empleado> resEmpleado = repositoryEmpleado.findById(id);
        if (resEmpleado.isPresent()) {
            return resEmpleado.get();
        } else {
            return null;
        }
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<Empleado> put(@PathVariable Long id, @RequestBody Empleado empleado) {
        Optional<Empleado> employee = repositoryEmpleado.findById(id);
        if (employee.isPresent()) {
            try {
                Empleado empleadoActualizar = employee.get();
                empleadoActualizar.setNombre(empleado.getNombre());
                empleadoActualizar.setDireccion(empleado.getDireccion());
                empleadoActualizar.setTelefono(empleado.getTelefono());
                repositoryEmpleado.save(empleadoActualizar);
                //return ResponseEntity.ok().body(empleadoActualizar);
                return ResponseEntity.ok(empleadoActualizar);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/empleado/")
    public ResponseEntity<Empleado> post(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = repositoryEmpleado.save(empleado);
        try {
            return ResponseEntity.ok().body(savedEmpleado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Empleado> empleado = repositoryEmpleado.findById(id);
        if (empleado.isPresent()) {
            try {
                repositoryEmpleado.deleteById(id);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
