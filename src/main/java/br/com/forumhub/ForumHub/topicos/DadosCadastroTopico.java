package br.com.forumhub.ForumHub.topicos;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String status,
        @NotBlank
        String autor,
        @NotBlank
        String curso) {
}