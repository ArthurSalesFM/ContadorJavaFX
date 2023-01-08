package Janela;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Janela extends Application {

	private int contador = 0;

	// box principal, armazenará todos os demais componentes
	private VBox boxPrincipal = new VBox();

	// caixa hotizontal para organizar os botões
	private HBox boxBotoes = new HBox();

	// título da aplicação
	private Label labelTitulo = new Label("Contador");
	// valor que sera mostrado na tela
	private Label labelNumero = new Label(contador + "");

	// criando os botões
	private Button botaoDecremento = new Button("-");
	private Button botaoIncremento = new Button("+");

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Contador Art");

		// passando os dados css da classe titulo
		this.labelTitulo.getStyleClass().add("titulo");

		// passando os dados css da classe numero
		this.labelNumero.getStyleClass().add("numero");

		// passando os dados do css da classe botoes
		this.botaoDecremento.getStyleClass().add("botoes");

		// passando os dados do css da classe botoes
		this.botaoIncremento.getStyleClass().add("botoes");

		// quando clicar no botão -, será decrementado o valor que se encontra na
		// labelNumero
		this.botaoDecremento.setOnAction(e -> {
			this.contador--;
			this.atualizarLabelNumero(this.labelNumero);
		});

		this.botaoIncremento.setOnAction(e -> {
			this.contador++;
			this.atualizarLabelNumero(this.labelNumero);
		});

		// alinhando a caixa no centro
		this.boxBotoes.setAlignment(Pos.CENTER);

		// espaço entre botoes
		this.boxBotoes.setSpacing(30);

		// adicionando os botoes a sua caixa
		this.boxBotoes.getChildren().add(botaoDecremento);
		this.boxBotoes.getChildren().add(botaoIncremento);

		// definindo a cor de fungo atraves do arquivo css
		this.boxPrincipal.getStyleClass().add("conteudo");

		// alinhamento, posição no centro
		this.boxPrincipal.setAlignment(Pos.CENTER);

		// espaço entre botoes
		this.boxPrincipal.setSpacing(10);

		// adicionando os componentes no boxprincipal
		this.boxPrincipal.getChildren().add(labelTitulo);
		this.boxPrincipal.getChildren().add(labelNumero);
		this.boxPrincipal.getChildren().add(this.boxBotoes);

		// utilizando o arquivo css
		String caminhoDoCSS = getClass().getResource("/Janela/Contador.css").toExternalForm();

		// criando a cena
		Scene cenaPrincipal = new Scene(this.boxPrincipal, 400, 400);

		// arquivos css
		cenaPrincipal.getStylesheets().add(caminhoDoCSS);
		// dfinindo a fonte do texto
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");

		// passando a cena pro palco
		primaryStage.setScene(cenaPrincipal);

		primaryStage.show();
	}

	private void atualizarLabelNumero(Label label) {

		label.setText(Integer.toString(this.contador));
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");
		label.getStyleClass().remove("branco");

		if (this.contador == 0) {
			label.getStyleClass().add("branco");
		} else if (this.contador > 0) {
			label.getStyleClass().add("verde");
		} else {
			label.getStyleClass().add("vermelho");
		}
	}

}
