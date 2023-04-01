import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PPF {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub\
		float amount = 0;
		float interestRateQ1 = 0;
		float interestRateQ2 = 0;
		float interestRateQ3 = 0;
		float interestRateQ4 = 0;
//		String startMonth = null;
//		String endMonth = null;
		Map<String, Float> monthAmountMap = new HashMap<>();
		try{
			amount = Float.parseFloat(args[0]);
			interestRateQ1 = Float.parseFloat(args[1]);
			interestRateQ2 = Float.parseFloat(args[2]);
			interestRateQ3 = Float.parseFloat(args[3]);
			interestRateQ4 = Float.parseFloat(args[4]);
//			startMonth = args[5];
//			endMonth = args[6];
			monthAmountMap = new HashMap<>();
			for(int i = 5;i<args.length;i=i+2){
				monthAmountMap.put(args[i], Float.parseFloat(args[i+1]));
			}
		}catch (Exception e) {
			throw new Exception("Error While Reading : Input should be in following format : intialamount(number), "
					+ "Q1IntRate(number), Q2IntRate(number), Q3IntRate(number), Q4IntRate(number), Month1(STRING eg: APRIL), Amount1(number), Month2(STRING eg: MAY), Amount2(number), ... ,Month n, Amount n");
		}

		int start = 1;//month.valueOf(startMonth).getNumVal();
		int end = 12;//month.valueOf(endMonth).getNumVal();

		System.out.println("\tinitial amount : " + amount + "\n");
		float interestamount = 0;
		for(int i=start;i<=end;i++){
			 	amount = amount + addcurrentmonthAmt(i,monthAmountMap);
			if(i<=3){
				interestamount += ((amount * interestRateQ1)/100)/12;	
			}else if(i<=6){
				interestamount += ((amount * interestRateQ2)/100)/12;
			}else if(i<=9){
				interestamount += ((amount * interestRateQ3)/100)/12;
			}else{
				interestamount += ((amount * interestRateQ4)/100)/12;
			}	
			System.out.println("interest amount at the end of " + i + " month " + interestamount );
		}
		amount += interestamount;
		System.out.println("\n\n\t final amount : " + amount);


	}
	private static float addcurrentmonthAmt(int i, Map<String, Float> monthAmountMap) {
		// TODO Auto-generated method stub
		float amount = 0;
		for (Entry<String, Float> entry : monthAmountMap.entrySet()) {
			if(month.valueOf(entry.getKey()).getNumVal() == i){
				amount = entry.getValue();
			}
		}
		return amount;
	}
	
	enum month{
		APRIL(1),MAY(2),JUNE(3),JULY(4),AUGUST(5),SEPTEMBER(6),OCTOBER(7),NOVEMBER(8),DECEMBER(9),JANUARY(10),FEBRUARY(11),MARCH(12);	


		private int numVal;

		month(int numVal) {
			this.numVal = numVal;
		}

		public int getNumVal() {
			return numVal;
		}
	}

}
