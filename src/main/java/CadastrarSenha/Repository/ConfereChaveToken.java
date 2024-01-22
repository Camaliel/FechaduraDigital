package CadastrarSenha.Repository;

import CadastrarSenha.Service.ChaveToken;
import CadastrarSenha.Util.Variavel.ValoresDigitados;
import CadastrarSenha.jdbc.EnviaToken;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;
import java.util.Scanner;

//TODO ANALISAR PARA APAGAR A CLASSE !!! [LEMBRETE]
public class ConfereChaveToken {

    ValoresDigitados valoresDigitados = new ValoresDigitados();
    ChaveToken chaveToken = new ChaveToken();
    EnviaToken token = new EnviaToken();
    IncluiToken incluiToken = new IncluiToken();
    incluirPessoaRepository pessoaRepository = new incluirPessoaRepository();

    Scanner leia = new Scanner(System.in);

    public String validaChaveToken() throws SQLException, TelegramApiException {
        String valorGuardado = "";

        System.out.println("SEU NUMERO TOKEN ==> "+ token.consultaQuery());
        String valorDigitado= leia.nextLine();
        if (token.consultaQuery().equals(valorDigitado)){
            valorGuardado = valorDigitado;
            pessoaRepository.armazenaPessoaBanco(); // TODO TROCAR PARA QUARIES SEPARADA [HA FAZER]


            System.out.println(" TOKEN VALIDO GUARDADO");
            System.out.println("Enviando para o banco");
        }else {
            System.out.println("Token invalido");
        }

        return valorGuardado;
    }
}