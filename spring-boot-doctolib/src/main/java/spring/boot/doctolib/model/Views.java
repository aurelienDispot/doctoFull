package spring.boot.doctolib.model;

public class Views {

	public static class ViewCommon {}

	public static class ViewPersonne extends ViewCommon {}
	
	public static class ViewPatient extends ViewPersonne {}
	
	public static class ViewAdmin extends ViewPersonne {}
	public static class ViewRendezVous extends ViewCommon{}
	
	public static class ViewMotifConsultation extends ViewCommon{}
}