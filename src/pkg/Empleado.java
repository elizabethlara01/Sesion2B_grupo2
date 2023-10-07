package pkg;

public class Empleado {
	public enum TipoEmpleado {
		Vendedor, Encargado
	};

	public static float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtras) {
		float salarioBase = 0, primas = 0, extras = 0;
		if (ventasMes >= 0 && horasExtras >= 0) {

			if (tipo == TipoEmpleado.Encargado) {
				salarioBase = 2500;
			} else if (tipo == TipoEmpleado.Vendedor) {
				salarioBase = 2000;
			} else {
				return -1;
			}

			if (ventasMes > 1500) {
				primas = 200;
			} else if (ventasMes >= 1000) {
				primas = 100;
			}

			extras = horasExtras * 30;

			return salarioBase + primas + extras;

		} else {
			return -1;
		}
	}

	public static float calculoNominaNeta(float nominaBruta) {
		float retencion = 0;
		if (nominaBruta >= 0) {
			if (nominaBruta > 2500) {
				retencion = 0.18f;

			} else if (nominaBruta > 2000) {
				retencion = 0.15f;
			}
			return nominaBruta * (1 - retencion);
		} else {
			return -1;

		}
	}
}
