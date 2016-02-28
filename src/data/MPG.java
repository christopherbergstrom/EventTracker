package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="tracker")
public class MPG
{
//	Table: TripDescription, MilesDriven, GallonsPurchased, PriceOfGas
//
//	Gives: Mpg, TotalSpent, CostPerMile, TotalMiles
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tripDescription;
	private int milesDriven;
	private int gallonsPurchased;
	private double priceOfGas;
	
	public MPG()
	{
	}
	public MPG(int id, String tripDescription, int milesDriven, int gallonsPurchased, double priceOfGas)
	{
		this.id = id;
		this.tripDescription = tripDescription;
		this.milesDriven = milesDriven;
		this.gallonsPurchased = gallonsPurchased;
		this.priceOfGas = priceOfGas;
	}
	
	public String getTripDescription()
	{
		return tripDescription;
	}
	public void setTripDescription(String tripDescription)
	{
		this.tripDescription = tripDescription;
	}
	public int getMilesDriven()
	{
		return milesDriven;
	}
	public void setMilesDriven(int milesDriven)
	{
		this.milesDriven = milesDriven;
	}
	public int getGallonsPurchased()
	{
		return gallonsPurchased;
	}
	public void setGallonsPurchased(int gallonsPurchased)
	{
		this.gallonsPurchased = gallonsPurchased;
	}
	public double getPriceOfGas()
	{
		return priceOfGas;
	}
	public void setPriceOfGas(double priceOfGas)
	{
		this.priceOfGas = priceOfGas;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	@Override
	public String toString()
	{
		return "MPG [id=" + id + ", tripDescription=" + tripDescription + ", milesDriven=" + milesDriven
				+ ", gallonsPurchased=" + gallonsPurchased + ", priceOfGas=" + priceOfGas + "]";
	}
}
