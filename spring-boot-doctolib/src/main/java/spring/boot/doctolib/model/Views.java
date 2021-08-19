package spring.boot.doctolib.model;

public class Views {

	public static class ViewCommon {}

	public static class ViewPersonne extends ViewCommon {}
	
	public static class ViewPatient extends ViewPersonne {}
	
	public static class ViewAdmin extends ViewPersonne {}
	
	public static class ViewRendezVous extends ViewCommon{}
	
	public static class ViewMotifConsultation extends ViewCommon{}
	
	public static class ViewPraticien extends ViewPersonne{}
	public static class ViewSpecialite extends ViewCommon{}
	
	public static class ViewPraticienSpecialite extends ViewCommon{}

	public static class ViewCreneauxHoraires extends ViewCommon {}
	
	public static class ViewAdresse extends ViewCommon {}
	
	public static class ViewLieux extends ViewCommon {}
}