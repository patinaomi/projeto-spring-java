package br.com.tgid.spring.gateways.resources;

import br.com.tgid.spring.domains.Categoria;

import br.com.tgid.spring.gateways.mapper.CategoriaMapper;

import br.com.tgid.spring.gateways.request.CategoriaRequest;
import br.com.tgid.spring.gateways.response.CategoriaResponse;
import br.com.tgid.spring.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    private final CategoriaService service;
    private final CategoriaMapper categoriaMapper;


    @PostMapping("/create")
    public ResponseEntity<CategoriaResponse> create(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        // Converte CategoriaRequest para Categoria
        Categoria categoriaEntity = new Categoria();
        categoriaEntity.setNome(categoriaRequest.getNome());
        // Defina os outros campos conforme necessário

        // Cria a categoria e salva no banco
        Categoria categoriaCreated = service.create(categoriaEntity);

        // Converte Categoria para CategoriaResponse
        CategoriaResponse categoriaResponse = new CategoriaResponse(
                categoriaCreated.getId(),
                categoriaCreated.getNome()
        );

        return ResponseEntity.ok().body(categoriaResponse);
    }
}
