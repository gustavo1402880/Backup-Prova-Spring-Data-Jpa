package br.com.ctw.api_monitoramento_transformadores.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "leitura_termica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeituraTermica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "temp_oleo", nullable = false, scale = 5, precision = 2)
    private Double tempOleo;

    @Column(name = "temp_enrolamento", nullable = false, scale = 5, precision = 2)
    private Double tempEnrolamento;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transformador_id", nullable = false)
    private Transformador transformador;

    @OneToOne(mappedBy = "leitura", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AlertaTermico alerta;
}
