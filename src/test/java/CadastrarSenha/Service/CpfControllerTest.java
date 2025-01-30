package CadastrarSenha.Service;

import CadastrarSenha.Service.CpfController.CpfController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

    class CpfControllerTest {
        private CpfController cpfController;
        private CpfService cpfServiceMock;

        @BeforeEach
        void setUp() {
            cpfServiceMock = Mockito.mock(CpfService.class);
        }

        @Test
        void testSolicitarCpf_ComCpfValido() {
            // Simula a entrada de um CPF válido (11 dígitos)
            String input = "12345678901\n";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());

            cpfController = new CpfController(cpfServiceMock, inputStream);
            String resultado = cpfController.solicitarCpf();

            assertEquals("12345678901", resultado);
        }

        @Test
        void testSolicitarCpf_ComEntradaVazia() {
            // Simula o usuário pressionando ENTER sem digitar nada
            String input = "\n";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());

            cpfController = new CpfController(cpfServiceMock, inputStream);
            String resultado = cpfController.solicitarCpf();

            // Deve retornar uma string vazia, pois não há CPF válido
            assertEquals("", resultado);
            System.setIn(System.in);

        }
    }