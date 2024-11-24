package terst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.RevisaContrato;

class TestRevisaContrato {

	private RevisaContrato rv;
	
	@BeforeEach
	private void setup() {
		this.rv = new RevisaContrato();
	}
	
	@Test
	void testEfetuarRemocao() {		
		Assertions.assertEquals("000000", this.rv.efetuarRemocao("5000000", 5));
	}

	@Test
	void testFormatarNumero() {
		assertEquals("0", this.rv.formatarNumero("000000"));
	}

}
