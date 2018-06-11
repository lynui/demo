/**
 * 
 */
package self.demo.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author liufei45
 * 全球坐标
 *
 */
public class Geo extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8165209206121181052L;

	/**
	 * 经度[-180.0, 180.0]
	 */
	@DecimalMax(
            value = "180.0",
            message = "The top lat ${formatter.format('%1$.2f', validatedValue)} is max " +
                    "than {value}"
    )
	@DecimalMin(
            value = "-180.0",
            message = "The top lat ${formatter.format('%1$.2f', validatedValue)} is min " +
                    "than {value}"
    )
	private Double lat;
	
	/**
	 * 纬度[-180.0, 180.0]
	 */
	@DecimalMax(
            value = "180.0",
            message = "The top lat ${formatter.format('%1$.2f', validatedValue)} is max " +
                    "than {value}"
    )
	@DecimalMin(
            value = "-180.0",
            message = "The top lat ${formatter.format('%1$.2f', validatedValue)} is min " +
                    "than {value}"
    )
	private Double lng;
	
	/**
	 * 半径[0.0, 50000.0](m)
	 */
	private Double distance;
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	@NotEmpty(message = "test1 Message name must not be blank!")
	private String test1;
	public String getTest1() {
		return test1;
	}
	public void setTest1(String test1) {
		this.test1 = test1;
	}

	
}
