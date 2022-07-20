package com.arthur.algafood.api.assembler;

import com.arthur.algafood.api.model.*;
import com.arthur.algafood.domain.model.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class PermissaoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PermissaoModel toModel(Permissao permissao) {
        return modelMapper.map(permissao, PermissaoModel.class);
    }

    public List<PermissaoModel> toCollectionModel(Collection<Permissao> permissoes) {
        return permissoes.stream()
                .map(permissao -> toModel(permissao))
                .collect(Collectors.toList());
    }

}
