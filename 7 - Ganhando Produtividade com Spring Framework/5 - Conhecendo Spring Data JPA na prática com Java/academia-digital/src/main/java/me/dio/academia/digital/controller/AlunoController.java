package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.AlunoForm;
import me.dio.academia.digital.dto.AlunoUpdateForm;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    /*@GetMapping
    public List<Aluno> getAll(){
        return service.getAll();
    }*/

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                              String dataDeNacimento) {
        return service.getAll(dataDeNacimento);
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @PutMapping("/{id}")
    public Aluno update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

    }

}
