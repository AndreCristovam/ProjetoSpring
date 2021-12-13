package br.com.primeiroprojetospring.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.primeiroprojetospring.domain.Acessorio;
import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.domain.Carro;
import br.com.primeiroprojetospring.domain.Chave;
import br.com.primeiroprojetospring.domain.Documento;
import br.com.primeiroprojetospring.domain.Fabricante;
import br.com.primeiroprojetospring.domain.Permissao;
import br.com.primeiroprojetospring.domain.Role;
import br.com.primeiroprojetospring.domain.Usuario;
import br.com.primeiroprojetospring.service.AcessorioService;
import br.com.primeiroprojetospring.service.AlunoService;
import br.com.primeiroprojetospring.service.CarroService;
import br.com.primeiroprojetospring.service.ChaveService;
import br.com.primeiroprojetospring.service.CurrentUserDetailsService;
import br.com.primeiroprojetospring.service.DocumentoService;
import br.com.primeiroprojetospring.service.FabricanteService;
import br.com.primeiroprojetospring.service.PermissaoService;
import br.com.primeiroprojetospring.service.RoleService;


@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private FabricanteService fabricanteService;

	@Autowired
	private ChaveService chaveService;

	@Autowired
	private AcessorioService acessorioService;

	@Autowired
	private DocumentoService documentoService;
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private CurrentUserDetailsService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissaoService permissaoService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Aluno aluno1 = new Aluno();
		aluno1.setNome("Julia");
		alunoService.salvar(aluno1);

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Juliano");
		alunoService.salvar(aluno2);

		Aluno aluno3 = new Aluno();
		aluno3.setNome("Antônio");
		alunoService.salvar(aluno3);

		Chave chave1 = new Chave();
		chave1.setCodigo("15421");
		chaveService.salvar(chave1);

		Chave chave2 = new Chave();
		chave2.setCodigo("66564");
		chaveService.salvar(chave2);

		Chave chave3 = new Chave();
		chave3.setCodigo("33321");
		chaveService.salvar(chave3);

		Chave chave4 = new Chave();
		chave4.setCodigo("2333");
		chaveService.salvar(chave4);

		Fabricante f1 = new Fabricante();
		f1.setNome("FIAT");
		f1.setPais("ITALIA");
		fabricanteService.salvar(f1);

		Fabricante f2 = new Fabricante();
		f2.setNome("BMW");
		f2.setPais("ALEMANHA");
		fabricanteService.salvar(f2);

		Fabricante f3 = new Fabricante();
		f3.setNome("OPEL");
		f3.setPais("EUA");
		fabricanteService.salvar(f3);

		Documento doc1 = new Documento();
		doc1.setCodigo("1232");
		doc1.setNome("ABC");
		documentoService.salvar(doc1);

		Documento doc2 = new Documento();
		doc2.setCodigo("33321");
		doc2.setNome("ASS");
		documentoService.salvar(doc2);

		Documento doc3 = new Documento();
		doc3.setCodigo("3468");
		doc3.setNome("PPA");
		documentoService.salvar(doc3);

		Acessorio a1 = new Acessorio();
		a1.setNome("Teto Solar");
		acessorioService.salvar(a1);

		Acessorio a2 = new Acessorio();
		a2.setNome("Vidro Eletrico");
		acessorioService.salvar(a2);

		Acessorio a3 = new Acessorio();
		a3.setNome("Banco Couro");
		acessorioService.salvar(a3);
		
		Carro c1 = new Carro();
		c1.setAcessorios(Arrays.asList(a2, a1));
		c1.setChaveCarro(chave1);
		c1.setDocumentoCarro(doc1);
		c1.setFabricanteCarro(f1);
		c1.setModelo("ABC");
		carroService.salvar(c1);

		Carro c2 = new Carro();
		c2.setAcessorios(Arrays.asList(a1, a3));
		c2.setChaveCarro(chave2);
		c2.setDocumentoCarro(doc3);
		c2.setFabricanteCarro(f2);
		c2.setModelo("SSD");
		carroService.salvar(c2);

		Carro c3 = new Carro();
		c3.setAcessorios(Arrays.asList(a3));
		c3.setChaveCarro(chave3);
		c3.setDocumentoCarro(doc2);
		c3.setFabricanteCarro(f3);
		c3.setModelo("WEW");
		carroService.salvar(c3);

		Carro c4 = new Carro();
		c4.setAcessorios(Arrays.asList(a2, a3, a1));
		c4.setChaveCarro(chave4);
		c4.setDocumentoCarro(doc2);
		c4.setFabricanteCarro(f3);
		c4.setModelo("DDS");
		carroService.salvar(c4);	
		
		//############################################
		
		Usuario usuario = new Usuario();
		usuario.setNomeCompleto("Yuri Rocha");
		usuario.setLogin("admin");
		usuario.setPassword(new BCryptPasswordEncoder().encode("1234"));

		Role roleAdmin = new Role();
		roleAdmin.setNomeRole(Role.ROLE_ADMIN);

		roleService.salvar(roleAdmin);

		usuario.setRoles(Arrays.asList(roleAdmin));

		usuarioService.salvar(usuario);
		
		
		//############################################
		
		Usuario usuario2 = new Usuario();
		usuario2.setNomeCompleto("Sandro Nelson");
		usuario2.setLogin("SandNel");
		usuario2.setPassword(new BCryptPasswordEncoder().encode("12345"));
		
		Role roleUser = new Role();
		roleUser.setNomeRole(Role.ROLE_USER);
		roleService.salvar(roleUser);
		
		usuario2.setRoles(Arrays.asList(roleUser));
		usuarioService.salvar(usuario2);
		
		Permissao permissaoUser = new Permissao();
		permissaoUser.setNomePermissao(Permissao.INSERT);
		permissaoService.salvar(permissaoUser);
		
		usuario2.setPermissoes(Arrays.asList(permissaoUser));
		usuarioService.salvar(usuario2);
		
		//############################################
		
		Usuario usuario3 = new Usuario();
		usuario3.setNomeCompleto("Fabricio");
		usuario3.setLogin("fabricio");
		usuario3.setPassword(new BCryptPasswordEncoder().encode("12345"));
		
		roleService.salvar(roleUser);
		
		usuario3.setRoles(Arrays.asList(roleUser));
		usuarioService.salvar(usuario3);
	}
	
	
	
}
