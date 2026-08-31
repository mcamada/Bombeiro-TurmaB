/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibirama.ifc.moduloalmoxarifado;

public class Item {

    String nome;
    String categoria;
    int quantidade;
    String unidade;
    String local;
    int nivelMinimo;
    private boolean selecionado;

    public Item(String nome, String categoria, int quantidade,
            String unidade, String local, int nivelMinimo) {

        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.local = local;
        this.nivelMinimo = nivelMinimo;
        this.selecionado = false;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

}
