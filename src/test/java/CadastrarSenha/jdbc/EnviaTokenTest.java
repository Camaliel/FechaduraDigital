package CadastrarSenha.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnviaTokenTest {

    private EnviaToken enviaToken;
    private Connection conexaoMock;
    private PreparedStatement statementMock;
    private ResultSet resultSetMock;

    @Before
    public void setup() {
        enviaToken = new EnviaToken();
    }

    @Test
    public void testEnviaToken() throws SQLException, ClassNotFoundException {
        // Inicializa as/os Classes/Mocks
        enviaToken = new EnviaToken();
        conexaoMock = mock(Connection.class);
        statementMock = mock(PreparedStatement.class);
        resultSetMock = mock(ResultSet.class); // Add ResultSet mock

        // Simula a interação do banco
        when(conexaoMock.prepareStatement(any(String.class))).thenReturn(statementMock);
        when(statementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true); // Assuming successful token save

        // Seta os valores
        String valorToken = "tokenTeste";
        enviaToken.setValorToken(valorToken);

        // Chama o metodo testado
        String resultado = enviaToken.enviaToken();

        // Verifica se o token foi salvo
        assertEquals(valorToken, resultado);
    }

    @Test
    public void testConsultaQuery_SuccessfulRetrieval() throws SQLException, ClassNotFoundException {
        // Inicializa as/os Classes/Mocks
        Connection connection = Mockito.mock(Connection.class);
        Statement statement = Mockito.mock(Statement.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);

        Mockito.when(statement.executeQuery("select * from tokens order by id desc limit 1")).thenReturn(resultSet);

        // Simula a interação do banco
        Mockito.when(resultSet.next()).thenReturn(true);
        Mockito.when(resultSet.getInt("id")).thenReturn(1);
        Mockito.when(resultSet.getString("token")).thenReturn("valid_token");

        // Chama o metodo testado
        EnviaToken consultaQuery = new EnviaToken();
        String token = consultaQuery.consultaQuery();

        // Verifica se retorna o valor salvo
        assertEquals("tokenTeste", token);
    }
}
