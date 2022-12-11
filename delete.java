import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


class customer_details{
	String CName ;
	long CMobileNo;
	String CCoupon;
	double CDiscount;
	
	public void details(String CName,long CMobileNo,String CCoupon){
		this.CName = CName;
		this.CMobileNo = CMobileNo;
		this.CCoupon = CCoupon ;
		if (CCoupon.length()==5){
			CDiscount = 10.0;
		}
		else{
			CDiscount = 5.0;
		}	
	}

	public void printDetails(){
		System.out.println("\nCUSTOMER NAME\t\t: "+CName);
		System.out.println("CUSTOMER MOBILE NO.\t: "+CMobileNo);
	}
}


class rstrnt_dtls extends customer_details{
	Scanner scan = new Scanner(System.in);
	ArrayList<Integer> OS = new ArrayList<>();
	ArrayList<String> OI = new ArrayList<>();
	ArrayList<Integer> OQ = new ArrayList<>();
	ArrayList<Integer> OC = new ArrayList<>();
	ArrayList<Integer> OT = new ArrayList<>();

	public static String RName = "ABC FAMILY A/C RESTAURANT";
	public double RRating  = 4.6;
	public static String RAddress ="12-256,RTC Complex,Visakhapatnam";

	public Double FinalPrice = 0.0;
	public String getCoupon = "";

	String [] listA = {"Idly","Dosa","Chapati","Puri","Coffee","Tea","Cool Drink","Water"};
	int [] costA = {20,30,50,40,20,10,50,10};

	public rstrnt_dtls(){
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n"+"*  Restaurent Name   : "+RName+"\t*");
		System.out.println("*  Restaurent Rating : "+RRating+"\t\t\t\t*");
		System.out.println("*  Restauret Address : "+RAddress+" *"+"\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

		System.out.println("List Of Item's:\n-------------");
		
		for (int i=0 ; i<listA.length ; i++){
			System.out.println((i+1)+". "+listA[i]+"---"+costA[i]+" Rs.");
		}
		System.out.println("\t0  ---> Exit");
	}

	public void orderItem(){
		int sl = 0;

		while(true){
			System.out.print("Enter Number to Choose Item : ");
		    int n = scan.nextInt();
		    scan.nextLine();
		    if (n >0 && n < (listA.length+1)){
				
				System.out.print("Enter Number for Item Quantity : ");
		        int m = scan.nextInt();
		        scan.nextLine();
				if(m>0){
					sl++;
					OS.add(sl);
					OI.add(listA[(n-1)]);
				    OC.add(costA[(n-1)]);
					OQ.add(m);
					OT.add((costA[(n-1)]*m));
				}
				else{
					System.out.println("Please choose Valid Quantity");
				}
			}
			else{
				break;
			}
		}
		
	}

	public void printOrderDetails(){
		System.out.println("\n==================================================\n\t\tBilling Order Details\n==================================================");
		System.out.println("Sl.No\tItem\tCost\tQuantity\tTotalCost");
		for(int i=0 ; i < OS.size() ; i++){
			System.out.println(OS.get(i)+"\t"+OI.get(i)+"\t"+OC.get(i)+"\t"+OQ.get(i)+"\t\t"+OT.get(i)+"\t");
		}
	
		
		Double totalAmount =0.0;
		for(int i : OT){
			totalAmount+=i;
		}
		System.out.println("\t\t\tTOTAL AMOUNT : "+totalAmount);

		System.out.println("You Got "+super.CDiscount+"%  Discount on your Bill..");
		Double DiscountPrice = totalAmount * (super.CDiscount/100);
		FinalPrice = totalAmount-DiscountPrice;
		System.out.println("==================================================\nAfter Discount Total Amount to Pay :"+(totalAmount-DiscountPrice)+"\n==================================================");
	}

	public void final1(){
		String[] aa = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};
        Random ran = new Random();
        
        for(int i=0; i<5;i++){
            int indx = ran.nextInt(aa.length-1)+1;
            String sampl = aa[indx];
            this.getCoupon=getCoupon.concat(sampl);      
        }
        
		System.out.println("TOTAL AMOUNT : \t\t"+FinalPrice);
		System.out.println("--Congratulations--\n You Won COUPUN Code use it next time to get More Discount : "+getCoupon);
		
		System.out.print("Please provide your feedback out of 5 :");
		Double feedBack = scan.nextDouble();
		scan.nextLine();
		scan.close();
		RRating = (RRating+feedBack)/2;


		System.out.println("\n\t\t-----THANK YOU-----\n\t\t....Visit Again....");
	
	}
}


public class delete {
	private String Sample1;
	private long Sample2;
	private String Sample3;
	Scanner nn = new Scanner(System.in);
	public void data(){
		
		System.out.print("Enter Name :");
		String Sample1 = nn.nextLine();
		this.Sample1 =Sample1;

		System.out.print("Enter Mobile Number :");
		long Sample2 = nn.nextLong();
		nn.nextLine();
		this.Sample2 =Sample2;

		System.out.print("Enter Coupon Code :");
		String Sample3 = nn.nextLine();
		this.Sample3 =Sample3;

			
	}
	public static void main(String args[]) {

		delete d = new delete();
		
		d.data();

		rstrnt_dtls bb = new rstrnt_dtls();


		bb.details(d.Sample1,d.Sample2,d.Sample3);
		

		bb.orderItem();
		bb.printOrderDetails();

		bb.printDetails();

		bb.final1();

		d.nn.close();
		
	}
	
}
