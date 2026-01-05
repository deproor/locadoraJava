package com.example.demo.controller;

import com.example.demo.dto.CarroDTO;
import com.example.demo.dto.CarroRequest;
import com.example.demo.model.Carro;
import com.example.demo.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService service; // Mudamos aqui!

    @GetMapping
    public List<CarroDTO> listar() {
        return service.listarTodos().stream()
                .map(carro -> new CarroDTO(carro.getModelo(), carro.getMarca(), carro.isDisponivel()))
                .toList();
    }

    @PostMapping
    public CarroDTO salvar(@RequestBody CarroRequest request) {
        Carro carroSalvo = service.salvar(request);
        return new CarroDTO(carroSalvo.getModelo(), carroSalvo.getMarca(), carroSalvo.isDisponivel());
    }

    @PutMapping("/{id}/alugar")
    public Carro alugar(@PathVariable Long id) {
        return service.alugar(id);
    }

    @PutMapping("/{id}/devolver")
    public Carro devolver(@PathVariable Long id) {
        return service.devolver(id);
    }

    @GetMapping("/buscar")
    public List<CarroDTO> buscarPorMarca(@RequestParam String marca) {
        return service.buscarPorMarca(marca);
    }
}