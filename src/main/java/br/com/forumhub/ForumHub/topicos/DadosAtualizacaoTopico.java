package br.com.forumhub.ForumHub.topicos;

import java.time.LocalDateTime;

public record DadosAtualizacaoTopico(
        String titulo,
        String mensagem,
        LocalDateTime data,
        String status,
        String autor,
        String curso){
}