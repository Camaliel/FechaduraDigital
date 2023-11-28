package CadastrarSenha.Service;

import CadastrarSenha.Enum.MensagemEnum;
import CadastrarSenha.Service.Interface.NumeroCelularImpl;
import CadastrarSenha.Util.Variavel.InfoUsuario;

import java.util.Scanner;

public class NumeroCelularService implements NumeroCelularImpl {

    @Override
    public String adicionaNumero(String numeroCelular) {
        InfoUsuario infoUsuario = new InfoUsuario();
        Scanner leia = new Scanner(System.in);

        System.out.println(MensagemEnum.INSIRA_NUMERO.getDescricao());
        String numero = leia.nextLine();

        String numeroCelularValido = infoUsuario.getNumeroCelular();

        while (numero.length() != 9) {

            if (numero.length() != 9) {
                System.out.println(MensagemEnum.N_VALIDO.getDescricao());
                numero = leia.nextLine();
            }
        }
        if (numero.length() == 9) {
            System.out.println(MensagemEnum.NUMERO_SUCESSO.getDescricao());
            infoUsuario.setNumeroCelular(numero);
            System.out.println(numero + " " + MensagemEnum.N_ADICIONADO.getDescricao());

        }

        return numeroCelularValido;

    }


}
