package com.springboot.proyectoFinal;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProyectoFinalApplicationTests {

	Calculadora calculadora = new Calculadora();
	@Test
	@DisplayName("Nombre de la prueba")
	void sumaDeValores(){
		//given (Armado del contexto)
		int valorA = 2;
		int valorB = 3;

		//when (La acción que vamos a realizar)
		int resultado = calculadora.sumar(valorA,valorB);

		//Then (comparar el resultado esperado)
		int resultadoEsperado = 5;
		assertThat(resultado).isEqualTo(resultadoEsperado);
	}

	@Test
	@DisplayName("Test deprecado")
	@Disabled("Test deprecado")
	void testDesactivado(){

	}

	class Calculadora{
		int sumar(int valor_a, int valor_b){
			return valor_a + valor_b;
		}
	}

}
