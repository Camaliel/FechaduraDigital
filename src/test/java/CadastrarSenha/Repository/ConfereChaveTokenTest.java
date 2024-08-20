package CadastrarSenha.Repository;

import CadastrarSenha.jdbc.EnviaToken;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConfereChaveTokenTest {

    @InjectMocks
    ConfereChaveToken confereChaveToken;

    @Mock
    EnviaToken enviaToken;

    @Mock
    IncluiToken incluiToken;


//    private IncluiToken incluiToken;
    private Connection conexaoMock;
    private PreparedStatement statementMock;
    private ResultSet resultSetMock;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        confereChaveToken = new ConfereChaveToken();
        // Aqui você deve injetar mocks nas dependências, dependendo de como a classe é estruturada
        confereChaveToken.token = enviaToken;
//        confereChaveToken.incluiToken = incluiToken;
        incluiToken.incluiToken();
    }

    @Test
    public void validaChaveTokenComSucesso() throws SQLException, ClassNotFoundException {
        // Inicializa as Classes/Mocks
        when(enviaToken.consultaQuery()).thenReturn("000000");

        // simula a entrada do usuário, podemos usar System.setIn
        String saida = "000000"; // O token válido esperado
        System.setIn(new java.io.ByteArrayInputStream(saida.getBytes()));

        // Chama metodo testado
        String resultado = confereChaveToken.validaChaveToken();

        Assert.assertEquals("000000",resultado);
    }
    @Test
    public void validaChaveTokenSemSucesso() throws SQLException, ClassNotFoundException {
        when(enviaToken.consultaQuery()).thenReturn("teste");
        String saida = "0000\n0000\n0000"; // TODO investigar porque tem dois valores
        System.setIn(new java.io.ByteArrayInputStream(saida.getBytes()));

        String resultado = confereChaveToken.validaChaveToken();

        Assert.assertNotEquals("teste",resultado);
    }
}