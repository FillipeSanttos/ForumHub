package br.com.forumhub.ForumHub.controller;

import br.com.forumhub.ForumHub.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired //Injeção de Dependência
    private TopicosRepository repository;

    //Criar um novo tópico
    @PostMapping
    @Transactional //Quando não é apenas uma leitura do banco
    public ResponseEntity cadastrarTopicos(@RequestBody @Valid DadosCadastroTopico json, UriComponentsBuilder uriBuilder) {

        var topico = new TopicosCadastro(json);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    //Listar todos os tópicos
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    //Listar tópico por id
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    //Modificar um tópico
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        Optional<TopicosCadastro> optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            TopicosCadastro topico = optionalTopico.get();
            topico.atualizarInformacoes(dados);

            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Deletar um tópico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirCadastro(@PathVariable Long id) {
        Optional<TopicosCadastro> optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}