package co.edu.udistrital.CDTcontroller;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import co.edu.udistrital.CDTmodel.CDT;
import co.edu.udistrital.CDTservice.CDTService;

@Named("cdtBean")
@ViewScoped
public class CDTBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CDT dto = new CDT();
	private ArrayList<CDT> listaCdt;
	private CDTService service = new CDTService();

	public CDTBean() {
		super();
	}

	public String registrar() {
		service.registrar(dto);
		listaCdt = service.obtenerTodos();
		dto = new CDT();
		return "/CDT/resultadoscdt?faces-redirect=true";
	}

	public void cargarLista() {
		listaCdt = service.obtenerTodos();
	}

	public CDT getDto() {
		return dto;
	}

	public void setDto(CDT dto) {
		this.dto = dto;
	}

	public ArrayList<CDT> getListaCdt() {
		return listaCdt;
	}

	public void setListaCdt(ArrayList<CDT> l) {
		this.listaCdt = l;
	}
}