import java.util.Scanner;

public class Date {

	private int month;
	private int day;
	private int year;
	
	public Date(int month, int day, int year){
		if(!isValid(month,day,year)){
			throw new IllegalArgumentException("Data Inválida");
		}
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public static boolean isValid(int month, int day, int year){
		if(month < 1 || month > 12){
			return false;
		}
		if(year < 0){
			return false;
		}
		if(day < 1 || day > dayInMonth(month, year)){
			return false;
		}
		return true;
	}
	
	public  static int dayInMonth(int month, int year){
		if(month==4 || month ==6 || month==9 || month==11){
			return 30;
		}
		if(month==2) {
			if(isLeapYear(year)){
				return 29;
			}
			return 28;
		}
	return 31;
	}
	
	public static boolean isLeapYear(int year) {
		if(year%4==0)
			return true;
		
		return false;
	}

	public int month(){
		return month;
	}
	
	public int day(){
		return day;
	}
	
	public int year(){
		return year;
	}
	
	public String toString(){
		return month + "/" + day + "/" + year;
	}
	
	public boolean before(Date other) {
		if(this.year>other.year) {
			return false;
		}
		if(this.month>other.month) {
			return false;
		}
		if(this.day>other.day) {
			return false;
		}
		return true;
	}
	
	public int daysSinceBeginYear()	{
		int cont= day - 1;
		 for (int m = 1; m < month; m++) {
			 cont += dayInMonth(m, year);
			}	
		return cont;
	}
	
	public int daysUntilEndYear() {
		int cont = dayInMonth(month, year) - day;
		for (int m = month + 1; m <= 12; m++) {
			cont += dayInMonth(m, year);
			}		
		return cont;
	}
	
	public int daysBetween(Date other) {	 
	    int cont = 0;
	   if(year==other.year) {		   
		   if(before(other)) {
			   cont = daysUntilEndYear() - other.daysUntilEndYear();
		   }else {		   
		   cont = other.daysUntilEndYear() - daysUntilEndYear();		   
	   }
	   } else {	      
	        if (before(other)) {
	            cont += daysUntilEndYear();	            
	            for (int y = year + 1; y < other.year; y++) {	            	
	            	if(isLeapYear(y)) {	            		
	            		cont += 366;	            		
	            	}else {	            		
	            		cont += 365;	            		
	            	}	                
	            }            
	            cont += other.daysSinceBeginYear();
	        } else {
	            cont += other.daysUntilEndYear();
	            for (int y = other.year + 1; y < year; y++) {
	            	if(isLeapYear(y)) {
	            		cont += 366;
	            	}else {
	            		cont += 365;
	            	}
	            }
	            cont += daysSinceBeginYear();
	        }
	    }
	    return cont;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduza o mês: ");
		int month = sc.nextInt();
		System.out.print("Introduza o dia: ");
		int day = sc.nextInt();
		System.out.print("Introduza o ano: ");
		int year = sc.nextInt();
		sc.close();
		
		Date d = new Date(month,day,year);
		Date other = new Date(10,20,2005);
		
		System.out.println("\nA data é: " + d);		
		if(d.before(other)) {			
			System.out.println("A data é antes de: " + other);			
			} else {								
			System.out.println("A data depois de: " + other);			
		}		
		System.out.println("Dias desde o início do ano: " + d.daysSinceBeginYear());
        System.out.println("Dias até o final do ano: " + d.daysUntilEndYear());	
        System.out.println("Dias entre " + d + " e " + other + ": " + d.daysBetween(other));
	}
}


