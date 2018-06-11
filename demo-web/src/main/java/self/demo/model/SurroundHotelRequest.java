package self.demo.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author liufei45
 * 周边酒店请求
 */
public class SurroundHotelRequest extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6646302202476824140L;
	@NotNull(message = "geo Message name must not be blank!")
	private Geo geo;
	@NotNull(message = "page Message name must not be blank!")
	private Page page;
	
	public Geo getGeo() {
		return geo;
	}
	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	@NotEmpty(message = "Message name must not be blank!")
	private String test;
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
	private int test4;
	private Double test5;

	public int getTest4() {
		return test4;
	}
	public void setTest4(int test4) {
		this.test4 = test4;
	}
	public Double getTest5() {
		return test5;
	}
	public void setTest5(Double test5) {
		this.test5 = test5;
	}
}
