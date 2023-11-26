package digital.project.bookstorejava.negocio;

import digital.project.bookstorejava.basedados.Banco;
import digital.project.bookstorejava.entidade.Cupom;
import digital.project.bookstorejava.entidade.Pedido;
import digital.project.bookstorejava.entidade.Produto;

import java.util.List;


public class PedidoNegocio {


    private Banco bancoDados;

    public PedidoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    private double calcularTotal(List<Produto> produtos, Cupom cupom) {

        double total = 0.0;
        for (Produto produto: produtos) {
            total += produto.calcularFrete();
        }
        if (cupom != null) {
            return  total * (1 - cupom.getDesconto());
        } else {
            return  total;
        }
    }
    public void salvar(Pedido novoPedido) {
        salvar(novoPedido, cupom:null);
    }

    public void salvar(Pedido novoPedido, Cupom cupom) {

        String codigo = "PE%4d%2d%04d";
        LocalDate hoje = LocalDate.now();
        codigo = String.format(codigo, hoje.getYear(), hoje.getMonthValue(), bancoDados.getPedidos().length);

        novoPedido.setCodigo(codigo);
        novoPedido.setCliente(bancoDados.getCliente());
        novoPedido.setTotal(calcularTotal(novoPedido.getProdutos(), cupom));
        bancoDados.adicionarPedido(novoPedido);
        System.out.println("Pedido cadastrado com sucesso.");
    }

    public void excluir(String codigo) {

        int pedidoExclusao = -1;
        for (int i = 0; i < bancoDados.getPedidos().length; i++) {

            Pedido pedido = bancoDados.getPedidos()[i];
            if (pedido.getCodigo().equals(codigo)) {
                pedidoExclusao = i;
                break;
            }
        }
        if (pedidoExclusao != -1) {
            bancoDados.removerPedido(pedidoExclusao);
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }
    }
        public void salvar(Pedido novoPedido, Cupom cupom) {

            String codigo = "PE%4d%2d%04d";
            LocalDate hoje = LocalDate.now();
            codigo = String.format(codigo, hoje.getYear(), hoje.getMonthValue(), bancoDados.getPedidos().length);

            novoPedido.setCodigo(codigo);
            novoPedido.setCliente(bancoDados.getCliente());
            novoPedido.setTotal(calcularTotal(novoPedido.getProdutos(), cupom));
            bancoDados.adicionarPedido(novoPedido);
            System.out.println("Pedido cadastrado com sucesso.");
    }
        public void excluir(String codigo) {

            int pedidoExclusao = -1;
            for (int i = 0; i < bancoDados.getPedidos().length; i++) {

                Pedido pedido = bancoDados.getPedidos()[i];
                if (pedido.getCodigo().equals(codigo)) {
                    pedidoExclusao = i;
                    break;
                }
            }

            if (pedidoExclusao != -1) {
                bancoDados.removerPedido(pedidoExclusao);
                System.out.println("Pedido excluído com sucesso.");
            } else {
                System.out.println("Pedido inexistente.");
            }
        }