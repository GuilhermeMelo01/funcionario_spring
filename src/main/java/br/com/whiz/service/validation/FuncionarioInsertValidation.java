package br.com.whiz.service.validation;

import br.com.whiz.controller.exception.FieldMessage;
import br.com.whiz.dto.FuncionarioNewDTO;
import br.com.whiz.repository.FuncionarioRepository;
import br.com.whiz.service.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioInsertValidation implements ConstraintValidator<FuncionarioInsert, FuncionarioNewDTO> {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public void initialize(FuncionarioInsert ann) {
    }

    @Override
    public boolean isValid(FuncionarioNewDTO funcionarioNewDTO, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if (!BR.isValidCPF(funcionarioNewDTO.getCpf())) {
            list.add(new FieldMessage("CPF", "INVALID CPF!"));
        }

        for (FieldMessage fm : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(fm.getMessage()).addPropertyNode(fm.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
