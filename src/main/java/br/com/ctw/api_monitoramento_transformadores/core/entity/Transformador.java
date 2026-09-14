package br.com.ctw.api_monitoramento_transformadores.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "potencia_kva",nullable = false, scale = 10 ,precision = 2)
    private Double potenciaKva;

    @Column(name = "limite_temp_oleo", nullable = false, scale = 5, precision = 2)
    private Double limiteTempoOleo;

    @Column(name = "limite_temp_enrolamento", nullable = false, scale = 5, precision = 2)
    private Double limiteTempEnrol;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tranformador_tecnico",
            joinColumns = @JoinColumn(name = "tranformador_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    )
    private Set<Tecnico> tecnicos = new HashSet<>();

    @OneToMany(mappedBy = "transformador", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlertaTermico> alertas = new HashSet<>();

    @OneToMany(mappedBy = "transformador", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LeituraTermica> leituras = new HashSet<>();
}
