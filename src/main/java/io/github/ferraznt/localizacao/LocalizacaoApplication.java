package io.github.ferraznt.localizacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.ferraznt.localizacao.domain.service.CidadeService;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner{

	@Autowired
	private CidadeService cidadeService;

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" ---------------------------------------------------------------- ");
		System.out.println("---> Inicializando em Modo Command line...");

		System.out.println("---> Listando Tudo: ");
		cidadeService.listarCidades();

		System.out.println("---> Listando Por Nome: ");
		cidadeService.cidadesPorNome("Serra Talhada");

		System.out.println("---> Listando Por Habitantes: ");
		cidadeService.cidadesPorHabitantes(1234567L);

		System.out.println(" ---------------------------------------------------------------- ");
		System.out.println("---> Outras Buscas");
		cidadeService.cidadeComecandoCom("Rec");

		cidadeService.cidadeTerminandoCom("Talhada");

		cidadeService.cidadeContendoNome("Jan");

		System.out.println("---> Usando Like: ");

		cidadeService.cidadeLikeNome("%Por%");
		
		System.out.println(" ---------------------------------------------------------------- ");

		cidadeService.cidadeLikeNomeNoCase("%rio%");

		System.out.println(" ---------------------------------------------------------------- ");
		
		cidadeService.listarCidadesPorQuantidadeMenor(1000001L);
		cidadeService.listarCidadesPorQuantidadeMaior(1000001L);
		
		System.out.println(" ---------------------------------------------------------------- ");


		cidadeService.listarCidadesPorQuaantENome(1000000000L,"Rec%");

	}



	

}
