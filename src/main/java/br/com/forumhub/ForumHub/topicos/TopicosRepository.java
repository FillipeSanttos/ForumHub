package br.com.forumhub.ForumHub.topicos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicosRepository extends JpaRepository<TopicosCadastro, Long> {
}