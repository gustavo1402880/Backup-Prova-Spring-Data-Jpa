package br.com.ctw.api_monitoramento_transformadores.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "alerta_termico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlertaTermico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_alerta", nullable = false)
    private LocalDateTime dataAlerta = LocalDateTime.now();

    @Column(nullable = false, length = 30)
    private String tipo;

    @Column(nullable = false, length = 255)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transformador_id", nullable = false)
    private Transformador transformador;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leitura_id", nullable = false)
    private LeituraTermica leitura;
}
