package br.unipar.SysContasBancarias.models;

import br.unipar.SysContasBancarias.enums.TipoTransferenciaEnum;
import java.time.LocalDateTime;

public class Transferencia {
    private double valor;
    private TipoTransferenciaEnum tipo;
    private LocalDateTime data = LocalDateTime.now();

    public Transferencia(double valor, TipoTransferenciaEnum tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public Transferencia() {
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoTransferenciaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransferenciaEnum tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "valor = " + valor + ", tipo = " + tipo.getDescricao() + ", data = " + data + '}';
    }

}
