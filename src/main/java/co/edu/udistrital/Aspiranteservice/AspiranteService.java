package co.edu.udistrital.Aspiranteservice;

import java.time.LocalDate;
import java.util.ArrayList;
import co.edu.udistrital.model.Aspirante;
import co.edu.udistrital.model.AspiranteDAO;
import co.edu.udistrital.model.ProgAcad;
import co.edu.udistrital.model.ProgAcadDAO;

public class AspiranteService {

	private ArrayList<Aspirante> listaAs = AspiranteDAO.lista_A;
	private ArrayList<ProgAcad> listaPa = ProgAcadDAO.lista_P;

	public void cargarDatos() {
		ProgAcadDAO.cargaDatos();
	}

	public ArrayList<Aspirante> getListaAs() {
		return listaAs;
	}

	public ArrayList<ProgAcad> getListaPa() {
		return listaPa;
	}

	public void registrar(Aspirante dto) {
		dto.setFecha_reg(LocalDate.now());
		for (ProgAcad p : listaPa) {
			if (p.getCod() == dto.getPro_acad().getCod()) {
				dto.setPro_acad(p);
				break;
			}
		}
		listaAs.add(dto);
	}
}