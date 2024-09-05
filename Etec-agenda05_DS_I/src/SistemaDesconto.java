import javax.swing.JOptionPane;

public class SistemaDesconto {

	/*
	 * Classe principal para o codigo do sistema de Desconto Progressivo da Agenda 5
	 * de D.S
	 * 
	 * Regras do Desconto:
	 * -----------------------------------------------------------------------------
	 * ---------------------------- .Se o valor total da compra for menor do que R$
	 * 200,00, o cliente recebe um desconto de 5%. .Se o valor total da compra for
	 * maior ou igual a R$ 200,00 e menor que R$ 300,00, o cliente recebe um
	 * desconto de 10%. .Se o valor total da compra for maior ou igual a R$ 300,00,
	 * o cliente recebe um desconto de 15%.
	 * -----------------------------------------------------------------------------
	 * ----------------------------
	 */

	public static void main(String[] args) {

		//definindo as variaveis
		final double desconto5 = 0.05;
		final double desconto10 = 0.10;
		final double desconto15 = 0.15;
		double valorCompra;
		double desconto = 0;
		double valorDesconto;
		String mensagemDesconto = "O total de desconto foi de: R$ ";
		String mensagemTotal = " e o valor total a ser pago é de: R$ ";
		double totalCompra = 0;

		//mensagem de apresentação do programa
		JOptionPane.showMessageDialog(null, "Tenha otimas Compras!", "JOJA ONLINE", JOptionPane.INFORMATION_MESSAGE);

		//while vinculado a um tratamento de erro para confirmar as entradas do usuario
		while (true) {
			
			try {
				valorCompra = Double
						.parseDouble(JOptionPane.showInputDialog(null, "Por favor entre com o valor total da compra:",
								"Valor da Compra", JOptionPane.INFORMATION_MESSAGE).replace(",", "."));
				//caso nada esteja errado ele quebra o loop do while e da sequencia ao programa
				break;
				
				//tratamento para que só seja aceito numeros 
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, digite um valor numérico válido.",
						"Erro", JOptionPane.ERROR_MESSAGE);
				
				//tratamento para caso o usuario saia do programa com ele aberto sem digitar a entrada numerica
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Por favor digite o valor total da compra para Prosseguir!",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
		}

		//calculo dos valores e chamada do metodo para calcular o desconto
			desconto = calculoDesconto(valorCompra, desconto5, desconto10, desconto15);
			valorDesconto = valorCompra * desconto;
			totalCompra = valorCompra - valorDesconto;

		//chamada do metodo da mensagem final
			mensagemFinal(valorCompra, valorDesconto, totalCompra);

		}


	//metodo para chamar a Mensagem final ao usuario 
	static void mensagemFinal(double valorCompra, double valorDesconto, double totalCompra) {
		
		JOptionPane.showMessageDialog(null,
				String.format("Valor da compra: R$ %.2f\n", valorCompra)
						+ String.format("Desconto: R$ %.2f\n", valorDesconto)
						+ String.format("Valor total a pagar: R$ %.2f\n", totalCompra)
						+ "\n"
						+ "OBRIGADO E VOLTE SEMPRE!!",
				"Detalhes da Compra", JOptionPane.INFORMATION_MESSAGE);
	}
	

	//metodo criado para calcular os descontos e deixar o codigo limpo e organizado
	static double calculoDesconto(double valorCompra, double desconto5, double desconto10, double desconto15) {

		if (valorCompra < 200) {
			return desconto5;
		}
		if (valorCompra >= 200 && valorCompra < 300) {
			return desconto10;
		}
		if (valorCompra >= 300) {
			return desconto15;
		} else {
			return 0;
		}
	}

}
