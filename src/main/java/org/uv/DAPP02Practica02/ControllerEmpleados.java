/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.DAPP02Practica02;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

//        if (id.hashCode() == 1) {
//            Empleado emp = new Empleado();
//            emp.setClave(1L);
//            emp.setNombre("Gabriel");
//            emp.setDireccion("Av.1");
//            emp.setTelefono("123");
//            return emp;
//        } else {
//            return null;
//        }
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @PostMapping("/empleado/")
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

}
