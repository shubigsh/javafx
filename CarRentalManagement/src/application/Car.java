package application;

public class Car {
	 private int car_id;
	    private String car_name;
	    private String model;
	    private String color;
	    private int year;
	    private String plate_no;
	    private int emp_id;
	    private String status;

	    public Car(int car_id, String car_name, String model, String color, int year, String plate_no, int emp_id,String status) {
	        this.car_id = car_id;
	        this.car_name = car_name;
	        this.model = model;
	        this.color = color;
	        this.year = year;
	        this.plate_no = plate_no;
	        this.emp_id = emp_id;
	        this.status=status;
	    }
	    public int getCar_id() {
	        return car_id;
	    }

	    public String getCar_name() {
	        return car_name;
	    }

	    public String getModel() {
	        return model;
	    }

	    public String getColor() {
	        return color;
	    }

	    public int getYear() {
	        return year;
	    }

	    public String getPlate_no() {
	        return plate_no;
	    }

	    public int getEmp_id() {
	        return emp_id;
	    }
	    public String getStatus() {
	        return status;
	    }
	    // Setter methods
	    public void setCar_id(int car_id) {
	        this.car_id = car_id;
	    }

	    public void setCar_name(String car_name) {
	        this.car_name = car_name;
	    }

	    public void setModel(String model) {
	        this.model = model;
	    }

	    public void setColor(String color) {
	        this.color = color;
	    }

	    public void setYear(int year) {
	        this.year = year;
	    }

	    public void setPlate_no(String plate_no) {
	        this.plate_no = plate_no;
	    }

	    public void setEmp_id(int emp_id) {
	        this.emp_id = emp_id;
	    }
	    public void setStatus( String status) {
	        this.status = status;
	    }
}
