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

        System.out.println("SEU NUMERO TOKEN ==> "+ incluiToken.incluiToken());
        System.out.print("DIGITE SEU NUMERO TOKEN ==> ");
        String valorDigitado = leia.nextLine();
        while (!token.consultaQuery().equals(valorDigitado)) {
            System.out.println("SEU NUMERO TOKEN ==> "+ incluiToken.incluiToken());

            System.out.println(" TOKEN InVALIDO");
            System.out.print("DIGITE SEU NUMERO TOKEN ==> ");
            valorDigitado = leia.nextLine();
        }
                valorGuardado = valorDigitado;
        System.out.println(" TOKEN VALIDO GUARDADO");


            return valorGuardado;
        }
    }