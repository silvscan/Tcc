package br.com.bibliotecaVT.mb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.UploadedFile;

import br.com.bibliotecaVT.controle.VOControleAluno;
import br.com.bibliotecaVT.controle.VOControleAreaConhecimento;
import br.com.bibliotecaVT.controle.VOControleCurso;
import br.com.bibliotecaVT.controle.VOControleFaculdade;
import br.com.bibliotecaVT.controle.VOControleOrientador;
import br.com.bibliotecaVT.controle.VOControleTrabalho;
import br.com.bibliotecaVT.controle.VOPesquisa;
import br.com.bibliotecaVT.dao.DAO;
import br.com.bibliotecaVT.modelo.Aluno;
import br.com.bibliotecaVT.modelo.AreaConhecimento;
import br.com.bibliotecaVT.modelo.Curso;
import br.com.bibliotecaVT.modelo.Faculdade;
import br.com.bibliotecaVT.modelo.Orientador;
import br.com.bibliotecaVT.modelo.Trabalho;
import br.com.bibliotecaVT.modelo.Usuario;

@ManagedBean
@ViewScoped
public class CadastroBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Aluno aluno = new Aluno();
	private Orientador orientador = new Orientador();
	private Curso curso = new Curso();
	private Trabalho trabalho = new Trabalho();
	private Faculdade faculdade = new Faculdade();
	private AreaConhecimento areaConhecimento = new AreaConhecimento();
	private Usuario user = new Usuario();
	private long idAConhecimento;
	private List<AreaConhecimento> listAreasConhecimento;
	private List<Curso> listCursos;
	private List<Orientador> listOrientadores;
	private List<Aluno> listAlunos;
	private List<Trabalho> listTrabalhos;
	private List<Faculdade> listFaculdades;
	private String titTrabalho;
	private long codCurso;
	private long codFaculdade;
	private String cpfAluno;
	private String cpfOrientador;
	private File arquivoPDF;
	private VOControleAluno voControleAluno;
	private VOControleOrientador voControleOrientador;
	private VOControleAreaConhecimento voControleAreaConhecimento;
	private VOControleCurso voControleCurso;
	private VOControleTrabalho voControleTrabalho;
	private VOControleFaculdade voControleFaculdade;
	private UploadedFile file;  
	private String localArquivo;
	private int firstResult;
	private int maxResults;
	
	public void cadastrarAluno(){
		voControleAluno = new VOControleAluno();
		aluno.setCpf(Long.parseLong(tirarFormatacaoCPF(aluno.getCpfFormatado())));
		voControleAluno.cadastrarOuAtualizar(aluno);
		aluno = new Aluno();
		listarAlunos();
	}

	private String tirarFormatacaoCPF(String cpfFormatado) {
		String cpf = "";
		try{
			String [] array = cpfFormatado.split("-");
			String digito = array[1];
			String numero = array[0].replace("."," ").replaceAll(" ", "");
			cpf = numero.trim() + digito.trim();
		}catch(ArrayIndexOutOfBoundsException ae){
			ae.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cpf.trim();
	}

	private void listarAlunos() {
		voControleAluno = new VOControleAluno();
		this.listAlunos = voControleAluno.listarAlunos();
	}
	
	public void cadastrarOrientador(){
		voControleOrientador = new VOControleOrientador();
		orientador.setCpf(Long.parseLong(tirarFormatacaoCPF(orientador.getCpfFormatado())));
		voControleOrientador.cadastrarOuAtualizar(orientador);
	}
	
	public List<AreaConhecimento> getListAreasConhecimento(){
		if (listAreasConhecimento == null) {
			voControleAreaConhecimento = new VOControleAreaConhecimento();
			this.listAreasConhecimento = voControleAreaConhecimento.listarAreas();
		}
		return listAreasConhecimento;
	}
	
	public List<Curso> getListCursos(){
		if (listCursos == null) {
			voControleCurso = new VOControleCurso();
			this.listCursos = voControleCurso.listarCursos();
		}
		return listCursos;
	}
	
	public List<Faculdade> getListFaculdades(){
		if (listFaculdades == null) {
			voControleFaculdade = new VOControleFaculdade();
			this.listFaculdades = voControleFaculdade.listarFaculdades();
		}
		return listFaculdades;
	}
	
	public List<Orientador> getListOrientadores(){
		if (listOrientadores == null) {
			voControleOrientador = new VOControleOrientador();
			this.listOrientadores = voControleOrientador.listarOrientadores();
		}
		return listOrientadores;
	}
	
	public List<Aluno> getListAlunos(){
		if (listAlunos == null) {
			listarAlunos();
		}
		return listAlunos;
	}
	
	public void cadastrarCurso(){
		voControleCurso = new VOControleCurso();
		curso.setAreaConhecimento(new VOControleAreaConhecimento().buscaPorId(getIdAConhecimento()));
		voControleCurso.cadastrar(curso);
	}
	
	public void cadastrarTrabalho(){
		try {
			voControleTrabalho = new VOControleTrabalho();
			uploadArquivo();
			trabalho.setLocalArquivo(this.localArquivo);
			trabalho.setAluno(new VOControleAluno().buscaPorCPF(Long.parseLong(tirarFormatacaoCPF(this.cpfAluno))));
			trabalho.setOrientador(new VOControleOrientador().buscaPorCPF(Long.parseLong(tirarFormatacaoCPF(this.cpfOrientador))));
			trabalho.setCurso(new VOControleCurso().buscaPorId(this.codCurso));
			trabalho.setFaculdade(new VOControleFaculdade().buscaPorId(this.codFaculdade));
			
			
			voControleTrabalho.cadastrar(trabalho);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void cadastrarFaculdade(){
		voControleFaculdade = new VOControleFaculdade();
		voControleFaculdade.cadastrarFaculdade(this.faculdade);
	}
	
	public void cadastrarAreaConhecimento(){
		if (!this.areaConhecimento.getTitulo().trim().equals("")){
			DAO<AreaConhecimento> dao = new DAO<AreaConhecimento>(AreaConhecimento.class);
			try {
				dao.adiciona(areaConhecimento);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , "Cadastro realizado com sucesso"));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Erro ao efetuar o cadastro."));
				e.printStackTrace();
			}
		}
	}
	
	public void cadastrarUsuario(){
		try {
			if (!("".equals(this.user.getLogin().trim()) && "".equals(this.user.getSenha()))){
				DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
				dao.adiciona(this.user);
				this.user = new Usuario();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , "Cadastro realizado com sucesso"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não permitido" , "Usuário e senha obrigatórios"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , "Não foi possível realizar o cadastro de usuário"));
		}
	}
	
	public void remove(Aluno aluno){
		try{	
			DAO<Aluno> dao = new DAO<Aluno>(Aluno.class);
			dao.remove(aluno);
			this.listAlunos = dao.listaTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , " Registro excluido com sucesso"));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , " Registro não pode ser excluído"));
		}
	}
	
	public void remove(AreaConhecimento ac){
		try{
			DAO<AreaConhecimento> dao = new DAO<AreaConhecimento>(AreaConhecimento.class);
			dao.remove(ac);
			this.listAreasConhecimento = dao.listaTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , " Registro excluido com sucesso"));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , " Registro não pode ser excluído"));
		}
	}
	
	public void remove(Curso c){
		try{
			DAO<Curso> dao = new DAO<Curso>(Curso.class);
			dao.remove(c);
			this.listCursos = dao.listaTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , " Registro excluido com sucesso"));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , " Registro não pode ser excluído"));
		}
	}
	
	public void remove(Orientador ori){
		try{
			DAO<Orientador> dao = new DAO<Orientador>(Orientador.class);
			dao.remove(ori);
			this.listOrientadores = dao.listaTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , " Registro excluido com sucesso"));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , " Registro não pode ser excluído"));
		}
	}
	
	public void remove(Faculdade facul){
		try{
			DAO<Faculdade> dao = new DAO<Faculdade>(Faculdade.class);
			dao.remove(facul);
			this.listFaculdades = dao.listaTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , " Registro excluido com sucesso"));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , " Registro não pode ser excluído"));
		}
	}
	
	public void remove(Trabalho tra){
		try{
			DAO<Trabalho> dao = new DAO<Trabalho>(Trabalho.class);
			dao.remove(tra);
			this.listTrabalhos = dao.listaTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , " Registro excluido com sucesso"));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , " Registro não pode ser excluído"));
		}
	}
	
	
	private void uploadArquivo() throws FileNotFoundException, IOException {
		try{
	        FacesContext aFacesContext = FacesContext.getCurrentInstance();
	        ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
	        String realPath = context.getRealPath("/");
	        byte[] conteudo = this.file.getContents();
	        String caminho = realPath + "\\controlePatrimonio\\arquivos\\" + this.file.getFileName();
	        FileOutputStream fos = new FileOutputStream(caminho);
	        fos.write(conteudo);
	        fos.close();
	        this.localArquivo = "controlePatrimonio/arquivos/"+ this.file.getFileName();
		}catch(Exception e){
			throw(e);
		}
	}
	
	public void pesquisarTb(){
		VOPesquisa psq = new VOPesquisa();
		this.listTrabalhos = psq.pesquisarTrabalhos(this.codCurso, this.idAConhecimento, 0, 5);
	}
	
	public List<Trabalho> getListTrabalhosGeral(){
		if (listTrabalhos == null) {
			voControleTrabalho = new VOControleTrabalho();
			this.listTrabalhos = voControleTrabalho.listarTodos();
		}
		return listTrabalhos;
	}
	
	public void votar(Trabalho t){
		voControleTrabalho = new VOControleTrabalho();
		voControleTrabalho.cadastrarVoto(t.getId(),t.getScore());
	}
		
	public void onrate() {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:");  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
      
    public void oncancel() {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    } 
	
	public List<Trabalho> getListTrabalhos(){
		if (listTrabalhos == null){
			return getListTrabalhosGeral();
		}
		return this.listTrabalhos;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Orientador getOrientador() {
		return orientador;
	}
	
	public void setOrientador(Orientador orientador) {
		this.orientador = orientador;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Trabalho getTrabalho() {
		return trabalho;
	}
	
	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	public long getIdAConhecimento() {
		return idAConhecimento;
	}
	public void setIdAConhecimento(long idAConhecimento) {
		this.idAConhecimento = idAConhecimento;
	}

	public String getTitTrabalho() {
		return titTrabalho;
	}

	public void setTitTrabalho(String titTrabalho) {
		this.titTrabalho = titTrabalho;
	}

	public long getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(long codCurso) {
		this.codCurso = codCurso;
	}

	public File getArquivoPDF() {
		return arquivoPDF;
	}

	public void setArquivoPDF(File arquivoPDF) {
		this.arquivoPDF = arquivoPDF;
	}
	
	public UploadedFile getFile() {  
        return file;  
    }  
  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }

	public String getLocalArquivo() {
		return localArquivo;
	}

	public void setLocalArquivo(String localArquivo) {
		this.localArquivo = localArquivo;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public long getCodFaculdade() {
		return codFaculdade;
	}

	public void setCodFaculdade(long codFaculdade) {
		this.codFaculdade = codFaculdade;
	}

	public Faculdade getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(Faculdade faculdade) {
		this.faculdade = faculdade;
	}  
	
	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getCpfOrientador() {
		return cpfOrientador;
	}

	public void setCpfOrientador(String cpfOrientador) {
		this.cpfOrientador = cpfOrientador;
	}
	
	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
}
