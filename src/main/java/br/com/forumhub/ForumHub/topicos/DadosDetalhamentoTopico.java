package br.com.forumhub.ForumHub.topicos;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(

        long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        String status,
        String autor,
        String curso) {

    public DadosDetalhamentoTopico(TopicosCadastro topicosCadastro) {
        this(topicosCadastro.getId(), topicosCadastro.getTitulo(), topicosCadastro.getMensagem(), topicosCadastro.getData(), topicosCadastro.getStatus(), topicosCadastro.getAutor(), topicosCadastro.getCurso());

    }
}