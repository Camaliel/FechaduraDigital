package CadastrarSenha.jdbc;

import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnviaTokenTest {

    private EnviaToken enviaToken;
    private Connection conexaoMock;
    private PreparedStatement statementMock;

    @Before
    public void setup() throws SQLException {
        enviaToken = new EnviaToken(); // Inicializando o objeto aqui
        conexaoMock = mock(Connection.class);
        statementMock = mock(PreparedStatement.class);

        when(conexaoMock.prepareStatement(any(String.class))).thenReturn(statementMock);
    }

    @Test
    public void testEnviaToken() throws SQLException, ClassNotFoundException {
        // Mock dos dados necessários
        String valorToken = "tokenTeste";
        enviaToken.setValorToken(valorToken);

        // Chamando o método a ser testado
        String resultado = enviaToken.enviaToken();

        // Verificar se o token foi salvo corretamente
        assertEquals(valorToken, resultado);
    }
}
