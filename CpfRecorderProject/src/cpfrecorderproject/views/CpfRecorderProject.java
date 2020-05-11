package cpfrecorderproject.views;

/**
 * Este Projeto registra os dados de uma pessoa (nome, sobrenome, idade, sexo, cpf) e
 * os slava permanentemente em uma arquivo ".txt". Também é possível pesquisar e visualizar
 * os dados de uma pessoa pelo CPF em outra janela.
 * @author felipe
 */
public class CpfRecorderProject {
    public static void main(String[] args) {
        JanelaRegistro jr = new JanelaRegistro();
        jr.setVisible(true);
    }
}
