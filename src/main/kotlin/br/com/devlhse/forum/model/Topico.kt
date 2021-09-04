package br.com.devlhse.forum.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Topico (
        @Id @GeneratedValue(strategy = IDENTITY)
        var id : Long? = null,
        val titulo: String,
        val mensagem: String,
        val dataCriacao: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val curso: Curso,
        @ManyToOne
        val autor: Usuario,
        @Enumerated(value = STRING)
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
        @OneToMany(mappedBy = "topico")
        val respostas: List<Resposta> = ArrayList()
)