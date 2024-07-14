package br.com.forumhub.ForumHub.topicos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "TopicosForum")
@Table(name = "topicosforum")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TopicosCadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensagem;
    @NotNull
    private LocalDateTime data;
    @NotBlank
    private String status;
    @NotBlank
    private String autor;
    @NotBlank
    private String curso;

    public TopicosCadastro(DadosCadastroTopico json) {
        this.titulo = json.titulo();
        this.mensagem = json.mensagem();
        this.data = LocalDateTime.now();
        this.status = json.status();
        this.autor = json.autor();
        this.curso = json.curso();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDateTime getData() {
        data = LocalDateTime.now();
        return data;
    }

    public void setData(LocalDateTime data) {
        data = LocalDateTime.now();
        this.data = data;
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico topico) {
        if (topico.titulo() != null) {
            this.titulo = topico.titulo();
        }

        if (topico.mensagem() != null) {
            this.mensagem = topico.mensagem();
        }

        if (topico.status() != null) {
            this.status = topico.status();
        }

        if (topico.curso() != null) {
            this.curso = topico.curso();
        }

        if (topico.autor() != null) {
            this.autor = topico.autor();
        }

        if (topico.data() != LocalDateTime.now()) {
            this.data = LocalDateTime.now();
        }
    }
}