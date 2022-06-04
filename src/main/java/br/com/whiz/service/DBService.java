package br.com.whiz.service;

import br.com.whiz.domain.Funcionario;
import br.com.whiz.enums.TipoFuncionario;
import br.com.whiz.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void instanceTestDataBase() throws ParseException {
        //Colocar codigo com test para H2

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Funcionario f1 = new Funcionario(null, "Carlos", sdf.parse("2000/09/21"), TipoFuncionario.VENDEDOR,
                "5038035658");

        Funcionario f2 = new Funcionario(null, "Marcos", sdf.parse("1988/02/11"), TipoFuncionario.GERENTE,
                "4820387354");

        funcionarioRepository.saveAll(List.of(f1, f2));


    }
}
