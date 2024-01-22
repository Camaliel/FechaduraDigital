package CadastrarSenha.Repository;

import CadastrarSenha.Processor.MenuProcessor;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import CadastrarSenha.jdbc.IncluirPessoa;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;

public class incluirPessoaRepository {
    VarFamiliar varFamiliar = new VarFamiliar();
    IncluirPessoa incluirPessoa = new IncluirPessoa();
    Menu menu = new Menu();
    public void armazenaPessoaBanco() throws SQLException, TelegramApiException {
                incluirPessoa.incluirPessoaFamilia();

        }
    }

