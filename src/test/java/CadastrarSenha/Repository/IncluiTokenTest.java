package CadastrarSenha.Repository;

import CadastrarSenha.Service.ChaveToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class IncluiTokenTest {

    private IncluiToken incluiToken;
    private Connection conexaoMock;
    private PreparedStatement statementMock;
    private ChaveToken chaveToken;


    @Test
    public void deveRetornarQuery() throws SQLException {
        conexaoMock = mock(Connection.class);
        statementMock = mock(PreparedStatement.class);

        // Mocke o método prepareStatement para retornar o PreparedStatement mockado
        Mockito.when(conexaoMock.prepareStatement(any(String.class))).thenReturn(statementMock);

        String teste = incluiToken.incluiToken();

        assertEquals(incluiToken, teste);


//        assertEquals("Numero enviado ==> " + new ChaveToken().getPegaToken(), tokenGerado);
    }
}