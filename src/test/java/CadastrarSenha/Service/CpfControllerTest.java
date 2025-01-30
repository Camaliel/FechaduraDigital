package CadastrarSenha.Service;

import CadastrarSenha.Service.CpfController.CpfController;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.mockito.Mockito.*;

class CpfControllerTest {

    @Test
    void deveLerCpfCorretamente() {
        String cpfSimulado = "12345678900\n"; // Simula a digitação do CPF seguido de "Enter"
        ByteArrayInputStream inputSimulado = new ByteArrayInputStream(cpfSimulado.getBytes());

        CpfService cpfServiceMock = mock(CpfService.class);
        when(cpfServiceMock.verificaQuantidadeDigitadoCPF("12345678900")).thenReturn("12345678900");

        CpfController controller = new CpfController(cpfServiceMock, inputSimulado);
        controller.solicitarCpf(); // Executa sem precisar digitar manualmente

        verify(cpfServiceMock).verificaQuantidadeDigitadoCPF("12345678900");
    }
}


