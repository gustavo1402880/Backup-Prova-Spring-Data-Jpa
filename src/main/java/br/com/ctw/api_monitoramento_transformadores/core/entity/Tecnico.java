package br.com.ctw.api_monitoramento_transformadores.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Técnico - Entity
 *
 * <p>Camada de entity de {@link Tecnico},
 * responsável por armazenar os dados
 * da entidade e algumas regras de negócio
 * básicas</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
@Entity
@Table(name = "tecnico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String especialidade;

    @Column(nullable = false, length = 50)
    private String email;

    @ManyToMany(mappedBy = "tecnicos", fetch = FetchType.LAZY)
    private Set<Transformador> transformadores = new HashSet<>();
}
