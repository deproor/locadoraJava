package com.example.demo.service;

import com.example.demo.dto.CarroDTO;
import com.example.demo.dto.CarroRequest;
import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<Carro> listarTodos() {
        return repository.findAll();
    }

    public Carro salvar(CarroRequest request) {
        Carro novoCarro = new Carro(request.modelo(), request.marca(), true);
        return repository.save(novoCarro);
    }

    public Carro alugar(Long id) {
        Carro carro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado!"));

        if (!carro.isDisponivel()) {
            throw new RuntimeException("Este carro já está alugado!");
        }

        carro.setDisponivel(false);
        return repository.save(carro);
    }

    public Carro devolver(Long id) {
        Carro carro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado!"));

        if (carro.isDisponivel()) {
            throw new RuntimeException("Este carro já está na garagem!");
        }

        carro.setDisponivel(true);
        return repository.save(carro);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Carro não encontrado para exclusão!");
        }
        repository.deleteById(id);
    }

    public List<CarroDTO> buscarPorMarca(String marca) {
        return repository.findByMarcaIgnoreCase(marca).stream()
                .map(carro -> new CarroDTO(carro.getModelo(), carro.getMarca(), carro.isDisponivel()))
                .toList();
    }
}