package br.com.whiz.service;

import br.com.whiz.domain.Cidade;
import br.com.whiz.domain.Endereco;
import br.com.whiz.domain.Estado;
import br.com.whiz.domain.Funcionario;
import br.com.whiz.dto.FuncionarioDTO;
import br.com.whiz.enums.TipoFuncionario;
import br.com.whiz.repository.CidadeRepository;
import br.com.whiz.repository.EnderecoRepository;
import br.com.whiz.repository.EstadoRepository;
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

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void instanceTestDataBase() throws ParseException {
        //Colocar codigo com test para H2

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Funcionario f1 = new Funcionario(null, "Carlos", "794237492",sdf.parse("2000/09/21"), TipoFuncionario.VENDEDOR);

        Funcionario f2 = new Funcionario(null, "Marcos", "4820387354",sdf.parse("1988/02/11"), TipoFuncionario.GERENTE);

        Estado est1 = new Estado(null, "Ceara", "CE");
        Estado est2 = new Estado(null, "Alagoas", "AL");

        Cidade cid1 = new Cidade(null, "Santana", est1);
        Cidade cid2 = new Cidade(null, "Bom Jesus", est2);

        Endereco end1 = new Endereco(null, "Celso Correa", 345, "Palmares", "61766032", cid2, f1);
        Endereco end2 = new Endereco(null, "Mata Mouros", 76, "Calango", "632666542", cid1, f1);

        f1.getEnderecos().addAll(List.of(end1, end2));

        funcionarioRepository.saveAll(List.of(f1, f2));
        estadoRepository.saveAll(List.of(est1, est2));
        cidadeRepository.saveAll(List.of(cid1, cid2));
        enderecoRepository.saveAll(List.of(end1, end2));

    }
}
