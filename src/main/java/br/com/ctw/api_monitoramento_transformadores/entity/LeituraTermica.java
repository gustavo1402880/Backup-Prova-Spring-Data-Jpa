package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Leitura Térmica - Entity
 *
 * <p>Camada de entity de {@link LeituraTermica},
 * responsável por armazenar os dados
 * da entidade e algumas regras de negócio
 * básicas</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
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

    @Column(name = "temp_oleo", nullable = false, scale = 2, precision = 5)
    private BigDecimal tempOleo;

    @Column(name = "temp_enrolamento", nullable = false, scale = 2, precision = 5)
    private BigDecimal tempEnrolamento;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transformador_id", nullable = false)
    private Transformador transformador;

    @OneToOne(mappedBy = "leitura", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AlertaTermico alerta;
}
