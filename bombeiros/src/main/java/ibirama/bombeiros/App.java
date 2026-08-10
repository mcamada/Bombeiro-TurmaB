package ibirama.bombeiros;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import static javafx.application.Application.launch;

public class App extends Application {

    private final BombeiroService service = new BombeiroService();
    private StackPane contentArea;
    private DashboardView dashboardView;
    private BombeiroFormView formView;
    private BombeiroListView listView;

    private static final String ICON_HOME = "M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z";
    private static final String ICON_ADD = "M15 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm-9-2V7H4v3H1v2h3v3h2v-3h3v-2H6zm9 4c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z";
    private static final String ICON_LIST = "M3 13h2v-2H3v2zm0 4h2v-2H3v2zm0-8h2V7H3v2zm4 4h14v-2H7v2zm0 4h14v-2H7v2zM7 7v2h14V7H7z";

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-font-family: 'Segoe UI', sans-serif; -fx-background-color: #f8fafc;");

        SidebarMenu sidebar = new SidebarMenu();
        sidebar.addItem("dashboard", "Dashboard", ICON_HOME);
        sidebar.addItem("cadastro", "Cadastrar Bombeiro", ICON_ADD);
        sidebar.addItem("consulta", "Consultar Bombeiros", ICON_LIST);
        sidebar.setOnSelect(this::navegar);

        contentArea = new StackPane();
        contentArea.setStyle("-fx-background-color: #f1f5f9;");
        contentArea.setAlignment(Pos.TOP_LEFT);

        dashboardView = new DashboardView(service);
        formView = new BombeiroFormView(service, v -> dashboardView = new DashboardView(service));
        listView = new BombeiroListView(service, this::abrirEdicao);

        root.setLeft(sidebar);
        root.setCenter(contentArea);

        Label topTitle = new Label("Sistema de Gestão de Pessoal - Corpo de Bombeiros");
        topTitle.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        BorderPane topBar = new BorderPane();
        topBar.setStyle("-fx-background-color: #0f172a;");
        topBar.setLeft(topTitle);
        topBar.setPadding(new Insets(12, 20, 12, 20));
        root.setTop(topBar);

        Scene scene = new Scene(root, 1100, 700);
        stage.setTitle("Gestão de Pessoal - Bombeiros");
        stage.setScene(scene);
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.show();

        sidebar.selectFirst();
    }

    private void navegar(String id) {
        contentArea.getChildren().clear();
        switch (id) {
            case "dashboard":
                dashboardView = new DashboardView(service);
                contentArea.getChildren().add(dashboardView);
                break;
            case "cadastro":
                formView.prepararNovo();
                contentArea.getChildren().add(formView);
                break;
            case "consulta":
                listView.refresh();
                contentArea.getChildren().add(listView);
                break;
            default:
                contentArea.getChildren().add(new Label("Tela não encontrada"));
                break;
        }
    }

    private void abrirEdicao(Bombeiro b) {
        formView.prepararEdicao(b);
        contentArea.getChildren().clear();
        contentArea.getChildren().add(formView);
    }

    public enum StatusBombeiro {
        ATIVO("Ativo"),
        AFASTADO("Afastado"),
        INATIVO("Inativo");

        private final String label;
        StatusBombeiro(String label) { this.label = label; }
        public String getLabel() { return label; }
        @Override public String toString() { return label; }
    }

    public enum Patente {
        SOLDADO("Soldado", 1), CABO("Cabo", 2), SARGENTO("Sargento", 3),
        SUBTENENTE("Subtenente", 4), TENENTE("Tenente", 5), CAPITAO("Capitão", 6),
        MAJOR("Major", 7), CORONEL("Coronel", 8);

        private final String nome;
        private final int nivel;
        Patente(String nome, int nivel) { this.nome = nome; this.nivel = nivel; }
        public String getNome() { return nome; }
        public int getNivel() { return nivel; }
        @Override public String toString() { return nome; }
    }

    public enum Especialidade {
        COMBATE_INCENDIO("Combate a Incêndio"), RESGATE("Resgate"),
        ATENDIMENTO_PRE_HOSPITALAR("Atendimento Pré-Hospitalar"), MERGULHO("Mergulho"),
        CAO_FAREJADOR("Cão Farejador"), BUSCA_E_SALVAMENTO("Busca e Salvamento"),
        OPERACOES_AEREAS("Operações Aéreas"), OUTRO("Outro");

        private final String nome;
        Especialidade(String nome) { this.nome = nome; }
        public String getNome() { return nome; }
        @Override public String toString() { return nome; }
    }

    public static class Bombeiro {
        private String id;
        private String nome;
        private String cpf;
        private String matricula;
        private LocalDate dataNascimento;
        private Patente patente;
        private Especialidade especialidade;
        private String contato;
        private StatusBombeiro status;

        public Bombeiro() {
            this.id = UUID.randomUUID().toString();
            this.status = StatusBombeiro.ATIVO;
        }

        public Bombeiro(String nome, String cpf, String matricula, LocalDate dataNascimento,
                        Patente patente, Especialidade especialidade, String contato, StatusBombeiro status) {
            this();
            this.nome = nome;
            this.cpf = cpf;
            this.matricula = matricula;
            this.dataNascimento = dataNascimento;
            this.patente = patente;
            this.especialidade = especialidade;
            this.contato = contato;
            this.status = status;
        }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
        public String getCpf() { return cpf; }
        public void setCpf(String cpf) { this.cpf = cpf; }
        public String getMatricula() { return matricula; }
        public void setMatricula(String matricula) { this.matricula = matricula; }
        public LocalDate getDataNascimento() { return dataNascimento; }
        public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
        public Patente getPatente() { return patente; }
        public void setPatente(Patente patente) { this.patente = patente; }
        public Especialidade getEspecialidade() { return especialidade; }
        public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }
        public String getContato() { return contato; }
        public void setContato(String contato) { this.contato = contato; }
        public StatusBombeiro getStatus() { return status; }
        public void setStatus(StatusBombeiro status) { this.status = status; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bombeiro bombeiro = (Bombeiro) o;
            return Objects.equals(id, bombeiro.id);
        }

        @Override public int hashCode() { return Objects.hash(id); }
    }

    public static class BombeiroService {
        private final ObservableList<Bombeiro> bombeiros = FXCollections.observableArrayList();
        private final FilteredList<Bombeiro> filteredBombeiros;

        public BombeiroService() {
            this.filteredBombeiros = new FilteredList<>(bombeiros, p -> true);
            carregarDadosIniciais();
        }

        private void carregarDadosIniciais() {
            bombeiros.add(new Bombeiro("Carlos Eduardo Silva", "123.456.789-00", "BM001",
                    LocalDate.of(1985, 3, 15), Patente.SARGENTO, Especialidade.COMBATE_INCENDIO,
                    "(11) 98765-4321", StatusBombeiro.ATIVO));
            bombeiros.add(new Bombeiro("Ana Paula Ferreira", "987.654.321-00", "BM002",
                    LocalDate.of(1990, 7, 22), Patente.CABO, Especialidade.RESGATE,
                    "(11) 91234-5678", StatusBombeiro.ATIVO));
            bombeiros.add(new Bombeiro("João Pedro Santos", "456.789.123-00", "BM003",
                    LocalDate.of(1988, 11, 5), Patente.SOLDADO, Especialidade.ATENDIMENTO_PRE_HOSPITALAR,
                    "(11) 99876-5432", StatusBombeiro.AFASTADO));
        }

        public ObservableList<Bombeiro> getBombeiros() { return bombeiros; }
        public FilteredList<Bombeiro> getFilteredBombeiros() { return filteredBombeiros; }

        public void setFiltro(String nome, Patente patente, StatusBombeiro status) {
            filteredBombeiros.setPredicate(b -> {
                if (nome != null && !nome.isBlank()) {
                    if (b.getNome() == null || !b.getNome().toLowerCase().contains(nome.toLowerCase())) return false;
                }
                if (patente != null && b.getPatente() != patente) return false;
                if (status != null && b.getStatus() != status) return false;
                return true;
            });
        }

        public void limparFiltro() { filteredBombeiros.setPredicate(p -> true); }

        public Optional<String> validar(Bombeiro b, boolean isNovo) {
            if (b.getNome() == null || b.getNome().isBlank()) return Optional.of("Nome completo é obrigatório.");
            if (b.getCpf() == null || b.getCpf().isBlank()) return Optional.of("CPF é obrigatório.");
            if (b.getMatricula() == null || b.getMatricula().isBlank()) return Optional.of("Matrícula é obrigatória.");
            if (isNovo) {
                boolean existe = bombeiros.stream().anyMatch(x -> x.getMatricula().equalsIgnoreCase(b.getMatricula()));
                if (existe) return Optional.of("Já existe um bombeiro cadastrado com esta matrícula.");
            }
            return Optional.empty();
        }

        public void salvar(Bombeiro b, boolean isNovo) {
            if (isNovo) {
                bombeiros.add(b);
            } else {
                for (int i = 0; i < bombeiros.size(); i++) {
                    if (bombeiros.get(i).getId().equals(b.getId())) {
                        bombeiros.set(i, b);
                        break;
                    }
                }
            }
        }

        public void excluir(Bombeiro b) { bombeiros.remove(b); }
    }

    public static class SidebarMenu extends VBox {
        private final Map<String, Button> items = new HashMap<>();
        private Consumer<String> onSelectListener;
        private String selectedId = null;

        public SidebarMenu() {
            this.setStyle("-fx-background-color: #1e293b; -fx-padding: 15px;");
            this.setSpacing(8);
            this.setPrefWidth(240);
        }

        public void addItem(String id, String label, String svgIconPath) {
            Button btn = new Button(label);
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #94a3b8; -fx-font-size: 14px; -fx-padding: 10 15; -fx-cursor: hand;");
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setAlignment(Pos.CENTER_LEFT);

            if (svgIconPath != null && !svgIconPath.isEmpty()) {
                SVGPath icon = new SVGPath();
                icon.setContent(svgIconPath);
                icon.setStyle("-fx-fill: #94a3b8;");
                btn.setGraphic(icon);
            }

            btn.setOnAction(e -> select(id));
            items.put(id, btn);
            this.getChildren().add(btn);
        }

        public void setOnSelect(Consumer<String> listener) { this.onSelectListener = listener; }

        public void select(String id) {
            if (items.containsKey(id)) {
                if (selectedId != null && items.containsKey(selectedId)) {
                    items.get(selectedId).setStyle("-fx-background-color: transparent; -fx-text-fill: #94a3b8; -fx-font-size: 14px; -fx-padding: 10 15; -fx-cursor: hand;");
                }
                selectedId = id;
                items.get(id).setStyle("-fx-background-color: #2563eb; -fx-text-fill: #ffffff; -fx-font-size: 14px; -fx-padding: 10 15; -fx-cursor: hand;");
                if (onSelectListener != null) onSelectListener.accept(id);
            }
        }

        public void selectFirst() {
            if (!items.isEmpty()) select(items.keySet().iterator().next());
        }
    }

    public static class DashboardView extends VBox {
        public DashboardView(BombeiroService service) {
            this.setSpacing(20);
            this.setPadding(new Insets(20));

            Label title = new Label("Painel Geral");
            title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

            long total = service.getBombeiros().size();
            long ativos = service.getBombeiros().stream().filter(b -> b.getStatus() == StatusBombeiro.ATIVO).count();
            long afastados = service.getBombeiros().stream().filter(b -> b.getStatus() == StatusBombeiro.AFASTADO).count();
            long inativos = service.getBombeiros().stream().filter(b -> b.getStatus() == StatusBombeiro.INATIVO).count();

            GridPane grid = new GridPane();
            grid.setHgap(15);
            grid.setVgap(15);

            grid.add(criarCard("Total de Efetivo", String.valueOf(total), "#2563eb"), 0, 0);
            grid.add(criarCard("Bombeiros Ativos", String.valueOf(ativos), "#16a34a"), 1, 0);
            grid.add(criarCard("Afastados", String.valueOf(afastados), "#ca8a04"), 0, 1);
            grid.add(criarCard("Inativos", String.valueOf(inativos), "#dc2626"), 1, 1);

            this.getChildren().addAll(title, grid);
        }

        private VBox criarCard(String titulo, String valor, String borderColor) {
            VBox card = new VBox(5);
            card.setStyle("-fx-padding: 15px; -fx-background-radius: 8px; -fx-background-color: #ffffff; -fx-border-color: " + borderColor + "; -fx-border-width: 0 0 0 4px;");
            card.setPrefSize(220, 100);

            Label lblTitulo = new Label(titulo);
            lblTitulo.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");

            Label lblValor = new Label(valor);
            lblValor.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

            card.getChildren().addAll(lblTitulo, lblValor);
            return card;
        }
    }

    public static class BombeiroFormView extends VBox {
        private final BombeiroService service;
        private final Consumer<Void> onSaveSuccess;
        private Bombeiro bombeiroAtual;
        private boolean ehEdicao = false;

        private final Label titleLabel = new Label();
        private final TextField txtNome = new TextField();
        private final TextField txtCpf = new TextField();
        private final TextField txtMatricula = new TextField();
        private final DatePicker dpDataNascimento = new DatePicker();
        private final ComboBox<Patente> cbPatente = new ComboBox<>();
        private final ComboBox<Especialidade> cbEspecialidade = new ComboBox<>();
        private final TextField txtContato = new TextField();
        private final ComboBox<StatusBombeiro> cbStatus = new ComboBox<>();

        public BombeiroFormView(BombeiroService service, Consumer<Void> onSaveSuccess) {
            this.service = service;
            this.onSaveSuccess = onSaveSuccess;
            this.setSpacing(20);
            this.setPadding(new Insets(20));

            titleLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

            cbPatente.getItems().setAll(Patente.values());
            cbEspecialidade.getItems().setAll(Especialidade.values());
            cbStatus.getItems().setAll(StatusBombeiro.values());

            GridPane grid = new GridPane();
            grid.setHgap(15);
            grid.setVgap(12);

            grid.add(new Label("Nome Completo:"), 0, 0); grid.add(txtNome, 1, 0);
            grid.add(new Label("CPF:"), 0, 1); grid.add(txtCpf, 1, 1);
            grid.add(new Label("Matrícula:"), 0, 2); grid.add(txtMatricula, 1, 2);
            grid.add(new Label("Data Nascimento:"), 0, 3); grid.add(dpDataNascimento, 1, 3);
            grid.add(new Label("Patente:"), 0, 4); grid.add(cbPatente, 1, 4);
            grid.add(new Label("Especialidade:"), 0, 5); grid.add(cbEspecialidade, 1, 5);
            grid.add(new Label("Contato:"), 0, 6); grid.add(txtContato, 1, 6);
            grid.add(new Label("Status:"), 0, 7); grid.add(cbStatus, 1, 7);

            Button btnSalvar = new Button("Salvar");
            btnSalvar.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 16; -fx-cursor: hand;");
            btnSalvar.setOnAction(e -> salvar());

            this.getChildren().addAll(titleLabel, grid, btnSalvar);
        }

        public void prepararNovo() {
            this.ehEdicao = false;
            this.bombeiroAtual = new Bombeiro();
            titleLabel.setText("Novo Registro de Bombeiro");
            txtMatricula.setDisable(false);
            limparCampos();
        }

        public void prepararEdicao(Bombeiro b) {
            this.ehEdicao = true;
            this.bombeiroAtual = b;
            titleLabel.setText("Editar Bombeiro");
            txtMatricula.setDisable(true);

            txtNome.setText(b.getNome());
            txtCpf.setText(b.getCpf());
            txtMatricula.setText(b.getMatricula());
            dpDataNascimento.setValue(b.getDataNascimento());
            cbPatente.setValue(b.getPatente());
            cbEspecialidade.setValue(b.getEspecialidade());
            txtContato.setText(b.getContato());
            cbStatus.setValue(b.getStatus());
        }

        private void limparCampos() {
            txtNome.clear(); txtCpf.clear(); txtMatricula.clear();
            dpDataNascimento.setValue(null);
            cbPatente.getSelectionModel().clearSelection();
            cbEspecialidade.getSelectionModel().clearSelection();
            txtContato.clear();
            cbStatus.setValue(StatusBombeiro.ATIVO);
        }

        private void salvar() {
            bombeiroAtual.setNome(txtNome.getText());
            bombeiroAtual.setCpf(txtCpf.getText());
            bombeiroAtual.setMatricula(txtMatricula.getText());
            bombeiroAtual.setDataNascimento(dpDataNascimento.getValue());
            bombeiroAtual.setPatente(cbPatente.getValue());
            bombeiroAtual.setEspecialidade(cbEspecialidade.getValue());
            bombeiroAtual.setContato(txtContato.getText());
            bombeiroAtual.setStatus(cbStatus.getValue());

            Optional<String> erro = service.validar(bombeiroAtual, !ehEdicao);
            if (erro.isPresent()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, erro.get());
                alert.showAndWait();
                return;
            }

            service.salvar(bombeiroAtual, !ehEdicao);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Bombeiro salvo com sucesso!");
            alert.showAndWait();

            if (onSaveSuccess != null) onSaveSuccess.accept(null);
        }
    }

    public static class BombeiroListView extends VBox {
        private final BombeiroService service;
        private final TableView<Bombeiro> table = new TableView<>();

        public BombeiroListView(BombeiroService service, Consumer<Bombeiro> onEdit) {
            this.service = service;
            this.setSpacing(15);
            this.setPadding(new Insets(20));

            Label title = new Label("Consulta de Bombeiros");
            title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

            TextField txtFiltroNome = new TextField();
            txtFiltroNome.setPromptText("Buscar por nome...");

            ComboBox<Patente> cbFiltroPatente = new ComboBox<>();
            cbFiltroPatente.setPromptText("Patente");
            cbFiltroPatente.getItems().setAll(Patente.values());

            ComboBox<StatusBombeiro> cbFiltroStatus = new ComboBox<>();
            cbFiltroStatus.setPromptText("Status");
            cbFiltroStatus.getItems().setAll(StatusBombeiro.values());

            Button btnFiltrar = new Button("Filtrar");
            btnFiltrar.setOnAction(e -> service.setFiltro(
                    txtFiltroNome.getText(),
                    cbFiltroPatente.getValue(),
                    cbFiltroStatus.getValue()
            ));

            Button btnLimpar = new Button("Limpar");
            btnLimpar.setOnAction(e -> {
                txtFiltroNome.clear();
                cbFiltroPatente.getSelectionModel().clearSelection();
                cbFiltroStatus.getSelectionModel().clearSelection();
                service.limparFiltro();
            });

            HBox filterBox = new HBox(10, txtFiltroNome, cbFiltroPatente, cbFiltroStatus, btnFiltrar, btnLimpar);

            TableColumn<Bombeiro, String> colMatricula = new TableColumn<>("Matrícula");
            colMatricula.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getMatricula()));

            TableColumn<Bombeiro, String> colNome = new TableColumn<>("Nome");
            colNome.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getNome()));

            TableColumn<Bombeiro, String> colPatente = new TableColumn<>("Patente");
            colPatente.setCellValueFactory(d -> new SimpleStringProperty(
                    d.getValue().getPatente() != null ? d.getValue().getPatente().getNome() : ""));

            TableColumn<Bombeiro, String> colEspecialidade = new TableColumn<>("Especialidade");
            colEspecialidade.setCellValueFactory(d -> new SimpleStringProperty(
                    d.getValue().getEspecialidade() != null ? d.getValue().getEspecialidade().getNome() : ""));

            TableColumn<Bombeiro, String> colStatus = new TableColumn<>("Status");
            colStatus.setCellValueFactory(d -> new SimpleStringProperty(
                    d.getValue().getStatus() != null ? d.getValue().getStatus().getLabel() : ""));

            TableColumn<Bombeiro, Void> colAcoes = new TableColumn<>("Ações");
            colAcoes.setCellFactory(param -> new TableCell<>() {
                private final Button btnEditar = new Button("Editar");
                private final Button btnExcluir = new Button("Excluir");
                private final HBox box = new HBox(5, btnEditar, btnExcluir);

                {
                    btnEditar.setStyle("-fx-background-color: #eab308; -fx-text-fill: white; -fx-cursor: hand;");
                    btnExcluir.setStyle("-fx-background-color: #ef4444; -fx-text-fill: white; -fx-cursor: hand;");

                    btnEditar.setOnAction(e -> {
                        Bombeiro b = getTableView().getItems().get(getIndex());
                        if (onEdit != null) onEdit.accept(b);
                    });

                    btnExcluir.setOnAction(e -> {
                        Bombeiro b = getTableView().getItems().get(getIndex());
                        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Deseja excluir " + b.getNome() + "?", ButtonType.YES, ButtonType.NO);
                        Optional<ButtonType> result = confirmation.showAndWait();
                        if (result.isPresent() && result.get() == ButtonType.YES) {
                            service.excluir(b);
                        }
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    setGraphic(empty ? null : box);
                }
            });

            table.getColumns().addAll(colMatricula, colNome, colPatente, colEspecialidade, colStatus, colAcoes);
            table.setItems(service.getFilteredBombeiros());
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            this.getChildren().addAll(title, filterBox, table);
        }

        public void refresh() { table.refresh(); }
    }

    public static void main(String[] args) {
        launch(args);
    }
}