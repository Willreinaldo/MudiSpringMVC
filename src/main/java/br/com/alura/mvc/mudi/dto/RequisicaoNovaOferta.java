package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Oferta;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequisicaoNovaOferta {

    private static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private Long pedidoId;

    @Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
    @NotNull
    private String valor;

    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    @NotNull
    private String localDate;

    private String comentario;

    public Long getPedidoId() {
        return pedidoId;
    }
    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Oferta toOferta() {
        Oferta oferta = new Oferta();

        oferta.setComentario(this.comentario);
        oferta.setLocalDate(LocalDate.parse(this.localDate, FORMATTER));
        oferta.setValor(new BigDecimal(this.valor));

        return oferta;
    }}
