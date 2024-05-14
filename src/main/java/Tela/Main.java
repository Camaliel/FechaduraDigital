package Tela;


import CadastrarSenha.Processor.MenuProcessor;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;

public class    Main {
    public static void main(String[] args) throws TelegramApiException, SQLException, ClassNotFoundException {
        MenuProcessor process = new MenuProcessor();
        process.menuPrincipal();
    }

}