package lexicon.task;

public class OrderHelper {
	public final String getCurrency() {
		return "kr";
	}

	public final Integer getMainDishPrice(Dish dish) {
		switch (dish) {
		case SALMON_HALVARSSON:
			return 135;
		case LEMMING_RAGU:
			return 130;
		case FIVE_FINGER_LOVE_PUNCH:
			return 145;
		case MOBY_DICKS_LASAGNA:
			return 99;
		case LEOS_JOLLOF_RICE:
			return 100;
		case NO_DISH:
			return 0;
		}
		return 0;
	}

	public final String getMainDishName(Dish dish) {
		switch (dish) {
		case SALMON_HALVARSSON:
			return "Salmon Halvarsson";
		case LEMMING_RAGU:
			return "Lemming Ragu";
		case FIVE_FINGER_LOVE_PUNCH:
			return "Five Finger Love Punch";
		case MOBY_DICKS_LASAGNA:
			return "Moby Dick's Lasagna";
		case LEOS_JOLLOF_RICE:
			return "Leo's Jollof Rice";
		case NO_DISH:
			return "No dish";
		}
		return "fatal: unknown dish";
	}

	public final Integer getAddonPrice() {
		return 15;
	}

	public final Integer getDrinkPrice(Drink drink) {
		switch (drink) {
		case BEER:
			return 60;
		case LIME_WATER:
			return 20;
		case LEMON_WATER:
			return 30;
		case MINERAL_WATER:
			return 22;
		case RED_WINE:
			return 55;
		case NO_DRINK:
			return 0;
		}
		return 0;
	}

	public final String getDrinkName(Drink drink) {
		switch (drink) {
		case BEER:
			return "Beer";
		case LIME_WATER:
			return "Lime water";
		case LEMON_WATER:
			return "Lime water";
		case MINERAL_WATER:
			return "Mineral water";
		case RED_WINE:
			return "Red wine";
		case NO_DRINK:
			return "No drink";
		}
		return "fatal: unknown drink";
	}
}
