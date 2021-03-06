package br.com.whiz.resources;

import br.com.whiz.domain.Funcionario;
import br.com.whiz.dto.FuncionarioDTO;
import br.com.whiz.dto.FuncionarioNewDTO;
import br.com.whiz.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FuncionarioDTO>> listAll() {
        List<Funcionario> funcionarios = funcionarioService.listAll();
        List<FuncionarioDTO> funcionarioDTO = funcionarios.stream().map(FuncionarioDTO::new).toList();
        return ResponseEntity.ok().body(funcionarioDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        Funcionario funcionarioId = funcionarioService.findById(id);
        return ResponseEntity.ok().body(funcionarioId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody FuncionarioNewDTO funcionarioNewDTO) {
        Funcionario funcionario = funcionarioService.fromDto(funcionarioNewDTO);
        funcionario = funcionarioService.insert(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioService.fromDto(funcionarioDTO);
        funcionario.setId(id);
        funcionarioService.update(funcionario);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
        funcionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> insert(@Valid @RequestBody FuncionarioDTO funcionarioDTO){
//        Funcionario funcionario = funcionarioService.fromDto(funcionarioDTO);
//        funcionario = funcionarioService.insert(funcionario);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(funcionario.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }


}
