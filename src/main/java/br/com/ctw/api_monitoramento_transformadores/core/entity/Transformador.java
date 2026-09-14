package br.com.ctw.api_monitoramento_transformadores.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Transformador - Entity
 *
 * <p>Camada de entity de {@link Transformador},
 * responsável por armazenar os dados
 * da entidade e algumas regras de negócio
 * básicas</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
@Entity
@Table(name = "transformador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transformador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_serie", length = 100, unique = true, nullable = false)
    private String numeroSerie;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false, length = 100)
    private String subestacao;

    @Column(name = "potencia_kva",nullable = false, scale = 2 ,precision = 10)
    private BigDecimal potenciaKva;

    @Column(name = "limite_temp_oleo", nullable = false, scale = 2, precision = 5)
    private BigDecimal limiteTempoOleo;

    @Column(name = "limite_temp_enrolamento", nullable = false, scale = 2, precision = 5)
    private BigDecimal limiteTempEnrol;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "transformador_tecnico",
            joinColumns = @JoinColumn(name = "transformador_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    )
    private Set<Tecnico> tecnicos = new HashSet<>();

    @OneToMany(mappedBy = "transformador", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlertaTermico> alertas = new HashSet<>();

    @OneToMany(mappedBy = "transformador", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LeituraTermica> leituras = new HashSet<>();
}
