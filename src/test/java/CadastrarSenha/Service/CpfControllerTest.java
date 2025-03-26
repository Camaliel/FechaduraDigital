package CadastrarSenha.Service;

import CadastrarSenha.Service.CpfController.CpfController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CpfControllerTest {
    private CpfController cpfController;
    private CpfService cpfServiceMock;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    void setUp() {
        cpfServiceMock = Mockito.mock(CpfService.class);
        System.setOut(new PrintStream(outContent)); // Redireciona o System.out
    }
    @AfterEach
    void tearDown() {
        System.setIn(System.in); // Restaura o System.in original
        System.setOut(originalOut); // Restaura o System.out original
    }

    @DisplayName("Solcita CPF valido")
    @Test
    void testSolicitarCpf_ComCpfValido() {
        // Simula a entrada de um CPF válido (11 dígitos)
        String input = "12345678901\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        cpfController = new CpfController(inputStream);
        String resultado = cpfController.solicitarCpf();

        assertEquals("12345678901", resultado);
    }

    @Test
    @DisplayName("Solcita CPF invalido")
    void testSolicitarCpf_ComEntradaVazia() {
        // Simula o usuário pressionando ENTER sem digitar nada
        String input = "\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        cpfController = new CpfController(inputStream);
        String resultado = cpfController.solicitarCpf();

        // Deve retornar uma string vazia, pois não há CPF válido
        assertEquals("", resultado);
        System.setIn(System.in);

    }
}