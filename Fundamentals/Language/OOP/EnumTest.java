/*
interface RoomType{
	int ECONOMY = 1;
	int BUSINESS = 2;
	int EXECUTIVE = 3;
	int DELUXE = 4;
}
*/

enum RoomType{
	ECONOMY, BUSINESS, EXECUTIVE, DELUXE;
}

class HotelRoom{

	/*
	public static double getRent(int stay, int roomKind){
		double rate;
		switch(roomKind){
			case RoomType.ECONOMY:
				rate = 425;
				break;
			case RoomType.BUSINESS:
				rate = 550;
				break;
			case RoomType.EXECUTIVE:
				rate = 575;
				break;
			default:
				rate = 750;
				break;
		}
		return 1.05 * stay * rate;
	}
	*/

	public static double getRent(int stay, RoomType roomKind){
		double rate;
		switch(roomKind){
			case ECONOMY:
				rate = 425;
				break;
			case BUSINESS:
				rate = 550;
				break;
			case EXECUTIVE:
				rate = 575;
				break;
			default:
				rate = 750;
				break;
		}
		return 1.05 * stay * rate;
	}
}	

class EnumTest{

	public static void main(String[] args){
		int days = args.length == 0 ? 7 : Integer.parseInt(args[0]);
		System.out.printf("Total rent for ECONOMY type room is %.2f%n", 
			HotelRoom.getRent(days, RoomType.ECONOMY));
		System.out.printf("Total rent for BUSINESS type room is %.2f%n", 
			HotelRoom.getRent(days, RoomType.BUSINESS));
		System.out.printf("Total rent for EXECUTIVE type room is %.2f%n", 
			HotelRoom.getRent(days, RoomType.EXECUTIVE));
		System.out.printf("Total rent for DELUXE type room is %.2f%n", 
			HotelRoom.getRent(days, RoomType.DELUXE));
	}
}














