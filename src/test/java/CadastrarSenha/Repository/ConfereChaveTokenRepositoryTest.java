package CadastrarSenha.Repository;

import CadastrarSenha.Service.GeradorDeChaveTokenService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConfereChaveTokenRepositoryTest {

    @Mock
    private IncluiTokenRepository incluiTokenRepository;

    @Mock
    private GeradorDeChaveTokenService geradorDeChaveTokenService;

    private ConfereChaveTokenRepository confereChaveTokenRepository;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        confereChaveTokenRepository = new ConfereChaveTokenRepository(incluiTokenRepository, geradorDeChaveTokenService);
        System.setOut(new PrintStream(outContent)); // Redireciona o System.out
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in); // Restaura o System.in original
        System.setOut(originalOut); // Restaura o System.out original
    }

    @Test
    void testValidaChaveToken_ComEntradaValida() throws Exception {
        // Arrange
        String tokenEsperado = "123456";
        when(geradorDeChaveTokenService.getPegaToken()).thenReturn(tokenEsperado);

        // Simula entrada do usuário
        System.setIn(new ByteArrayInputStream("123456\n".getBytes()));

        // Act
        String resultado = confereChaveTokenRepository.validaChaveToken();

        // Assert
        assertEquals(tokenEsperado, resultado);
    }

    @Test
    void testValidaChaveToken_ComEntradaInvalidaSeguidaDeEntradaValida() throws Exception {
        // Arrange
        String tokenEsperado = "123456";
        when(geradorDeChaveTokenService.getPegaToken()).thenReturn(tokenEsperado);

        // Simula entrada inválida seguida de entrada válida
        System.setIn(new ByteArrayInputStream("000000\n123456\n".getBytes()));

        // Act
        String resultado = confereChaveTokenRepository.validaChaveToken();

        // Assert
        assertEquals(tokenEsperado, resultado);
    }
}