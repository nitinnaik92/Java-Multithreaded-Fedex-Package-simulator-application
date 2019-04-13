package myproject;

public class packageobject {
	
	private int trackid;
	private int weight;
	private int pieces;
	private String source;
	private String destination;
	private String dimension;
	private String present;
	
	public String getPresent() {
		return present;
	}


	public void setPresent(String present) {
		this.present = present;
	}


	public int getPieces() {
		return pieces;
	}


	public void setPieces(int pieces) {
		this.pieces = pieces;
	}


	public packageobject() {
		this.trackid=trackid;
		this.weight=weight;
		this.source=source;
		this.destination=destination;
		this.dimension=dimension;
		this.pieces=pieces;
	}
	
	String [] city = {"Northborough, MA","Edison, NJ","Pittsburgh, PA","Allentown, PABD Strap Endlinksth","Martinsburg, WV","Charlotte, NC","Atlanta, GA","Orlando, FL","Memphis, TN","Grove City, OH","Indianapolis, IN","Detroit, MI","New Berlin, WI","Minneapolis, MN","St. Louis, MO","Kansas, KS","Dallas, TX","Houston, TX","Denver, CO","Salt Lake City, UT","Phoenix, AZ","Los Angeles, CA","Chino, CA","Sacramento, CA","Seattle, WA"};
	
	public int getTrackid() {
		return trackid;
	}


	public void setTrackid(int trackid) {
		this.trackid = trackid;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
	
	}


	public String getSource() {
		return source;
		
	}


	public void setSource(String source) {
		this.source=source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination=destination;
			
	}


	public String getDimension() {
		return dimension;
	}


	public void setDimension(String dimension) {
        this.dimension=dimension;
		
	}


	
	
	

}
