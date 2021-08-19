package spring.boot.doctolib.model;
import com.fasterxml.jackson.annotation.JsonView;

public class Views {
	public static class ViewCommon{}
	
	public static class ViewPersonne extends ViewCommon{}
	public static class ViewPraticien extends ViewPersonne{}
	public static class ViewSpecialite extends ViewCommon{}
	
	public static class ViewPraticienSpecialite extends ViewCommon{}

}
