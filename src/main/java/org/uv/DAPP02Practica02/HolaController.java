/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.DAPP02Practica02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JMRes
 */
@RestController
@RequestMapping("/holamundo")
public class HolaController {

    @GetMapping
    public String holamundo() {
        return "Hola Mundo";
    }
    @GetMapping("/dos")
    public String holamundo2() {
        return "Hola Mundo 2";
    }
    @PostMapping("/dos")
    public String holamundo3() {
        return "Post Hola Mundo";
    }

}
