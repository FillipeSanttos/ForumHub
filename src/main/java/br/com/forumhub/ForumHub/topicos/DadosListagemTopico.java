package br.com.forumhub.ForumHub.topicos;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        String Titulo,
        String Autor,
        String Curso,
        String Mensagem,
        String Status,
        LocalDateTime Data) {

    public DadosListagemTopico(TopicosCadastro topico) {
        this(topico.getTitulo(), topico.getAutor(), topico.getCurso(), topico.getMensagem(), topico.getStatus(), topico.getData());
    }
}