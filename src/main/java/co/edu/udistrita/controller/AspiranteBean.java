package co.edu.udistrita.controller;

import java.io.Serializable;
import java.util.ArrayList;
import co.edu.udistrital.Aspiranteservice.AspiranteService;
import co.edu.udistrital.model.Aspirante;
import co.edu.udistrital.model.ProgAcad;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("asp")
@SessionScoped
public class AspiranteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Aspirante dto = new Aspirante();
	private AspiranteService service = new AspiranteService();

	public AspiranteBean() {
		service.cargarDatos();
	}

	public Aspirante getDto() {
		return dto;
	}

	public void setDto(Aspirante dto) {
		this.dto = dto;
	}

	public ArrayList<Aspirante> getListaAs() {
		return service.getListaAs();
	}

	public ArrayList<ProgAcad> getListaPa() {
		return service.getListaPa();
	}

	public String registrar() {
		service.registrar(dto);
		dto = new Aspirante(); // reinicia el formulario
		return null;
	}
}