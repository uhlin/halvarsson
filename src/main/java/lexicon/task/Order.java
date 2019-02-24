package lexicon.task;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity /* This tells Hibernate to make a table out of this class */
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String time;

	@NotNull
	@Min(1)
	@Max(15)
	private Integer tableNo;

	@NotNull
	@Size(min = 2, max = 80)
	private String customer;

	@NotNull
	private Dish dish;

	private Boolean frenchFries;
	private Boolean rice;
	private Boolean bakedPotato;
	private Boolean potatoMash;
	private Boolean potatoWedges;

	@NotNull
	@Min(0)
	@Max(5)
	private Integer amountOfDrinks;

	@NotNull
	private Drink drink;

	@NotNull
	@Size(min = 0, max = 200)
	private String specialTreats;

	@NotNull
	@Size(min = 2, max = 80)
	private String employee;

/***************************************************
 *
 * Constructor
 *
 ***************************************************/

	public Order() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Timestamp timestamp  = new Timestamp(System.currentTimeMillis());

		time = sdf.format(timestamp);
	}

/***************************************************
 *
 * Getters/setters
 *
 ***************************************************/

	public final Integer getOrderTotal() {
		OrderHelper helper = new OrderHelper();
		Integer total = 0;

		total += helper.getMainDishPrice(dish);
		if (frenchFries)
			total += helper.getAddonPrice();
		if (rice)
			total += helper.getAddonPrice();
		if (bakedPotato)
			total += helper.getAddonPrice();
		if (potatoMash)
			total += helper.getAddonPrice();
		if (potatoWedges)
			total += helper.getAddonPrice();
		total += (helper.getDrinkPrice(drink) * amountOfDrinks);
		return total;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}



	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}



	public Integer getTableNo() {
		return tableNo;
	}
	public void setTableNo(Integer tableNo) {
		this.tableNo = tableNo;
	}



	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}



	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}



	public Boolean getFrenchFries() {
		return frenchFries;
	}
	public void setFrenchFries(Boolean frenchFries) {
		this.frenchFries = frenchFries;
	}



	public Boolean getRice() {
		return rice;
	}
	public void setRice(Boolean rice) {
		this.rice = rice;
	}



	public Boolean getBakedPotato() {
		return bakedPotato;
	}
	public void setBakedPotato(Boolean bakedPotato) {
		this.bakedPotato = bakedPotato;
	}



	public Boolean getPotatoMash() {
		return potatoMash;
	}
	public void setPotatoMash(Boolean potatoMash) {
		this.potatoMash = potatoMash;
	}



	public Boolean getPotatoWedges() {
		return potatoWedges;
	}
	public void setPotatoWedges(Boolean potatoWedges) {
		this.potatoWedges = potatoWedges;
	}



	public Integer getAmountOfDrinks() {
		return amountOfDrinks;
	}
	public void setAmountOfDrinks(Integer amountOfDrinks) {
		this.amountOfDrinks = amountOfDrinks;
	}
	public Drink getDrink() {
		return drink;
	}
	public void setDrink(Drink drink) {
		this.drink = drink;
	}



	public String getSpecialTreats() {
		return specialTreats;
	}
	public void setSpecialTreats(String specialTreats) {
		this.specialTreats = specialTreats;
	}



	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
}
