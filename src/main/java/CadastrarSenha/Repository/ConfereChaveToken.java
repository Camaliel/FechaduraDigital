package CadastrarSenha.Repository;

import CadastrarSenha.jdbc.EnviaToken;

import java.sql.SQLException;
import java.util.Scanner;

//TODO ANALISAR PARA APAGAR A CLASSE !!! [LEMBRETE]
public class ConfereChaveToken {

    EnviaToken token = new EnviaToken();
    IncluiToken incluiToken = new IncluiToken();

    public String validaChaveToken() throws SQLException, ClassNotFoundException {
        String valorGuardado = "";

        Scanner leia = new Scanner(System.in);
        System.out.println("token => " + incluiToken.incluiToken());
        System.out.print("DIGITE SEU NUMERO TOKEN ==> ");
        String valorDigitado = leia.nextLine();
            while (!token.consultaQuery().equals(valorDigitado)) {
                System.out.println(" TOKEN InVALIDO");
                System.out.print("DIGITE SEU NUMERO TOKEN ==> ");
                valorDigitado = leia.nextLine();
                break;
            }

            valorGuardado = valorDigitado;
            System.out.println(" TOKEN VALIDO GUARDADO");


        return valorGuardado;
    }
}